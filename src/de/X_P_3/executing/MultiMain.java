package de.X_P_3.executing;

import de.X_P_3.console.out.Output;
import de.X_P_3.console.out.OutputPrintStreamTypes;

public class MultiMain {
    public static final int directExecute = -1;
    public static final String[] directExecuteParameter = {};
    public static MainClassExecuting classExecuting = new MainClassExecuting();

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
            System.out.println("\t" + executable.getClass().getName());
        }

        boolean repeat = true;
        while (repeat) {
            int c = 0;
            for (iMainExecutable item : classExecuting.mains) {
                output.print("\t[" + c + "] | " + item.getClass().getName());
                c++;
            }

            int classNumber;
            String[] executeParameter;
            if (directExecute == -1) {

                output.print("\n\tenter a the id of a class to execute, enter parameter separated with a space\n\t\t(3 parm1 parm2 parm3)");
                String input = iMainExecutable.SCANNER.next();

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
                        System.exit(-1);
                    }
                } else {
                    error.print("Failed to compile \"" + input + "\"");
                    classNumber = -1;
                    executeParameter = null;
                    System.exit(-1);
                }
            } else {
                classNumber = directExecute;
                executeParameter = directExecuteParameter;
            }

            boolean repeatExecute = true;
            while (repeatExecute) {

                iMainExecutable executeClass = classExecuting.getClassByPos(classNumber);
                output.print("\texecute class: " + executeClass.getClass().getName() + "\n");

                ExecuteReturn aReturn = MainClassExecuting.executeClass(executeClass, executeParameter);

                output.print("\n\tfinished executing class: " + executeClass.getClass().getName() + "\n\tstopping program");

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
}
