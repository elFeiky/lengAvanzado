package com.sise.lengavanzdo.payload.request;

import lombok.Data;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Data
public class RolRequestInsert {
    @Valid
    @NotNull(message = "The nombre is not null")
    private String nombre;

    @NotNull(message = "The descripcion is not null")
    private String descripcion;
}
