package com.itvdn.springbootpractice.controller;

import com.itvdn.springbootpractice.dto.GoodsDto;
import com.itvdn.springbootpractice.exception.ValidationException;
import com.itvdn.springbootpractice.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping("/save")
    public GoodsDto saveUsers(@RequestBody GoodsDto goodsDto) throws ValidationException {
        return goodsService.saveGood(goodsDto);
    }

    @GetMapping("/findAll")
    public List<GoodsDto> findAll() {
        return goodsService.findAll();
    }

    @GetMapping("/findByBrand")
    public List<GoodsDto> findByBrand(@RequestParam String brand) {
        return goodsService.findAllByBrand(brand);
    }

    @GetMapping("/delete/{id}")
    public String deleteGoods(@PathVariable Long id) {
        goodsService.deleteGood(id);
        return "redirect:/goods/findAll";
    }
}
