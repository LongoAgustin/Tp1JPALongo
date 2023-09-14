package com.example.Tp1JPALongo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rubro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String denominacion;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Producto> prod = new ArrayList<>();

    public void addProducto(Producto producto1){
        this.prod.add(producto1);
    }



}
