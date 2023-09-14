package com.example.Tp1JPALongo.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String estado;
    private Date fecha;
    private String tipoEnvio;
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetallePedido> detPedidos = new ArrayList();

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true)
    private Factura factura;

    public void addDetallePedido(DetallePedido detPed){
        this.detPedidos.add(detPed);
    }

}