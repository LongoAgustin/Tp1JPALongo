package com.example.Tp1JPALongo.repositorios;

import com.example.Tp1JPALongo.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
