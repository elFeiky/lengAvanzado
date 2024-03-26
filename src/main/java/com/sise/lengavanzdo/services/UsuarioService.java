package com.sise.lengavanzdo.services;
import com.sise.lengavanzdo.entities.ususario;

import java.util.List;

public interface UsuarioService {
    List<ususario> listarUsuarios();
    ususario listarUsuarioPorId(Integer id);
    ususario insertarUsuario(ususario usuario);
    ususario actualizarUsuario(ususario usuario);
    void cambiarClaveUsuario(ususario usuario);
    void darBajaUsuario(Integer id);
}
