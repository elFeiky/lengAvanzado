package com.sise.lengavanzdo.entities;

import lombok.Data;

import java.util.Date;

@Data
public class proformaDetalle {
    private Integer idProformaDetalle;
    private proforma Proforma;
    //private producto Producto;
    private Integer cantidad;
    private String nombreProducto;
    private Float precioUnitario;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
