package com.EjercicioSpring.EjercicioSpring.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "productos")
@Entity
@ToString
@EqualsAndHashCode
public class ModeloProductos {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripción")
    private String descripción;
    @Column(name = "precio")
    private int precio;

    public ModeloProductos() {

    }
}