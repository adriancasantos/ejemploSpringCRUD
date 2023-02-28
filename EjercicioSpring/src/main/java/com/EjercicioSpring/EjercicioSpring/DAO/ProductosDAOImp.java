package com.EjercicioSpring.EjercicioSpring.DAO;

import com.EjercicioSpring.EjercicioSpring.modelo.ModeloProductos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductosDAOImp implements ProductosDAO {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<ModeloProductos> getProductos() {
        String query ="FROM ModeloProductos";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public String insertarProducto(String nombre, String descripción, int precio) {
        ModeloProductos producto = new ModeloProductos();
        producto.setNombre(nombre);
        producto.setDescripción(descripción);
        producto.setPrecio(precio);
        entityManager.persist(producto);
        return "Producto insertado";
    }

    //Eliminar productos con el checkbox marcado
    @Override
    public String eliminarProducto(int id) {
        ModeloProductos producto = entityManager.find(ModeloProductos.class, id);
        entityManager.remove(producto);
        return null;

    }

    //Actualizar productos
    @Override
    public void actualizarProducto(int id, String nombre, String descripción, int precio) {
        ModeloProductos producto = entityManager.find(ModeloProductos.class, id);
        producto.setNombre(nombre);
        producto.setDescripción(descripción);
        producto.setPrecio(precio);
        entityManager.merge(producto);
    }

}
