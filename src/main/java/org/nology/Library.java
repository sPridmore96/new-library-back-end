package org.nology;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Library implements LoaningInterface {
    public static List<LibraryBook> library = new ArrayList<>();



    static {
        String line = "";
        try {
            BufferedReader br = new BufferedReader
                    (new FileReader("D:\\Nology\\Projects\\Back-end-library\\Assest\\books_data.csv"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                List<String> nameArr = new ArrayList<>(List.of(row[2].split(",")));
                Collections.reverse(nameArr);
                String fullNames = nameArr.stream()
                        .map(name -> name.toString())
                        .collect(Collectors.joining(""))
                        .replaceFirst("\\s+", "")
                        .replaceFirst("\"", "")
                        .replaceFirst("\"", " ");
                library.add(new LibraryBook(parseInt(row[0]), row[1], fullNames, row[3], row[4], row[5], true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@Override
    public void showIndexOfBooks(List<LibraryBook> booksToShow) {
        for (int i = 0; i < booksToShow.size(); i++) {
            LibraryBook eachLibraryBook = booksToShow.get(i);
            System.out.println("" + (i + 1) + " : ");
            eachLibraryBook.printBook();
        }
    }

    @Override
    public void printList() {
        for (LibraryBook currentLibraryBook : library) {
            System.out.println("id : " + currentLibraryBook.getId() +
                    "\nTitle : " + currentLibraryBook.getTitle() +
                    "\nAuthor : " + currentLibraryBook.getAuthor() +
                    "\nPublisher : " + currentLibraryBook.getPublisher() +
                    "\nStock : " + currentLibraryBook.getStock() +
                    "\n");
        }
    }

    public void printList(List<LibraryBook> givenList){
        for (LibraryBook currentLibraryBook : givenList) {
            System.out.println("id : " + currentLibraryBook.getId() +
                    "\nTitle : " + currentLibraryBook.getTitle() +
                    "\nAuthor : " + currentLibraryBook.getAuthor() +
                    "\nPublisher : " + currentLibraryBook.getPublisher() +
                    "\nStock : " + currentLibraryBook.getStock() +
                    "\n");
        }
    }

    @Override
    public LibraryBook getBookByIndex(int id) {
        return library.get(id);
    }

    @Override
    public List<LibraryBook> getBooksInList() {
        return library;
    }

    @Override
    public void moveBookToNewList(List<LibraryBook> listFrom , LibraryBook libraryBookToMove, List<LibraryBook> newList) {
        newList.add(libraryBookToMove);
        libraryBookToMove.setStock(!libraryBookToMove.getStock());
    }

    public LibraryBook findBookById(int id) {
        LibraryBook foundLibraryBook = null;
        for (int i = 0; i < getBooksInList().size(); i++) {
             LibraryBook eachLibraryBook = getBooksInList().get(i);
             if (eachLibraryBook.getId() == id){
                foundLibraryBook = eachLibraryBook;
        }
    }
        return foundLibraryBook;
    }

    @Override
    public void sortedById() {
        library.sort(Comparator.comparing(LibraryBook::getId));
    }

    @Override
    public void sortAlphabetically() {
        library.sort(Comparator.comparing(LibraryBook::getTitle));
    }

    @Override
    public List<LibraryBook> StrictManualSearch(String searchTerm) {
        List<LibraryBook> foundLibraryBooks = getBooksInList().stream()
                .filter((libraryBook -> libraryBook.getTitle().equals(searchTerm)
                        || libraryBook.getPublisher().equals(searchTerm)
                        || libraryBook.getAuthor().equals(searchTerm)
                        || libraryBook.getGenre().equals(searchTerm)))
                .collect(Collectors.toList());
        return foundLibraryBooks;
    }

    @Override
    public List<LibraryBook> looseManualSearch(String searchTerm) {
        List<LibraryBook> foundLibraryBooks = new ArrayList<>();
        for (int i = 0; i < getBooksInList().size(); i++) {
            LibraryBook libraryBook = getBookByIndex(i);
            if (libraryBook.getTitle().toLowerCase().contains(searchTerm)
                    || libraryBook.getAuthor().toLowerCase().contains(searchTerm)
                    || libraryBook.getPublisher().toLowerCase().contains(searchTerm)
                    || libraryBook.getGenre().toLowerCase().contains(searchTerm)) {
                foundLibraryBooks.add(getBookByIndex(i));
            }
            ;
        }
        return foundLibraryBooks;
    }

}

