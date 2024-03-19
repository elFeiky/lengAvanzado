package com.sise.lengavanzdo.services;

import com.sise.lengavanzdo.entities.sucursal;

import java.util.List;

public interface SucursalService {
    List<sucursal> listarSucursales();
    sucursal listarSucursalPorId(Integer id);
    sucursal insertarSucursal(sucursal sucursal);
    sucursal actualizarSucursal(sucursal sucursal);
    void darBajaSucursal(Integer id);
}
