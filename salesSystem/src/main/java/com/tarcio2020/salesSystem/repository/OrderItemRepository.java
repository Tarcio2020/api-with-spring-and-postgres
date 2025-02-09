package com.tarcio2020.salesSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarcio2020.salesSystem.entities.OrderItem;
import com.tarcio2020.salesSystem.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}