package vn.phatbee.ltwebst2.services.impl;

import vn.phatbee.ltwebst2.configs.DBConnectSQL;
import vn.phatbee.ltwebst2.dao.IUserDao;
import vn.phatbee.ltwebst2.dao.impl.UserDaoImpl;
import vn.phatbee.ltwebst2.models.UserModel;
import vn.phatbee.ltwebst2.services.IUserService;

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

}
