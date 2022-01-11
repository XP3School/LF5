package de.X_P_3.variable;

public class AdvancedToString {
    public static String toAString(Object o, int makeLength, BefOrAft befOrAft, char add){
        String out = o.toString();
        if (out.length() == makeLength)
            return out;
        if (out.length() < makeLength){
            final String repeat = String.valueOf(add).repeat(makeLength - out.length());
            switch (befOrAft){
                case before -> {
                    return repeat + out;
                }
                case after -> {
                    return out + repeat;
                }
            }
        }
        return out.substring(0, makeLength - 1);
    }
}
