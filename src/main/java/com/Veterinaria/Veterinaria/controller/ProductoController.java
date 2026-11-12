package com.Veterinaria.Veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Veterinaria.Veterinaria.model.ProductoVeterinario;
import com.Veterinaria.Veterinaria.service.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String listarProductos(@RequestParam(required = false) String q, Model model) {
        List<ProductoVeterinario> lista = productoService.buscarProductos(q);
        model.addAttribute("productos", lista);
        model.addAttribute("busqueda", q);
        model.addAttribute("total", lista.size());
        return "productos";
    }
}