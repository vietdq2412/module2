import controller.UserController;
import file_data_IO.FileIO;
import model.AppUser;
import service.appUser.UserService;
import view.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Crawler crawler = new Crawler();
//        System.out.println("hello");
//        List<Weather> list = crawler.getData();
//
//        for (Weather weather : list){
//            System.out.println(weather.toString());
//        }
//
//        FileIO<Weather> fileIO = (FileIO<Weather>) FileIO.getInstance();
//
//        fileIO.writeFile("weather.txt", list);

        //UserController.getInstance().run();
//        FileIO<AppUser> fileIO = (FileIO<AppUser>) FileIO.getInstance();
//
//        if (fileIO.checkFile("currentUser.txt")) {
//
//            Map<String, AppUser> userMap = fileIO.readFile("currentUser.txt");
//
//            System.out.println(userMap.toString());
//            System.out.println(userMap.get("new").getUsername());
//
//            System.out.println("lay value");
//            AppUser user = (AppUser) userMap.values().toArray()[0];
//            System.out.println(user.getUsername());
//        } else {
//            System.out.println("loi");
//        }

//UserController.getInstance().showMapUsers();
        //System.out.println(userService.getMapUser().toString());

        UserController.getInstance().run();
    }
}
