package com.sise.lengavanzdo.adapters;

import com.sise.lengavanzdo.entities.sucursal;
import com.sise.lengavanzdo.payload.request.SucursalRequestInsert;
import com.sise.lengavanzdo.payload.request.SucursalRequestUpdate;
import com.sise.lengavanzdo.utils.AdapterTemplate;

public class SucursalAdapter implements AdapterTemplate<sucursal, SucursalRequestInsert, SucursalRequestUpdate> {
    @Override
    public sucursal insertToEntity(SucursalRequestInsert insert) {
        sucursal entity = new sucursal();
        entity.setNombre(insert.getNombre());
        entity.setDireccion(insert.getDireccion());
        entity.setTelefono(insert.getTelefono());
        entity.setDescripcion(insert.getDescripcion());
        entity.setImagienUrl(insert.getImagenUrl());
        return entity;
    }

    @Override
    public sucursal updateToEntity(SucursalRequestUpdate update) {
        sucursal sucursal = new sucursal();
        sucursal.setNombre(update.getNombre());
        sucursal.setDireccion(update.getDireccion());
        sucursal.setTelefono(update.getTelefono());
        sucursal.setDescripcion(update.getDescripcion());
        sucursal.setImagienUrl(update.getImagenUrl());
        return sucursal;
    }
}
