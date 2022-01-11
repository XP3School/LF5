package de.X_P_3.executing.mains;

import de.X_P_3.executing.iMainExecutable;
import de.X_P_3.math.ComputeRomeshNumber;

import java.util.Locale;

public class RomeshNumber implements iMainExecutable {

    @Override
    public int execute(String... args) {
        if (args.length == 0)
            System.out.println("no input\nend");
        for (String number: args) {
            System.out.println(number + " = " + ComputeRomeshNumber.computeRomeshNumber(number));
        }
        return 0;
    }
}
