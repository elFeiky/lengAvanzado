package com.sise.lengavanzdo.payload.responses;

import lombok.Data;

@Data
public class SucursalResponse {
    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String imagenUrl;
}
