package de.X_P_3.math;

public class ComputeRomeshNumber {
    public static int convertToInt(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static int computeRomeshNumber(String Number){
        if (Number == null) {
            return -1;
        }
        if (Number.isEmpty())
            return -1;

        int biggestUntilNow = 0;
        int currentEnd = 0;
        char lastChar = 0;
        int count = 0;

        for (char currentChar: Number.toCharArray()){
            if (lastChar == currentChar)
                count++;
            else{

            }
            int currentNumber = convertToInt(currentChar);

            if (currentNumber > biggestUntilNow){
                currentEnd = currentNumber - currentEnd;
                biggestUntilNow = currentNumber;
            }
            else
                currentEnd+= currentNumber;
        }
        return java.lang.Math.abs(currentEnd);
    }
}

//
// IIV = 3
// V = 5
// VII = 7
//
// XLL = 90
//
// 10; 50; 50
//
// s = 10;
//
//
//
//
//
//
//