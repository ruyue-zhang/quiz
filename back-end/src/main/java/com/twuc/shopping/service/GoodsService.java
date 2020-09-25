package com.twuc.shopping.service;

import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void addGoods(GoodsEntity goodsEntity) {
        goodsRepository.save(goodsEntity);
    }

    public List<GoodsEntity> getAllGoods() {
        return goodsRepository.findAll();
    }
}
