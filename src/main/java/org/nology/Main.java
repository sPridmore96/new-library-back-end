package org.nology;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Library newLibrary = new Library();

        List<LibraryBook> emptyList = new ArrayList<>();

        userNormal AdminUser = new userNormal("Sam", "Pridmore",
                "08/06/96",
                Collections.singletonList("tech,Mathematics"), emptyList,
                true);


        JsonParser jsonParser = new JsonParser();
        try (FileReader reader = new FileReader("C:\\Users\\Sam_P\\nology\\Development\\current-projects\\new-library-back-end\\src\\main\\Users.json")) {
            JsonElement obj = jsonParser.parse(reader);
            userNormal newUser = new Gson().fromJson(obj, org.nology.userNormal.class);


            boolean isActive = true;

            Commands currentCommands = new LoginCommands();
            currentCommands.run(newLibrary, newUser);

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
                    case "User":
                        currentCommands = new UserCommands();
                        currentCommands.run(newLibrary, newUser);
                        break;
                    case "Leaving":
                        String path = "C:\\Users\\Sam_P\\nology\\Development\\current-projects\\new-library-back-end\\src\\main\\Users.json";
                        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
                            Gson gson = new Gson();
                            String jsonString = gson.toJson(newUser);
                            out.write(jsonString);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        isActive = false;
                }
            }
        }
    }
}