package com.sise.lengavanzdo.services.Impl;

import com.sise.lengavanzdo.entities.sucursal;
import com.sise.lengavanzdo.repositories.SucursalRepository;
import com.sise.lengavanzdo.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;
    @Override
    public List<sucursal> listarSucursales() {
        return sucursalRepository.findAll();
    }

    @Override
    public sucursal listarSucursalPorId(Integer id) {
        return sucursalRepository.findById(id).orElse(new sucursal());
    }

    @Override
    public sucursal insertarSucursal(sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public sucursal actualizarSucursal(sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void darBajaSucursal(Integer id) {
       sucursalRepository.darBajaSucursal(id);

    }
}
