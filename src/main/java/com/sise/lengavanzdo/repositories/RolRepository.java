package com.sise.lengavanzdo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.lengavanzdo.entities.rol;

import jakarta.transaction.Transactional;

@Repository
public interface RolRepository extends JpaRepository<rol,Integer>{
    @Modifying
    @Transactional
    @Query("UPDATE rol r SET r.estadoAuditoria = '0' WHERE r.idRol = :id")
    void darBajaRol(@Param("id") Integer id);

    List<rol> findByEstadoAuditoria(String estadoAuditoria);

    rol findOneByIdRolAndEstadoAuditoria(Integer idRol, String estadoAuditoria);

}
