package com.sise.lengavanzdo.shared;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name = "estado_auditoria",insertable = false, updatable = false)
    private String estadoAuditoria;

    @Column(name = "usuario_creacion", updatable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion",insertable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "usuario_modificacion",insertable = false, updatable = false)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion",insertable = false)
    @UpdateTimestamp
    private Date fechaModificacion;
}
