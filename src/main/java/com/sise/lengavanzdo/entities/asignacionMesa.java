package com.sise.lengavanzdo.entities;

import lombok.Data;

import java.util.Date;
@Data
public class asignacionMesa {
private Integer idAsignacionMesa;
private sucursal Sucursal;
private mesa Mesa;
private ususario Usuario;
private String turno;
private String estadoAuditoria;
private String usuarioCreacion;
private Date fechaCreacion;
private String usuarioModificacion;
private Date fechaModificacion;
}
