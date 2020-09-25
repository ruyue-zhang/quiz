package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class GoodsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GoodsRepository goodsRepository;

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

}