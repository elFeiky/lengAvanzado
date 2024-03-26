package com.sise.lengavanzdo.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.lengavanzdo.entities.rol;
import com.sise.lengavanzdo.repositories.RolRepository;
import com.sise.lengavanzdo.services.RolService;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    RolRepository rolRepository;

    @Override
    public List<rol> listarRoles() {
        return rolRepository.findByEstadoAuditoria("1");
    }

    @Override
    public rol listarRolPorId(Integer id) {
        return rolRepository.findOneByIdRolAndEstadoAuditoria(id, "1");
    }

    @SuppressWarnings("null")
    @Override
    public rol insertarRol(rol rol) {
        return rolRepository.save(rol);
    }

    @SuppressWarnings("null")
    @Override
    public rol actualizarRol(rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void darBajaRol(Integer id) {
        rolRepository.darBajaRol(id);
    }
}

