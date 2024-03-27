package com.sise.lengavanzdo.adapters;

import com.sise.lengavanzdo.entities.rol;
import com.sise.lengavanzdo.payload.request.RolRequestInsert;
import com.sise.lengavanzdo.payload.request.RolRequestUpdate;
import com.sise.lengavanzdo.utils.AdapterTemplate;

public class RolAdapter implements AdapterTemplate<rol, RolRequestInsert, RolRequestUpdate> {
    @Override
    public rol insertToEntity(RolRequestInsert insert) {
        rol rol = new rol();
        rol.setNombre(insert.getNombre());
        rol.setDescripcion(insert.getDescripcion());
        return rol;
    }

    @Override
    public rol updateToEntity(RolRequestUpdate update) {
        rol rol = new rol();
        rol.setNombre(update.getNombre());
        rol.setDescripcion(update.getDescripcion());
        return rol;
    }
}
