package com.sise.lengavanzdo.entities;
import lombok.Data;

import java.util.Date;
@Data
public class proforma {
    private Integer idProforma;
    private asignacionMesa AsignacionMesa;
    private String codigoProforma;
    private String nombreCliente;
    private Float precioTotal;
    private String observaciones;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
