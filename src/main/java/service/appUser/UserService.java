package service.appUser;

import file_data_IO.FileIO;
import model.AppUser;

import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService {
    public static int lastUserId = 0;
    public static AppUser currentUser;
    private final String USER_DATA_PATH = "user_data.txt";
    private final String CURRENT_USER_DATA_PATH = "currentUser.txt";
    FileIO<AppUser> fileIO = (FileIO<AppUser>) FileIO.getInstance();
    private Map<String, AppUser> mapUser = new HashMap<>();

    public UserService() {
        if (fileIO.checkFile(USER_DATA_PATH)) {
            mapUser = findAll();
            lastUserId = mapUser.get("id").getId();
            currentUser = getCurrentUser();
        } else {
            add(new AppUser(lastUserId, "id", "id", "id"));
            System.out.println("User data empty!");
        }
    }

    @Override
    public boolean existedByUsername(String username) {
        if (mapUser.containsKey(username)){
            return true;
        }
        return false;
    }

    @Override
    public AppUser checkLogin(String username, String password) {
        boolean isExist = mapUser.containsKey(username);
        if (isExist) {
            AppUser user = mapUser.get(username);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }

    @Override
    public AppUser Login(String username, String password) {
        if (checkLogin(username, password) != null) {
            AppUser appUser = mapUser.get(username);
            Map<String, AppUser> curUser = new HashMap<>();
            curUser.put(username, appUser);
            fileIO.writeFile(CURRENT_USER_DATA_PATH, curUser);
            return appUser;
        }
        return null;
    }

    @Override
    public AppUser findByUsername(String username) {
        return null;
    }

    @Override
    public AppUser add(AppUser user) {
        if (mapUser.containsKey("id")) {
            mapUser.get("id").setId(lastUserId + 1);
        }
        user.setId(lastUserId + 1);
        lastUserId++;
        mapUser.put(user.getUsername(), user);
        updateData();
        return user;
    }

    @Override
    public AppUser getCurrentUser() {
        if (fileIO.checkFile(CURRENT_USER_DATA_PATH)) {
            Map<String, AppUser> user = fileIO.readFile(CURRENT_USER_DATA_PATH);
            AppUser cur = (AppUser) user.values().toArray()[0];
            return cur;
        } else {
            return null;
        }
    }

    @Override
    public void logout() {
        if (fileIO.checkFile(CURRENT_USER_DATA_PATH)) {
            fileIO.clearFile(CURRENT_USER_DATA_PATH);
        } else {
            System.out.println("Not logged in!");
        }
        currentUser = null;
    }

    @Override
    public void updateData() {
        fileIO.writeFile(USER_DATA_PATH, mapUser);
    }

    @Override
    public Map<String, AppUser> findAll() {
        Map<String, AppUser> mapUser = fileIO.readFile(USER_DATA_PATH);
        return mapUser;
    }


    @Override
    public void edit(AppUser appUser) {

    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public Map<String, AppUser> getMapUser() {
        return mapUser;
    }
}
