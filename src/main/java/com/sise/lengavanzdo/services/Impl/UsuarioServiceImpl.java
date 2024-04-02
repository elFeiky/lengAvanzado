package com.sise.lengavanzdo.services.Impl;
import java.util.List;

import com.sise.lengavanzdo.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.lengavanzdo.entities.ususario;
import com.sise.lengavanzdo.repositories.UsuarioRepository;
import com.sise.lengavanzdo.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    //PasswordEncoder passwordEncoder;

    @Override
    public List<ususario> listarUsuarios() {
        return usuarioRepository.findByEstadoAuditoria("1");
    }

    @Override
    public ususario listarUsuarioPorId(Integer id) {
        return usuarioRepository.findOneByIdUsuarioAndEstadoAuditoria(id, "1");
    }

    @Override
    public ususario insertarUsuario(ususario usuario) {
        usuario.setClave(PasswordUtil.encode(usuario.getClave()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public ususario actualizarUsuario(ususario usuario) {
        usuarioRepository.actualizarUsuario(usuario.getIdUsuario(), usuario.getRol(), usuario.getCorreo());
        return usuarioRepository.findOneByIdUsuarioAndEstadoAuditoria(usuario.getIdUsuario(), "1");
    }

    @Override
    public void cambiarClaveUsuario(ususario usuario) {
        usuarioRepository.cambiarClaveUsuario(usuario.getIdUsuario(),PasswordUtil.encode(usuario.getClave()));
    }

    @Override
    public void darBajaUsuario(Integer id) {
        usuarioRepository.darBajaUsuario(id);
    }
}
