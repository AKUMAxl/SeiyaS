package com.xl.SeiyaS.service.impl;

import com.xl.SeiyaS.dao.mapper.GoodMapper;
import com.xl.SeiyaS.entity.Goods;
import com.xl.SeiyaS.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Resource
    GoodMapper goodMapper;

    public List<Goods> getGoodList() {
        return goodMapper.getGoodList();
    }

}
