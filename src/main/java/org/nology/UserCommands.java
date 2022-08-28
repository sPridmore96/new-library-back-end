package org.nology;

import java.util.List;

public class UserCommands extends Commands {
    public UserCommands() {
        super("user", new String[]{"Loan a Book", "Check your currently loaned Books", "Return a book", "Back to Home"}, "user");
    }

    @Override
    public void run(Library library, userNormal user) {
        printCommandsGreeting();
        printCommands();
        int userInput = getIntegerInput(4);
        switch (userInput) {
            case 1:
                printMessage("Loaning A Book");
                printMessage("1 : Loose Search \n2 : All Books");
                int searchChoice = getIntegerInput(3);
                switch (searchChoice) {
                    case 1:
                        String userSearch = getStringInput();
                        List<LibraryBook> foundLibraryBooks = library.looseManualSearch(userSearch);
                        library.showIndexOfBooks(foundLibraryBooks);
                        printMessage("Chose the number That corresponds with" +
                                "\nThe book you want");
                        int usersChoiceInt = getIntegerInput(foundLibraryBooks.size());
                        LibraryBook selectedLibraryBook = foundLibraryBooks.get(usersChoiceInt - 1);
                        if (selectedLibraryBook.getStock()) {
                            List<LibraryBook> usersList = user.getUsersBooks();
                            library.moveBookToNewList(foundLibraryBooks, selectedLibraryBook, usersList);
                            printMessage("You took out :");
                            selectedLibraryBook.printBook();
                            run(library, user);
                        } else {
                            printMessage("Please Chose Another Book this one isn't in Stock");
                            run(library, user);
                        }
                        break;
                    case 2:
                        for (int i = 0; i < library.getBooksInList().size(); i++) {
                            LibraryBook eachLibraryBook = library.getBookByIndex(i);
                            printMessage((i + 1) + " : ");
                            eachLibraryBook.printBook();
                        }
                        printMessage("Chose the number That corresponds with" +
                                "\nThe book you want");
                        int userChoice = getIntegerInput(library.getBooksInList().size());
                        LibraryBook foundLibraryBook = library.getBookByIndex(userChoice - 1);
                        if (foundLibraryBook.getStock()) {
                            printMessage("You took out :");
                            foundLibraryBook.printBook();
                            library.moveBookToNewList(library.getBooksInList(), foundLibraryBook, user.getUsersBooks());
                            run(library, user);
                        } else {
                            printMessage("Please Chose Another Book this one isn't in Stock");
                            run(library, user);
                        }
                        break;
                    case 3:
                        printMessage("Cancel withdrawal");
                        run(library, user);
                    default:
                        printMessage("Please enter a different input");
                        break;
                }
                break;
            case 2:
                printMessage("Your Current Books are : ");
                if (user.getUsersBooks().size() == 0) {
                    printMessage("You haven't loaned any books yet");
                } else {
                user.printList();
                run(library, user);
                }
                break;
            case 3:
                printMessage("Returning a book");
               List<LibraryBook> usersList = user.getUsersBooks();
               user.showIndexOfBooks(user.getUsersBooks());
               int usersBookInt = getIntegerInput(user.getBooksInList().size());
               LibraryBook usersLibraryBookChoice = usersList.get(usersBookInt - 1);
               int BookToGoBackInStockInt = user.moveBookToNewList(usersList, usersLibraryBookChoice);
               LibraryBook foundLibraryBook = library.findBookById(BookToGoBackInStockInt);
               foundLibraryBook.setStock(true);
               printMessage("Book returned");
               run(library, user);
               break;
            case 4:
                setNextCommands("Home");
                break;
            default:
                printMessage("Please enter a different input");
        }
    }
}
