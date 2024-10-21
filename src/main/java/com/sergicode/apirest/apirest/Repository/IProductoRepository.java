package com.sergicode.apirest.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergicode.apirest.apirest.Entities.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long>{
    

}
