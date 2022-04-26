package view;

import controller.UserController;
import model.AppUser;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    private static final UserView instance = new UserView();

    private UserView(){}

    public static UserView getInstance(){
        return instance;
    }

    public void showUserView(Map<String, AppUser> list){
        System.out.println("|=== List user ===|");
        for (AppUser user : list.values()) {
            if (user.getUsername().equals("id")){
                continue;
            }
            System.out.println(user.toString());
        }
        System.out.println("|1. Back to main menu");
        int choice = scanner.nextInt();

        if (choice == 1){
            MainMenu.getInstance().mainMenu();
        }
    }
}
