package org.nology;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdmin extends User {

    public UserAdmin(String firstName, String lastName, String DOB, List<String> genres, boolean isAdmin) {
        super(firstName, lastName, DOB, genres, isAdmin);
    }

}
