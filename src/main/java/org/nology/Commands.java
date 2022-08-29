package org.nology;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Commands {

    private final String name;
    private final String[] commands;
    private final Scanner scanner;
    private String nextCommands;

    public Commands(String name, String[] commands, String nextCommands) {
        this.name = name;
        this.commands = commands;
        this.scanner = new Scanner(System.in);
        this.nextCommands = nextCommands;
    }

    public String getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(String nextCommands) {
        this.nextCommands = nextCommands;
    }

    abstract public void run(Library library, userNormal user) throws IOException;

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCommandsGreeting() {
        printMessage("Welcome to the " + name + " commands");
    }

    ;

    public void printCommands(String[] newCommands) {
        for (int i = 0; i < newCommands.length; i++) {
            printMessage((i + 1) + " : " + newCommands[i]);
        }
    }

    public void printCommands() {
        printCommands(commands);
    }

    public int getIntegerInput(int rangeLimit) {
        int input = 0;
        boolean isActive = true;
        while (isActive) {
            input = 0;
            try {
                printMessage("Enter A number between 1 and " + rangeLimit);
                int userInput = scanner.nextInt();
                if (userInput > 0 && userInput <= rangeLimit) {
                    isActive = false;
                    input = userInput;
                } else {
                    printMessage("unable to understand input please enter a number between 1 and " + rangeLimit);
                }
            } catch (InputMismatchException e) {
                printMessage("Only Enter Numbers for this set of commands");
                scanner.nextLine();
            }
                scanner.nextLine();
        }
        return input;
    }

    public String getStringInput() {
        String input = "";
        boolean isActive = true;

        while (isActive) {
            printMessage("Enter text below");
            String userInput = scanner.nextLine();

            if (!Objects.equals(userInput, "")) {
                isActive = false;
                input = userInput;
            } else {
                printMessage("Unable to read input, enter a string and try again");
            }
        }
        return input;
    }
}
