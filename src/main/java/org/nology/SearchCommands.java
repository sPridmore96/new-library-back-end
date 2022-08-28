package org.nology;

import java.util.List;

public class SearchCommands extends Commands {
    public SearchCommands() {
        super("Search",
                new String[]{"Search the Library By Exact Name / Author / Publisher or Genre",
                        "Search The library by a close match to your input",
                        "Return Home"},
                "SearchCommands");
    }

    @Override
    public void run(Library library, userNormal user) {
        printCommandsGreeting();
        printCommands();
        int userInt = getIntegerInput(3);
        switch (userInt){
            case 1:
                List<LibraryBook> strictFoundBooks = library.StrictManualSearch(getStringInput());
                library.printList(strictFoundBooks);
                strictFoundBooks.removeAll(strictFoundBooks);
                run(library, user);
                break;
            case 2:
                List<LibraryBook> looseFoundBooks = library.looseManualSearch(getStringInput());
                library.printList(looseFoundBooks);
                looseFoundBooks.removeAll(looseFoundBooks);
                run(library, user);
                break;
            case 3:
                setNextCommands("Home");
                break;
            default:
                printMessage("Please enter a different input");
        }
    }
}
