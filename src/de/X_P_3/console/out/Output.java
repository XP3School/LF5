package de.X_P_3.console.out;

import org.jetbrains.annotations.NotNull;

import java.io.Console;
import java.io.PrintStream;

public class Output {
    public OutputPrintStreamTypes outputType;
    public Console console = System.console();
    public PrintStream outputStream;
    public String format;

    public Output(OutputPrintStreamTypes outputType, PrintStream outputStream){
        this.outputType = outputType;
        this.outputStream = outputStream;
    }
    public Output(PrintStream outputStream, String format){
        this.outputStream = outputStream;
        this.format = format;
    }

    public void print(String text){
        switch (outputType){
            case newLine -> {
                outputStream.println(text);
            }
            case normal -> {
                outputStream.print(text);
            }
            case formatted -> {
                outputStream.printf(format, text);
            }
        }
    }
}
