package com.sise.lengavanzdo.entities;

import lombok.Data;

import java.util.Date;
@Data
public class rol {
    private Integer idRol;
    private String nombre;
    private String descripcion;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;

}
