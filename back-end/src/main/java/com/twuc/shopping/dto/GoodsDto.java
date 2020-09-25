package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
    @NotEmpty
    private String name;
    @NotNull
    private int price;
    @NotEmpty
    private String unitOfMeasurement;
    @NotEmpty
    private String img;
}
