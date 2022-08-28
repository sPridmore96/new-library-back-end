package org.nology;

public class HomeCommands extends Commands{

    public HomeCommands(Library library, User user) {
        super("Home",
                new String[]{"Browse The Full Library",
                        "Search For a Book",
                        "Go to the user Area",
                        "Leave Library"},
                "Home");
    }

    @Override
    public void run(Library library, userNormal user) {
        printCommandsGreeting();
        printCommands();
        int userInt = getIntegerInput(4);
        switch (userInt) {
            case 1:
                printMessage("Full Library");
                library.printList();
                setNextCommands("Home");
                break;
            case 2:
                printMessage("Search For a Book");
                setNextCommands("Search");
//                System.out.println(getNextCommands());
                break;
            case 3:
                printMessage("User Area");
                setNextCommands("User");
                break;
            case 4:
                printMessage("Leaving Library");
                setNextCommands("Leaving");
                break;
            default:
                printMessage("Please enter a different input");
                break;
        }
    }
}
