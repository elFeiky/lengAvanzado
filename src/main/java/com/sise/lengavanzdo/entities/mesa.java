package com.sise.lengavanzdo.entities;
import lombok.Data;
import java.util.Date;
@Data
public class mesa {
private Integer idMesa;
private String descripcion;
private Integer capacidad;
private String estadoAuditoria;
private String usuarioCreacion;
private Date fechaCreacion;
private String usuarioModificacion;
private Date fechaModificacion;
}
