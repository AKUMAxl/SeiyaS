package com.xl.SeiyaS.dao.mapper;

import com.xl.SeiyaS.entity.User;
import com.xl.SeiyaS.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserById(int id);
}