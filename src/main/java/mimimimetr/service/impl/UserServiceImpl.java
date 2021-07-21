package mimimimetr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mimimimetr.entity.User;
import mimimimetr.repository.UserRepo;
import mimimimetr.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }
}
