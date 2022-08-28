package org.nology;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Library newLibrary = new Library();
        userNormal newUser = new userNormal("Sam", "Pridmore",
                "08/06/96",
                Collections.singletonList("tech,Mathematics"),
                false);

        boolean isActive = true;

        Commands currentCommands = new HomeCommands(newLibrary, newUser);

        while (isActive) {

            switch (currentCommands.getNextCommands()) {
                case "Home":
                    currentCommands = new HomeCommands(newLibrary, newUser);
                    currentCommands.run(newLibrary, newUser);
                    break;
                case "Search":
                    currentCommands = new SearchCommands();
                    currentCommands.run(newLibrary, newUser);
                    break;
                case "User" :
                    currentCommands = new UserCommands();
                    currentCommands.run(newLibrary,newUser);
                    break;
                case "Leaving":
                    isActive = false;
            }
        }

    }
}