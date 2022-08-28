package org.nology;

import java.awt.print.Book;
import java.util.List;

public interface LoaningInterface {

    public LibraryBook getBookByIndex(int id);
    public void showIndexOfBooks(List<LibraryBook> booksToShow);

    public List<LibraryBook> getBooksInList();

    public void printList();

    public void moveBookToNewList(List<LibraryBook> listFrom ,LibraryBook bookToMove, List<LibraryBook> newList);

    public void sortedById();

    public void sortAlphabetically();

    public List<LibraryBook> StrictManualSearch(String searchTerm);

    public List<LibraryBook> looseManualSearch(String searchTerm);
}
