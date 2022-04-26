package view;

import controller.ProductController;
import controller.UserController;
import controller.WeatherController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    UserController userController = UserController.getInstance();
    WeatherController weatherController = WeatherController.getInstance();
    ProductController productController = ProductController.getInstance();
    private static final MainMenu instance = new MainMenu();

    private MainMenu() {
    }

    public static MainMenu getInstance() {
        return instance;
    }

    public void mainMenu() {
        System.out.println("=========================");
        System.out.println("== Hello " + userController.getCurUser().getName());
        System.out.println("========== Menu =========");
        System.out.println("| 1. Show weather =======");
        System.out.println("| 2. Sign up ============");
        System.out.println("| 3. Show list user =====");
        System.out.println("| 4. Log out ============");
        System.out.println("| 5. Product management =");
        System.out.println("=========================");
        System.out.println("Enter your choice: ");
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Please input a number! (main menu)");
            this.mainMenu();
        }

        switch (choice) {
            case 1:
                weatherController.showWeatherMenu();
                break;
            case 2:
                userController.showSignUpView();
                break;
            case 3:
                userController.showMapUsers();
                break;
            case 4:
                userController.logout();
                break;
            case 5:
                productController.showProductView();
                break;
            default:
                mainMenu();
                break;
        }
    }

    public static void main(String[] args) {
        MainMenu.getInstance().mainMenu();
    }
}
