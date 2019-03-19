package com.xl.SeiyaS.service;


import com.xl.SeiyaS.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Integer userId);
}
