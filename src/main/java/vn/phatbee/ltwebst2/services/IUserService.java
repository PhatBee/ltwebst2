package vn.phatbee.ltwebst2.services;

import vn.phatbee.ltwebst2.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);
    UserModel findByUsername(String username);

    void insert(UserModel user);
    boolean register(String username, String password, String email, String fullname, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);

}
