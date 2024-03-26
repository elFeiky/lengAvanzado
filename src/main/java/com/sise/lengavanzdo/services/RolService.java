package com.sise.lengavanzdo.services;

import com.sise.lengavanzdo.entities.rol;

import java.util.List;

public interface RolService {
    List<rol> listarRoles();
    rol listarRolPorId(Integer id);
    rol insertarRol(rol rol);
    rol actualizarRol(rol rol);
    void darBajaRol(Integer id);
}
