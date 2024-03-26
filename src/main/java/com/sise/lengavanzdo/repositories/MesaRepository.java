package com.sise.lengavanzdo.repositories;
import java.util.List;

import com.sise.lengavanzdo.entities.mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

@Repository
public interface MesaRepository extends JpaRepository<mesa,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE mesa s SET s.estadoAuditoria = '0' WHERE s.idMesa = :id")
    void darBajaMesa(@Param("id") Integer id );

    List<mesa> findByEstadoAuditoria(String estadoAuditoria);

    mesa  findOneByIdMesaAndEstadoAuditoria(Integer idMesa,String estadoAuditoria);

}
