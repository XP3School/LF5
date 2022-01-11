package de.X_P_3.console.in;

import de.X_P_3.console.out.Output;
import de.X_P_3.variable.Variable;

import java.util.Scanner;

public class Input {
    public static Object repeatInputWMessage(final ValidObjectTypes type, Scanner scanner, Output repeatingMessage, String repeatingS, Output errorMessage, String errorS){
        while (true) {
            repeatingMessage.print(repeatingS);
            SaveReturnConsoleInputReturn Value = getSaveConsoleInput(type, scanner);
            if (!Value.Error)
                return Value.Value;
            errorMessage.print(errorS);
        }
    }

    public static Object repeatInputWMessage(final ValidObjectTypes type, Scanner scanner, Output repeatingMessage, String repeatingS, Output errorMessage, String errorS, String exceptPattern){
        while (true) {
            repeatingMessage.print(repeatingS);
            SaveReturnConsoleInputReturn Value = getSaveConsoleInput(type, scanner);
            if (!Value.Error && !de.X_P_3.pattern.Pattern.stringMatchesPattern(Value.Value.toString(), exceptPattern))
                return Value.Value;
            errorMessage.print(errorS);
        }
    }

    public static String repeatInputWMessageVO(iRepeatValue repeat, Scanner scanner, Output repeatingMessage, String repeatingS, Output errorMessage, String errorS){
        Break _break = new Break();
        while (!_break.Break) {
            repeatingMessage.print(repeatingS);
            String Value = scanner.next();
            if (repeat.isValueOk(Value, _break))
                return Value;
            else if (!_break.Break)
                errorMessage.print(errorS);
        }
        return null;
    }

    public static SaveReturnConsoleInputReturn getSaveConsoleInput(final ValidObjectTypes type, Scanner scanner){
        String SValue = scanner.next();
        if (SValue != null){
            switch (type){
                case String -> {
                    return new SaveReturnConsoleInputReturn(SValue);
                }
                case Int -> {
                    if (Variable.isFormattedLike(SValue, ValidObjectTypes.Int))
                        return new SaveReturnConsoleInputReturn(Integer.parseInt(SValue));
                }
                case Double -> {
                    if (Variable.isFormattedLike(SValue.replace(',', '.'), ValidObjectTypes.Double))
                        return new SaveReturnConsoleInputReturn(Double.parseDouble(SValue.replace(',', '.')));
                }
            }
        }
        SaveReturnConsoleInputReturn _return = new SaveReturnConsoleInputReturn(null);
        _return.Error = true;
        return _return;
    }
}

