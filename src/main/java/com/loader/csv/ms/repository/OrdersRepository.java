package com.loader.csv.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loader.csv.ms.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

}
