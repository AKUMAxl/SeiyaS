package com.xl.SeiyaS.dao.mapper;


import com.xl.SeiyaS.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodMapper {

    List<Goods> getGoodList();

}
