package vn.phatbee.ltwebst2.services.impl;

import vn.phatbee.ltwebst2.configs.DBConnectSQL;
import vn.phatbee.ltwebst2.dao.IUserDao;
import vn.phatbee.ltwebst2.dao.impl.UserDaoImpl;
import vn.phatbee.ltwebst2.models.UserModel;
import vn.phatbee.ltwebst2.services.IUserService;

import java.sql.Date;

public class UserService extends DBConnectSQL implements IUserService {
    // Lay toan bo trong Dao
    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;

    }

    @Override
    public UserModel findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void insert(UserModel user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        userDao.insert(new UserModel(username, email, fullname, password, null, 2, phone, date));
        return true;

    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        return userDao.updatePassword(username, newPassword);
    }

    @Override
    public void updateProfile(UserModel user) {
        userDao.updateProfile(user);
    }
}
