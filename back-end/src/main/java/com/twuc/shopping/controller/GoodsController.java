package com.twuc.shopping.controller;

import com.twuc.shopping.dto.GoodsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GoodsController {
    @PostMapping("/goods")
    public ResponseEntity addGoods(@RequestBody @Valid GoodsDto goodsDto) {
        return ResponseEntity.created(null)
                .build();
    }
}
