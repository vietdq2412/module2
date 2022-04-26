package view;

import controller.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginView {
    UserController userController = UserController.getInstance();
    Scanner scanner = new Scanner(System.in);
    private static final LoginView instance = new LoginView();

    private LoginView(){}

    public static LoginView getInstance(){
        return instance;
    }

    public void showLoginView(String err){
        System.err.println(err);
        System.out.println("======= Login =======");
        System.out.println("|1. Sign in now =====");
        System.out.println("|2. Sign up! ========");
        int choice = 0;
        try {
           choice  = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("pls enter a number!");
            showLoginView("");
        }

        switch (choice){
            case 1:
                scanner.nextLine();
                System.out.println("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();

                userController.login(username, password);
                break;
            case 2:
                userController.showSignUpView();
                break;
            default:
                showLoginView("");
                break;
        }

    }
}
