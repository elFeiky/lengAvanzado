package com.sise.lengavanzdo.payload.request;

import lombok.Data;

@Data
public class SucursalRequestUpdate {
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String imagenUrl;
}
