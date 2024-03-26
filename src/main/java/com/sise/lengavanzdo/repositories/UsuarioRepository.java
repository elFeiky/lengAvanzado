package com.sise.lengavanzdo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sise.lengavanzdo.entities.rol;
import com.sise.lengavanzdo.entities.ususario;

@Repository
public interface UsuarioRepository extends JpaRepository<ususario, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE ususario u SET u.estadoAuditoria = '0' WHERE u.idUsuario = :id")
    void darBajaUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE ususario u SET u.correo = :correo, u.Rol = :rol WHERE u.idUsuario = :id")
    void actualizarUsuario(@Param("id") Integer id,@Param("rol") rol rol, @Param("correo")  String correo);
    //posible error por el nombre de entity "rol", no estoy seguro

    @Modifying
    @Transactional
    @Query("UPDATE ususario u SET u.clave = :clave WHERE u.idUsuario = :id")
    void cambiarClaveUsuario(@Param("id") Integer id, @Param("clave")  String clave);

    List<ususario> findByEstadoAuditoria(String estadoAuditoria);
    ususario findOneByIdUsuarioAndEstadoAuditoria(Integer idUsuario, String estadoAuditoria);
}
