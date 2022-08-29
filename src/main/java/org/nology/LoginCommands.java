package org.nology;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;

import java.io.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginCommands extends Commands{

    public LoginCommands() {
        super("Login", new String[]{"New user", "Already have an Account?"}, "Login");
    }

//
//    userNormal newUser = new userNormal("Sam", "Pridmore",
//            "08/06/96",
//            Collections.singletonList("tech,Mathematics"),
//            false);
//    UserAdmin newAdmin = new UserAdmin("Euan", "Herbertson",
//            "29/08/2000",
//            Collections.singletonList("fiction,tech"),
//            true );

    public void run(Library library, userNormal user) throws IOException {
        printCommandsGreeting();
        printCommands();
        int userInput = getIntegerInput(2);
        switch (userInput){
            case 1:
                printMessage("Creating a new Account\n");
                printMessage("Enter your first name");
                String firstName = getStringInput();
                printMessage("Enter your last name");
                String lastName = getStringInput();
                printMessage("Enter your Date of Birth : DD/MM/YYYY");
                String DOB = getStringInput();
                printMessage("Enter Some Genres you're\n interested in with ',' in between");
                String Genres = getStringInput();
                List<LibraryBook> emptyListForNewUser = new ArrayList<>();
                userNormal createdUser = new userNormal(firstName, lastName, DOB, Collections.singletonList(Genres), emptyListForNewUser, false);
                String path = "C:\\Users\\Sam_P\\nology\\Development\\current-projects\\new-library-back-end\\src\\main\\Users.json";

                try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(createdUser);
                    out.write(jsonString);
                } catch (Exception e){
                    e.printStackTrace();
                }
                printMessage("You account has been Created");
                setNextCommands("Home");
                break;
            case 2:
                JsonParser jsonParser = new JsonParser();
                try (FileReader reader = new FileReader("C:\\Users\\Sam_P\\nology\\Development\\current-projects\\new-library-back-end\\src\\main\\Users.json")) {
                    JsonElement obj = jsonParser.parse(reader);
                    userNormal userNormal = new Gson().fromJson(obj, org.nology.userNormal.class);
                    printMessage("\nWelcome back " + userNormal.getFirstName() + " " + userNormal.getLastName() + "\n");
                    setNextCommands("Home");
                }
        }
    }
}
