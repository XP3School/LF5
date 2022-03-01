package de.X_P_3.executing;

import de.X_P_3.console.out.Output;
import de.X_P_3.console.out.OutputPrintStreamTypes;

public class MultiMain {
    public static final int directExecute = -1;
    public static final int borderLength = 20;
    public static final String[] directExecuteParameter = {};
    public static final boolean showFullClassName = false;

    public static MainClassExecuting classExecuting = new MainClassExecuting();

    public static String getBorder() {
        return "=".repeat(borderLength);
    }

    public static void main(String[] args) {
        Output output = new Output(OutputPrintStreamTypes.newLine, System.out);
        Output error = new Output(OutputPrintStreamTypes.newLine, System.err);
        output.print("\tloading classes...");

        int classCount = classExecuting.loadClasses();

        if (classCount == 0) {
            output.print("\tno class was found\n\texit");
            System.exit(0);
        } else if (classCount == 1)
            output.print("\tloaded 1 class:");
        else
            output.print("\tloaded " + classCount + " classes:");

        for (iMainExecutable executable : classExecuting.mains) {
            System.out.println("\t\t" + executable.getClass().getName());
        }
        System.out.print("\n\n\n");

        boolean repeat = true;
        boolean repeatExecute = true;
        while (repeat) {
            repeatExecute = true;
            int c = 0;
            for (iMainExecutable item : classExecuting.mains) {
                output.print("\t[" + c + "] | " + getClassName(item.getClass()));
                c++;
            }

            int classNumber;
            String[] executeParameter;
            if (directExecute == -1) {

                output.print("\n\tenter a the id of a class to execute, enter parameter separated with a space\n\t\t(3 parm1 parm2 parm3)");
                String input = iMainExecutable.SCANNER.nextLine();

                if (input.matches("\\d+( .+)*")) {
                    StringBuilder classNumberS = new StringBuilder();
                    for (char item : input.toCharArray()) {
                        if (Character.isDigit(item))
                            classNumberS.append(item);
                        else
                            break;
                    }
                    if (input.length() > classNumberS.length() + 1)
                        executeParameter = input.substring(classNumberS.length() + 1).split(" ");
                    else
                        executeParameter = new String[0];
                    classNumber = Integer.parseInt(classNumberS.toString());
                    if (classNumber > classCount - 1) {
                        error.print("invalid class id");
                        classNumber = -1;
                        executeParameter = null;
                        //System.exit(-1);
                        repeatExecute = false;
                    }
                } else {
                    error.print("Failed to compile \"" + input + "\"");
                    classNumber = -1;
                    executeParameter = null;
                    //System.exit(-1);
                    repeatExecute = false;
                }
            } else {
                classNumber = directExecute;
                executeParameter = directExecuteParameter;
            }


            while (repeatExecute) {

                iMainExecutable executeClass = classExecuting.getClassByPos(classNumber);
                output.print("\tstarting program\n\texecute class: " + getClassName(executeClass.getClass()) + "\n");

                System.out.println(getBorder());
                ExecuteReturn aReturn = MainClassExecuting.executeClass(executeClass, executeParameter);
                System.out.println("\n" + getBorder());

                output.print("\n\tfinished executing class with code: " + aReturn.exitCode + "\n\texited with message: \"" + aReturn.exitMessage + "\"\n\tstopping program");
                if (aReturn.exception != null) {
                    output.print("\n\texception: " + aReturn.exception.toString());
                    if (aReturn.exception.getCause() != null)
                        output.print("\n\t\t" + aReturn.exception.getCause().toString());
                }

                if (directExecute != -1) {
                    System.out.println("\tend");
                    System.exit(0);
                }

                boolean repeatInput = true;
                while (repeatInput) {
                    output.print("""

                            \tenter the next action
                            \t\t'r' -> repeat programm
                            \t\t'n' -> select next programm
                            \t\t'e' -> exit""");
                    String input2 = iMainExecutable.SCANNER.next();
                    if (input2.length() == 1)
                        switch (input2) {
                            case "r" -> repeatInput = false;
                            case "n" -> {
                                repeatInput = false;
                                repeatExecute = false;
                            }
                            case "e" -> {
                                System.out.println("\texit");
                                repeat = false;
                                repeatExecute = false;
                                repeatInput = false;
                            }
                            default -> System.out.println("\tinvalid option");
                        }
                }
            }
        }
    }

    public static String getClassName(Class<?> _class) {
        if (showFullClassName)
            return _class.getName();
        else
            return _class.getSimpleName();
    }
}
