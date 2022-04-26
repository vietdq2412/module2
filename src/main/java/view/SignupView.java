package view;

import controller.UserController;
import model.AppUser;
import service.appUser.UserService;

import java.util.Scanner;

public class SignupView {
    Scanner scanner = new Scanner(System.in);
    private static final SignupView instance = new SignupView();

    private SignupView() {
    }

    public static SignupView getInstance() {
        return instance;
    }

    public AppUser showSignUpView(String message) {
        System.err.println(message);
        System.out.println("========== Sign up =========");
        System.out.println("| Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("| Enter username: ");
        String username = scanner.nextLine();
        System.out.println("| Enter password: ");
        String password = scanner.nextLine();

        return new AppUser(username, password, name);
    }
}
