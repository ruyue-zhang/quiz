package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class GoodsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GoodsRepository goodsRepository;

    @BeforeEach
    void setUp() {
        goodsRepository.deleteAll();;
    }

    @Test
    void should_not_add_when_name_is_empty() throws Exception {
        GoodsDto goodsDto = GoodsDto.builder()
                .name(null)
                .price(1)
                .unitOfMeasurement("个")
                .img("11111")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String goodsJson = objectMapper.writeValueAsString(goodsDto);

        mockMvc.perform(post("/goods")
                .content(goodsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_not_add_when_price_is_empty() throws Exception {
        GoodsDto goodsDto = GoodsDto.builder()
                .name("苹果")
                .unitOfMeasurement("个")
                .img("11111")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String goodsJson = objectMapper.writeValueAsString(goodsDto);

        mockMvc.perform(post("/goods")
                .content(goodsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_not_add_when_unit_is_empty() throws Exception {
        GoodsDto goodsDto = GoodsDto.builder()
                .name("苹果")
                .price(1)
                .img("11111")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String goodsJson = objectMapper.writeValueAsString(goodsDto);

        mockMvc.perform(post("/goods")
                .content(goodsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_not_add_when_img_is_empty() throws Exception {
        GoodsDto goodsDto = GoodsDto.builder()
                .name("苹果")
                .price(1)
                .unitOfMeasurement("瓶")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String goodsJson = objectMapper.writeValueAsString(goodsDto);

        mockMvc.perform(post("/goods")
                .content(goodsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_add_when_input_is_correct() throws Exception {
        GoodsDto goodsDto = GoodsDto.builder()
                .name("苹果")
                .price(1)
                .unitOfMeasurement("瓶")
                .img("1111")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String goodsJson = objectMapper.writeValueAsString(goodsDto);

        mockMvc.perform(post("/goods")
                .content(goodsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        assertEquals(1, goodsEntities.size());
        assertEquals("苹果", goodsEntities.get(0).getName());
        assertEquals(1, goodsEntities.get(0).getPrice());
        assertEquals("瓶", goodsEntities.get(0).getUnitOfMeasurement());
        assertEquals("1111", goodsEntities.get(0).getImg());
    }

    @Test
    void should_not_add_when_name_is_exist() throws Exception {
        GoodsEntity goodsEntity = GoodsEntity.builder()
                .name("可乐")
                .price(2)
                .unitOfMeasurement("瓶")
                .img("2222")
                .build();
        goodsRepository.save(goodsEntity);

        GoodsDto goodsDto = GoodsDto.builder()
                .name("可乐")
                .price(1)
                .unitOfMeasurement("瓶")
                .img("1111")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String goodsJson = objectMapper.writeValueAsString(goodsDto);

        mockMvc.perform(post("/goods")
                .content(goodsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_get_all_goods() throws Exception {
        GoodsEntity goodsEntity1 = GoodsEntity.builder()
                .name("苹果")
                .price(1)
                .unitOfMeasurement("斤")
                .img("1111")
                .build();
        GoodsEntity goodsEntity2 = GoodsEntity.builder()
                .name("可乐")
                .price(2)
                .unitOfMeasurement("瓶")
                .img("2222")
                .build();
        goodsRepository.save(goodsEntity1);
        goodsRepository.save(goodsEntity2);

        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("苹果")))
                .andExpect(jsonPath("$[0].price", is(1)))
                .andExpect(jsonPath("$[0].unitOfMeasurement", is("斤")))
                .andExpect(jsonPath("$[0].img", is("1111")))
                .andExpect(jsonPath("$[1].name", is("可乐")))
                .andExpect(jsonPath("$[1].price", is(2)))
                .andExpect(jsonPath("$[1].unitOfMeasurement", is("瓶")))
                .andExpect(jsonPath("$[1].img", is("2222")));

    }
}