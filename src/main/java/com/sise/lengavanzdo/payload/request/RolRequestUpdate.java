package com.sise.lengavanzdo.payload.request;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RolRequestUpdate {
    @Valid
    @NotNull(message = "The nombre is not null")
    private String nombre;

    @NotNull(message = "The descripcion is not null")
    private String descripcion;
}
