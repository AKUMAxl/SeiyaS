package com.xl.SeiyaS.service.impl;


import com.xl.SeiyaS.dao.mapper.UserMapper;
import com.xl.SeiyaS.entity.User;
import com.xl.SeiyaS.entity.UserExample;
import com.xl.SeiyaS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getUsers() {
        List<User> list;
        list = userMapper.getUsers();
        return list;
    }

    @Override
    public User getUserById(Integer userId) {
//        UserExample example = new UserExample();
//        UserExample.Criteria criteria = example.createCriteria();
//        if (!"".equals(userId == null ? "" : userId)) {
//            criteria.andIdEqualTo(userId);
//        }
        return userMapper.getUserById(userId);
    }
}
