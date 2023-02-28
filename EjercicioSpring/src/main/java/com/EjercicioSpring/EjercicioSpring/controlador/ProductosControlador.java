package com.EjercicioSpring.EjercicioSpring.controlador;

import com.EjercicioSpring.EjercicioSpring.DAO.ProductosDAO;
import com.EjercicioSpring.EjercicioSpring.DAO.ProductosDAOImp;
import com.EjercicioSpring.EjercicioSpring.modelo.ModeloProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductosControlador {
    @Autowired
    private ProductosDAO productosDAO;


    //Listar todos los productos
    @GetMapping("/listar")
    public List<ModeloProductos> getProductos(){

        return productosDAO.getProductos();

    }

    //Añadir un producto
    @PostMapping(path = "/insertar/{nombre}/{descripción}/{precio}")
    public void  insertarProducto(@PathVariable String nombre, @PathVariable String descripción, @PathVariable int precio){
        productosDAO.insertarProducto(nombre, descripción, precio);
    }

    //Eliminar un producto
    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable int id){
        productosDAO.eliminarProducto(id);
    }

    //Actualizar un producto
    @PutMapping("/actualizar/{id}/{nombre}/{descripción}/{precio}")
    public void actualizarProducto(@PathVariable int id, @PathVariable String nombre, @PathVariable String descripción, @PathVariable int precio){
        productosDAO.actualizarProducto(id, nombre, descripción, precio);
    }

}