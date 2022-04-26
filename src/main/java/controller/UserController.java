package controller;

import model.AppUser;
import service.appUser.UserService;
import view.LoginView;
import view.MainMenu;
import view.SignupView;
import view.UserView;

public class UserController {
    private static final UserController instance = new UserController();
    private UserController(){}
    public static UserController getInstance(){
        return instance;
    }

    UserService userService = new UserService();
    SignupView signupView = SignupView.getInstance();

    public AppUser getCurUser(){
        return userService.getCurrentUser();
    }

    public void showMapUsers(){
        UserView.getInstance().showUserView(userService.getMapUser());
    }

    public void signUp(AppUser user){
        boolean checkUsername = userService.existedByUsername(user.getUsername());
        if (!checkUsername){
            userService.add(user);
            this.run();
        }else {
            signupView.showSignUpView("Duplicate username!");
        }
    }

    public void login(String username, String password){
        if (userService.Login(username,password) == null){
            LoginView.getInstance().showLoginView("Invalid account!");
        };
        MainMenu.getInstance().mainMenu();
    }

    public void run(){
        if(userService.getCurrentUser() != null){
            MainMenu.getInstance().mainMenu();
        }else {
            LoginView.getInstance().showLoginView("");
        }
    }

    public void logout() {
        userService.logout();
        LoginView.getInstance().showLoginView("");
    }

    /////
    public void showSignUpView(){
        signUp(signupView.showSignUpView(""));
    }
}
