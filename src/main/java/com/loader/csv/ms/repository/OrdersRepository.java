package com.loader.csv.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loader.csv.ms.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
