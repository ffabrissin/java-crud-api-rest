package com.sergicode.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergicode.apirest.apirest.Repository.IProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.sergicode.apirest.apirest.Entities.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoRepository productoRepo;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepo.findById(id).orElse(null);
    }
    
    
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepo.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto prod = productoRepo.findById(id).orElse(null);

        prod.setNombre(producto.getNombre());
        prod.setPrecio(producto.getPrecio());

        return productoRepo.save(prod);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto prod = productoRepo.findById(id).orElse(null);
        productoRepo.delete(prod);

        return "El producto se elimino correctamente.";
    }


}
