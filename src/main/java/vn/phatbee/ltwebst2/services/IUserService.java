package vn.phatbee.ltwebst2.services;

import vn.phatbee.ltwebst2.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);
    UserModel findByUsername(String username);

}
