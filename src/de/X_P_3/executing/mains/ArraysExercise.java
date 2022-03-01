package de.X_P_3.executing.mains;

import de.X_P_3.executing.iMainExecutable;

public class ArraysExercise implements iMainExecutable {
    @Override
    public int execute(String... args) {
        System.out.println("int[] zahlen = {1, 6, 3, 7, 2, 2, 4, 8};\n");
        int[] zahlen = {1, 6, 3, 7, 2, 2, 4, 8};

        System.out.println("""
                for (int i = 0; i<=zahlen.length; i++)
                {
                \tSystem.out.print(zahlen[i] + ", ");
                }
                """);
        for (int i = 0; i <= zahlen.length; i++) {
            System.out.print(zahlen[i] + ", ");
        }

        System.out.println("""
                for (int i = 1; i<=zahlen.length; i+=2)
                {
                \tSystem.out.print(zahlen[i] + ", ");
                }
                """);
        for (int i = 1; i <= zahlen.length; i += 2) {
            System.out.print(zahlen[i] + ", ");
        }

        System.out.println("""
                for (int i = 0; i<=zahlen.length/2; i++)
                {
                \tSystem.out.print(zahlen[i] + ", ");
                }
                """);
        for (int i = 0; i <= zahlen.length / 2; i++) {
            System.out.print(zahlen[i] + ", ");
        }

        System.out.println("""
                for (int i = zahlen.length - 1; i>= 0; i--)
                {
                \tSystem.out.print(zahlen[i] + ", ");
                }
                """);
        for (int i = zahlen.length - 1; i >= 0; i--) {
            System.out.print(zahlen[i] + ", ");
        }

        System.out.println("""
                for (int i = 1; i < zahlen.length; i+=3)
                {
                \tSystem.out.print(zahlen[i] + ", ");
                }
                """);
        for (int i = 1; i < zahlen.length; i += 3) {
            System.out.print(zahlen[i] + ", ");
        }

        System.out.println("""
                for (int i = zahlen.length - 1; i>= 0; i/=2)
                {
                \tSystem.out.print(zahlen[i] + ", ");
                }
                """);
        for (int i = zahlen.length - 1; i >= 0; i /= 2) {
            System.out.print(zahlen[i] + ", ");
        }
        return 0;
    }
}
