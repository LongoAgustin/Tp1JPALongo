package com.example.Tp1JPALongo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rubro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String denominacion;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }



}
