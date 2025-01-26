package dev.kush.springdatajpaauditing.repos;

import dev.kush.springdatajpaauditing.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}