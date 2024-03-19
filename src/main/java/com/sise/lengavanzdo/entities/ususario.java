package com.sise.lengavanzdo.entities;
import lombok.Data;

import java.util.Date;

@Data
public class ususario {
    private Integer idUsuario;
    private rol Rol;
    private String username;
    private String correo;
    private String clave;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String getUsuarioModificacion;
    private Date fechaModificiacion;

}
