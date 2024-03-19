package com.sise.lengavanzdo.repositories;

import com.sise.lengavanzdo.entities.sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SucursalRepository extends JpaRepository<sucursal,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE sucursal s set s.estadoAuditoria = '0' WHERE s.idSucursal = :id")
    void darBajaSucursal(@Param("id") Integer id);

}
