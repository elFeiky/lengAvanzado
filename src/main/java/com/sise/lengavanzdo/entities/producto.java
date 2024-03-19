package com.sise.lengavanzdo.entities;

import lombok.Data;

import java.util.Date;
@Data
public class producto {
    private Integer idProducto;
    private String nombre;
    private Float precioUnitario;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
