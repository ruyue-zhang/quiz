package com.twuc.shopping.controller;

import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GoodsController {
    GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/goods")
    public ResponseEntity addGoods(@RequestBody @Valid GoodsDto goodsDto) {
        GoodsEntity goodsEntity = GoodsEntity.builder()
                .name(goodsDto.getName())
                .price(goodsDto.getPrice())
                .unitOfMeasurement(goodsDto.getUnitOfMeasurement())
                .img(goodsDto.getImg())
                .build();
        goodsService.addGoods(goodsEntity);
        return ResponseEntity.created(null)
                .build();
    }
}
