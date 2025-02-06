package com.example.Mascotas.Controlador;

import com.example.Mascotas.Entidad.Cliente;
import com.example.Mascotas.Entidad.Mascota;
import com.example.Mascotas.Entidad.Producto;
import com.example.Mascotas.Servicio.MascotaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Controller
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;


    @GetMapping("/")
    public String vista() {
        return "/index";
    }

    //LISTADO DE MASCOTAS
    @GetMapping("/listaMascotas")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.listarMascotas());
        return "/pages/vistaMascota";
    }




    // LISTADO DE LOS CLIENTES
    @GetMapping("/listaCliente")
    public String listadoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "/pages/vistaCliente";
    }


    //LISTADO DE PRODUCTOS
    @GetMapping("/listaProductos")
    public String listadoProductos(Model model) {
        model.addAttribute("producto", new Producto());
        return "/pages/vistaProducto";
    }


    @PostMapping("/guardar")
    public String crearMascota(Mascota mascota) {
        mascotaService.guardarMascota(mascota);
        return "redirect:/mascotas";
    }

    // ACTUALIZAR
    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable Long id, Model model) {
        Optional<Mascota> mascota = mascotaService.buscarMascota(id);
        model.addAttribute("mascota", mascota);
        return "/Mascota/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/mascotas";
    }
}