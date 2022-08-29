package org.nology;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class userNormal extends User implements LoaningInterface {
    public userNormal(String firstName, String lastName, String DOB, List<String> genres, List<LibraryBook> usersBooks, boolean isAdmin) {
        super(firstName, lastName, DOB, genres, usersBooks,isAdmin);
    }


    @Override
    public LibraryBook getBookByIndex(int index) {
        return getUsersBooks().get(index);
    }

    @Override
    public void showIndexOfBooks(List<LibraryBook> booksToShow) {
        for (int i = 0; i < booksToShow.size(); i++) {
            LibraryBook eachBook = booksToShow.get(i);
            System.out.println("" + (i + 1) + " : ");
            eachBook.printBook();
        }
    }

    @Override
    public List<LibraryBook> getBooksInList() {
        return getUsersBooks();
    }



    @Override
    public void printList() {
        for (LibraryBook currentBook : getBooksInList()) {
            System.out.println("id : " + currentBook.getId() +
                    "\nTitle : " + currentBook.getTitle() +
                    "\nAuthor : " + currentBook.getAuthor() +
                    "\n Publisher : " + currentBook.getPublisher() +
                    "\nStock : " + currentBook.getStock() +
                    "\n");
        }
    }

    @Override
    public void moveBookToNewList(List<LibraryBook> listFrom ,LibraryBook bookToMove, List<LibraryBook> newList) {
        listFrom.remove(bookToMove);
        bookToMove.setStock(!bookToMove.getStock());
    }

    public int moveBookToNewList(List<LibraryBook> listFrom , LibraryBook bookToMove) {
        listFrom.remove(bookToMove);
        return bookToMove.getId();
    }

    @Override
    public void sortedById() {
        getUsersBooks().sort(Comparator.comparing(LibraryBook::getId));
    }

    @Override
    public void sortAlphabetically() {
        getUsersBooks().sort(Comparator.comparing(LibraryBook::getTitle));
    }

    @Override
    public List<LibraryBook> StrictManualSearch(String searchTerm) {
        List<LibraryBook> foundBooks = getUsersBooks().stream()
                .filter((book -> book.getTitle().equals(searchTerm)
                        || book.getPublisher().equals(searchTerm)
                        || book.getAuthor().equals(searchTerm)))
                .collect(Collectors.toList());
        return foundBooks;
    }

    @Override
    public List<LibraryBook> looseManualSearch(String searchTerm) {
        List<LibraryBook> foundBooks = new ArrayList<>();
        for (int i = 0; i < getBooksInList().size(); i++) {
            if (getBookByIndex(i).getTitle().contains(searchTerm)) {
                foundBooks.add(getBookByIndex(i));
            }
            ;
        }
        return foundBooks;
    }
}
