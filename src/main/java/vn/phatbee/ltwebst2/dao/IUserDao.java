package vn.phatbee.ltwebst2.dao;

import vn.phatbee.ltwebst2.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    UserModel findByUsername(String username);

}
