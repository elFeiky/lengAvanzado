package com.sise.lengavanzdo.services.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.lengavanzdo.entities.mesa;
import com.sise.lengavanzdo.repositories.MesaRepository;
import com.sise.lengavanzdo.services.MesaService;

@Service
public class MesaServiceImpl implements MesaService{
    @Autowired
    MesaRepository mesaRespository;

    @Override
    public List<mesa> listarMesa() {
        return mesaRespository.findByEstadoAuditoria("1");
    }

    @Override
    public mesa listarMesaPorId(Integer id) {
        return mesaRespository.findOneByIdMesaAndEstadoAuditoria(id, "0");
    }

    @SuppressWarnings("null")
    @Override
    public mesa insertarMesa(mesa mesa) {
        return mesaRespository.save(mesa);
    }

    @SuppressWarnings("null")
    @Override
    public mesa actualizarMesa(mesa mesa) {
        return mesaRespository.save(mesa);
    }

    @Override
    public void darBajaMesa(Integer id) {
        mesaRespository.darBajaMesa(id);
    }
}
