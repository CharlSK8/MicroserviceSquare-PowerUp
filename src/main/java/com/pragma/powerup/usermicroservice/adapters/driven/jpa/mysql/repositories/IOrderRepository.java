package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OrderEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT COUNT(*) > 0 FROM OrderEntity p WHERE p.ownerId = :idOwner AND p.status IN ('en_preparacion', 'pendiente', 'listo')")
    boolean existsOrdersInProcessByOwnerId(@Param("idOwner") Long idOwner);
}
