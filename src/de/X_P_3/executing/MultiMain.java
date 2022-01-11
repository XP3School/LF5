package de.X_P_3.executing;

import de.X_P_3.console.out.Output;
import de.X_P_3.console.out.OutputPrintStreamTypes;
import de.X_P_3.executing.mains.*;

public class MultiMain {

    public static iMainExecutable[] mains = {
            new AverageSumMethod(),
            //new RomeshNumber(),
            new OneHundred()
    };

    public static final int directExecute = 1;
    public static final String[] directExecuteParameter = {};

    public static void main(String[] args) {
        Output output = new Output(OutputPrintStreamTypes.newLine, System.out);
        Output error = new Output(OutputPrintStreamTypes.newLine, System.err);
        output.print("\tloading classes...");
        // auto search for valid classes in project and from a folder on a drive
        boolean repeat = true;
        while (repeat) {
            if (mains.length == 0) {
                output.print("\tno class was found\n\tcancel");
                break;
            } else if (mains.length == 1)
                output.print("\tloaded " + mains.length + " class:");
            else
                output.print("\tloaded " + mains.length + " classes:");
            int c = 0;
            for (iMainExecutable item : mains) {
                output.print("\t[" + c + "] | " + item.getClass().getName());
                c++;
            }
            int classNumber;
            String[] executeParameter;
            if (directExecute == -1) {
                output.print("\n\tenter a the id of a class to execute, enter parameter separated with a space");
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
                    if (classNumber > mains.length - 1) {
                        error.print("Invalid class id");
                        classNumber = -1;
                        executeParameter = null;
                        System.exit(-1);
                    }
                } else {
                    error.print("Failed to execute \"" + input + "\"");
                    classNumber = -1;
                    executeParameter = null;
                    System.exit(-1);
                }
            } else {
                classNumber = directExecute;
                executeParameter = directExecuteParameter;
            }
            output.print("\texecute class: " + mains[classNumber].getClass().getName() + "\n\n\n");
            mains[classNumber].execute(executeParameter);
            output.print("\n\n\n\tfinished executing class: " + mains[classNumber].getClass().getName() + "\n\tstopping program");
            if (directExecute != -1) {
                System.out.println("\tend");
                System.exit(0);
            }
        }
    }
}
