package com.nexxy.services.user;

import com.nexxy.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    public User createUser(User user);
}
