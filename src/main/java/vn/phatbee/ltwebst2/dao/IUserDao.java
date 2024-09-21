package vn.phatbee.ltwebst2.dao;

import vn.phatbee.ltwebst2.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    UserModel findByUsername(String username);

    boolean checkExistUsername(String username);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
    void insertRegister(UserModel user);

    boolean updatePassword(String username, String newPassword);

}
