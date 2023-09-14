package com.example.Tp1JPALongo.repositorios;

import com.example.Tp1JPALongo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
