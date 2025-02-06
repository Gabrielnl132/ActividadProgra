package com.example.Mascotas.Controlador;

import com.example.Mascotas.Servicio.MascotaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/mascotas")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.listarMascotas());
        return "mascotas";
    }
}