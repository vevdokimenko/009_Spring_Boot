package com.itvdn.springbootpractice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsDto {
    private long id;
    private String name;
    private String brand;
}
