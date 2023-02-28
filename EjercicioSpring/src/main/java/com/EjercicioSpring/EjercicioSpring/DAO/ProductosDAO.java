package com.EjercicioSpring.EjercicioSpring.DAO;

import com.EjercicioSpring.EjercicioSpring.modelo.ModeloProductos;

import java.util.List;

public interface ProductosDAO {

    List<ModeloProductos> getProductos();

    String insertarProducto(String nombre, String descripción, int precio);

    String eliminarProducto(int id);

    void actualizarProducto(int id, String nombre, String descripción, int precio);


}
