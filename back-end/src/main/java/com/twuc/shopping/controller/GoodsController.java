package com.twuc.shopping.controller;

import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.service.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GoodsController {
    GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/goods")
    public ResponseEntity addGoods(@RequestBody @Valid GoodsDto goodsDto) {
        List<GoodsEntity> goodsList = goodsService.findAllByName(goodsDto.getName());
        if(goodsList.size() != 0) {
            return ResponseEntity.badRequest()
                    .build();
        }
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

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/goods")
    public List<GoodsDto> getAllGoods() {
        return goodsService.getAllGoods().stream().map(goodsEntity -> GoodsDto.builder()
                .name(goodsEntity.getName())
                .price(goodsEntity.getPrice())
                .unitOfMeasurement(goodsEntity.getUnitOfMeasurement())
                .img(goodsEntity.getImg())
                .build()
        ).collect(Collectors.toList());
    }
}
