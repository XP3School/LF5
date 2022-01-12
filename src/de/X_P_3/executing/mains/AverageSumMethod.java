package de.X_P_3.executing.mains;

import de.X_P_3.console.in.ValidObjectTypes;
import de.X_P_3.executing.iMainExecutable;
import de.X_P_3.variable.Variable;

import java.util.Objects;

public class AverageSumMethod implements iMainExecutable {

    @Override
    public int execute(String... args) {
        String input;
        double current = 0;
        int count = 0;
        while (true){
            System.out.print("input: ");
            count++;
            input = SCANNER.next();
            if (Objects.equals(input, "e"))
                break;
            if (Variable.isFormattedLike(input, ValidObjectTypes.Double))
                current+= Double.parseDouble(input);
            else
                System.err.println("the input is not a double");
            System.out.println("Average: " + current / count);
        }
        return 0;
    }
}
