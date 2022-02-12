package com.itvdn.springbootpractice.service;

import com.itvdn.springbootpractice.dto.GoodsDto;
import com.itvdn.springbootpractice.entity.Goods;
import com.itvdn.springbootpractice.exception.ValidationException;

import java.util.List;

public interface IGoodsService {
    GoodsDto saveGood(GoodsDto goodsDto) throws ValidationException;

    void deleteGood(Long goodId);

    List<GoodsDto> findAllByBrand(String brand);

    List<GoodsDto> findAll();
}
