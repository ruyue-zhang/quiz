package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    private String unitOfMeasurement;
    @NotNull
    private String img;
}
