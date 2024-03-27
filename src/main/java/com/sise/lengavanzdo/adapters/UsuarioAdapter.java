package com.sise.lengavanzdo.adapters;

import com.sise.lengavanzdo.entities.rol;
import com.sise.lengavanzdo.entities.ususario;
import com.sise.lengavanzdo.payload.request.UsuarioRequestInsert;
import com.sise.lengavanzdo.payload.request.UsuarioRequestUpdate;
import com.sise.lengavanzdo.payload.request.UsuarioRequestUpdateClave;
import com.sise.lengavanzdo.utils.AdapterTemplate;

public class UsuarioAdapter implements AdapterTemplate<ususario, UsuarioRequestInsert, UsuarioRequestUpdate> {
    @Override
    public ususario insertToEntity(UsuarioRequestInsert insert) {
        ususario usuario = new ususario();

        rol rol = new rol();
        rol.setIdRol(insert.getIdRol());

        usuario.setRol(rol);
        usuario.setUsername(insert.getUsername());
        usuario.setCorreo(insert.getCorreo());
        usuario.setClave(insert.getClave());
        return usuario;
    }
    @Override
    public ususario updateToEntity(UsuarioRequestUpdate update) {
        ususario usuario = new ususario();

        rol rol = new rol();
        rol.setIdRol(update.getIdRol());

        usuario.setRol(rol);
        usuario.setCorreo(update.getCorreo());
        return usuario;
    }
    public ususario updateClaveToEntity(UsuarioRequestUpdateClave update) {
        ususario usuario = new ususario();
        usuario.setClave(update.getClave());
        return usuario;
    }
}
