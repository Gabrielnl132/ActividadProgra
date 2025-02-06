package com.example.Mascotas.Servicio;

import com.example.Mascotas.Entidad.Mascota;
import com.example.Mascotas.Repositorio.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }
}