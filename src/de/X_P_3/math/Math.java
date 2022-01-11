package de.X_P_3.math;

public class Math {
    public static double average(double... doubles){
        double out = 0;
        for (double item: doubles) {
            out+= item;
        }
        return out / doubles.length;
    }
}
