package de.X_P_3.money;

import java.util.*;

public class MoneyCalculator {
    public MoneyElement[] MoneyElementsCount;

    public void clearMoney(){
        for (MoneyElement Item: MoneyElementsCount) {
            Item.count = 0;
        }
    }

    public double addMoneyAndCalculate(double Value){
        double Val = Double.parseDouble(Value + "");
        for (MoneyElement Item: MoneyElementsCount) {
            while (Val >= Item.Value){
                Item.count++;
                Val-=Item.Value;
            }
        }
        return Val;
    }

    public boolean contains(double Value){
        for (MoneyElement Item: MoneyElementsCount) {
            if (Item.Value == Value)
                return true;
        }
        return false;
    }

    public MoneyElement get(double Value){
        for (MoneyElement Item: MoneyElementsCount) {
            if (Item.Value == Value)
                return Item;
        }
        return null;
    }

    public int getCountOfRange(double min, double max){
        int count = 0;
        for (MoneyElement Item: MoneyElementsCount) {
            if (Item.Value >= min && Item.Value <= max)
                count+= Item.count;
        }
        return count;
    }
}