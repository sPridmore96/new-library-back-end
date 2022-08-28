package org.nology;

public class CreateUserCommands extends Commands{

    public CreateUserCommands(String name, String[] commands, String nextCommands) {
        super("Create User", new String[]{}, "CreateUser");
    }

    @Override
    public void run(Library library, userNormal user) {

    }
}
