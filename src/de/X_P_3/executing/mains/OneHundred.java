package de.X_P_3.executing.mains;

import de.X_P_3.console.in.Input;
import de.X_P_3.console.in.ValidObjectTypes;
import de.X_P_3.console.out.Output;
import de.X_P_3.console.out.OutputPrintStreamTypes;
import de.X_P_3.executing.iMainExecutable;

public class OneHundred implements iMainExecutable {

    @Override
    public int execute(String... args) {

        int repeating = (int) Input.repeatInputWMessage(
                ValidObjectTypes.Int,
                SCANNER,
                new Output(OutputPrintStreamTypes.newLine, System.out),
                "enter an integer",
                new Output(OutputPrintStreamTypes.newLine, System.out),
                "enter a correct integer"
        );

        int count = 1;
        boolean first = true;
        System.out.println("count with a while loop");
        while (count <= repeating){
            if (first){
                System.out.print(count);
                first = false;
            }
            else
                System.out.print(", " + count);
            count++;
        }

        first = true;
        System.out.println("\ncount with a for loop (up)");
        for (count = 1; count <= repeating; count++) {
            if (first){
                System.out.print(count);
                first = false;
            }
            else
                System.out.print(", " + count);
        }

        first = true;
        System.out.println("\ncount with a for loop (down)");
        for (count = repeating; count > 0; count--) {
            if (first){
                System.out.print(count);
                first = false;
            }
            else
                System.out.print(", " + count);
        }

        count = 1;
        first = true;
        System.out.println("\ncount with a do-while loop");
        do {
            if (first){
                System.out.print(count);
                first = false;
            }
            else
                System.out.print(", " + count);
            count++;
        }
        while (count <= repeating);

        return 0;
    }
}
