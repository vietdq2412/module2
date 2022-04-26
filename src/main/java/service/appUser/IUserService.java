package service.appUser;

import model.AppUser;
import service.IService;

public interface IUserService extends IService<AppUser> {
    boolean existedByUsername(String username);
    AppUser findByUsername(String username);
    AppUser checkLogin(String username, String password);
    AppUser Login(String username, String password);
    AppUser getCurrentUser();

    void logout();
}
