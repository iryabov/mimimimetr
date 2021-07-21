package mimimimetr.service;

import mimimimetr.entity.User;

public interface UserService {

    User findByUsername(String username);

    void addUser(User user);

}
