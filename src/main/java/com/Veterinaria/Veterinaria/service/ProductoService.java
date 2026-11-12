package com.Veterinaria.Veterinaria.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.Veterinaria.Veterinaria.model.ProductoVeterinario;

import jakarta.annotation.PostConstruct;

@Service
public class ProductoService {

    private List<ProductoVeterinario> productos = new ArrayList<>();

    @PostConstruct
    public void cargarDatos() {
        try {
            ClassPathResource resource = new ClassPathResource("Datos_Abiertos_Animales_de_Pro_20261112.csv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                
                String linea;
                boolean esPrimeraLinea = true;
                
                while ((linea = reader.readLine()) != null) {
                    if (esPrimeraLinea) {
                        esPrimeraLinea = false;
                        continue;
                    }
                    
                    String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    
                    if (partes.length >= 5) {
                        ProductoVeterinario p = new ProductoVeterinario();
                        p.setNombre(partes[0].replace("\"", "").trim());
                        p.setCategoria(partes[2].replace("\"", "").trim());
                        p.setPresentacion(partes[3].replace("\"", "").trim());
                        p.setEspecie(partes[4].replace("\"", "").trim());
                        
                        productos.add(p);
                    }
                }
                System.out.println("[OK] Datos cargados exitosamente: " + productos.size() + " productos.");
            }
        } catch (Exception e) {
            System.err.println("[ERROR] No se pudo leer el archivo CSV: " + e.getMessage());
            productos = Collections.emptyList();
        }
    }

    public List<ProductoVeterinario> obtenerTodos() {
        return productos;
    }

    public List<ProductoVeterinario> buscarProductos(String query) {
        if (query == null || query.isBlank()) {
            return productos;
        }
        String filtro = query.trim().toLowerCase();
        return productos.stream()
                .filter(p -> 
                    (p.getNombre() != null && p.getNombre().toLowerCase().contains(filtro)) ||
                    (p.getEspecie() != null && p.getEspecie().toLowerCase().contains(filtro)) ||
                    (p.getCategoria() != null && p.getCategoria().toLowerCase().contains(filtro))
                )
                .toList();
    }
}