package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.OrderedProduct;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {

}
