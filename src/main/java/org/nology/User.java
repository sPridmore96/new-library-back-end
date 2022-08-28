package org.nology;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public abstract class User {

private String firstName;
private String lastName;
private String DOB;
private List<String> genres;
private String id;
private List<LibraryBook> usersBooks = new ArrayList<>();
private boolean isAdmin;

    public User(String firstName, String lastName, String DOB, List<String> genres, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.genres = genres;
        this.id = firstName + lastName + DOB;
        this.isAdmin = isAdmin;

    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<LibraryBook> getUsersBooks() {
        return usersBooks;
    }

    public void setUsersBooks(List<LibraryBook> usersBooks) {
        this.usersBooks = usersBooks;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
