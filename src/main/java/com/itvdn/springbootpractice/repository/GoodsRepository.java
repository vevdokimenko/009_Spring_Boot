package com.itvdn.springbootpractice.repository;

import com.itvdn.springbootpractice.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAllByBrand(String brand);
}
