package org.nology;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdmin extends User implements LoaningInterface, AdminInterface {

    public UserAdmin(String firstName, String lastName, String DOB, List<String> genres, boolean isAdmin) {
        super(firstName, lastName, DOB, genres, isAdmin);
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
    public void moveBookToNewList(List<LibraryBook> listFrom, LibraryBook bookToMove, List<LibraryBook> newList) {
        listFrom.remove(bookToMove);
        bookToMove.setStock(!bookToMove.getStock());
    }

    public int moveBookToNewList(List<LibraryBook> listFrom, LibraryBook bookToMove) {
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

    @Override
    public void makeStockCsv(List<LibraryBook> dataToLoop) {
        File file = new File("D:\\Nology\\Projects\\Back-end-library\\Assest\\FakeReports\\test.txt");
        try {
            FileWriter outPutFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outPutFile);

            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Id", "Title", "Author", "Genre", "SubGenre", "Publisher", "Stock"});
            for (LibraryBook eachBook : dataToLoop) {
                String[] bookToAdd = new String[]{eachBook.getId() + "",
                        eachBook.getTitle(),
                        eachBook.getAuthor(),
                        eachBook.getGenre(),
                        eachBook.getSubGenre(),
                        eachBook.getStock() + ""};
                data.add(bookToAdd);
            }
                writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLibraryStock() {

    }

    @Override
    public void printUserList() {

    }
}
