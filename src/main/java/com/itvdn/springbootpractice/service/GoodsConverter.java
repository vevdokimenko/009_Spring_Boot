package com.itvdn.springbootpractice.service;

import com.itvdn.springbootpractice.dto.GoodsDto;
import com.itvdn.springbootpractice.entity.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsConverter {
    public Goods goodsDtoToGoods(GoodsDto goodsDto) {
        Goods goods = new Goods();
        goods.setId(goodsDto.getId());
        goods.setBrand(goodsDto.getBrand());
        goods.setName(goodsDto.getName());
        return goods;
    }

    public GoodsDto goodsToGoodsDto(Goods goods) {
        return GoodsDto.builder()
                .id(goods.getId())
                .brand(goods.getBrand())
                .name(goods.getName())
                .build();
    }
}
