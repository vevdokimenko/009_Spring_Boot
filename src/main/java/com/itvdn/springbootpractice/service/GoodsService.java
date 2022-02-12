package com.itvdn.springbootpractice.service;

import com.itvdn.springbootpractice.dto.GoodsDto;
import com.itvdn.springbootpractice.entity.Goods;
import com.itvdn.springbootpractice.exception.ValidationException;
import com.itvdn.springbootpractice.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class GoodsService implements IGoodsService {
    private GoodsRepository goodsRepository;
    private GoodsConverter goodsConverter;

    @Override
    public GoodsDto saveGood(GoodsDto goodsDto) throws ValidationException {
        validateGoodsDto(goodsDto);
        Goods savedGood = goodsRepository.save(goodsConverter.goodsDtoToGoods(goodsDto));
        return goodsConverter.goodsToGoodsDto(savedGood);
    }

    @Override
    public void deleteGood(Long goodId) {
        goodsRepository.deleteById(goodId);
    }

    @Override
    public List<GoodsDto> findAll() {
        return goodsRepository.findAll()
                .stream()
                .map(goodsConverter::goodsToGoodsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GoodsDto> findAllByBrand(String brand) {
        return goodsRepository.findAllByBrand(brand).stream()
                .map(goodsConverter::goodsToGoodsDto)
                .collect(Collectors.toList());
    }

    private void validateGoodsDto(GoodsDto goodsDto) throws ValidationException {
        if (isNull(goodsDto)) {
            throw new ValidationException("Object good is null");
        }
    }
}
