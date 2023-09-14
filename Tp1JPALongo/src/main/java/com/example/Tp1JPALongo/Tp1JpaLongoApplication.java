package com.example.Tp1JPALongo;

import com.example.Tp1JPALongo.entidades.*;
import com.example.Tp1JPALongo.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Date;

@SpringBootApplication
public class Tp1JpaLongoApplication {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    RubroRepository rubroRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp1JpaLongoApplication.class, args);
        System.out.println("En Funcionamiento");

    }

    @Bean
    CommandLineRunner init(ClienteRepository clienterepo) {
        return args -> {
            System.out.println("Bean");

            //Cliente
            Cliente cliente1 = new Cliente();

            cliente1.setNombre("Agustin");
            cliente1.setApellido("Longo");
            cliente1.setTelefono("2616180808");
            cliente1.setEmail("aguslongo69@gmail.com");

            //Domicilio
            Domicilio dom1 = new Domicilio();
            dom1.setCalle("Urquiza");
            dom1.setLocalidad("Guaymallen");
            dom1.setNumero("2500");

            cliente1.addDomicilio(dom1);

            //Pedido
            Pedido pedido1 = new Pedido();


            pedido1.setEstado("Iniciado");
            pedido1.setFecha(new Date());
            pedido1.setTipoEnvio("Delivery");
            pedido1.setTotal(785.21);

            cliente1.addPedidos(pedido1);

            //Factura

            Factura factura1 = new Factura();

            factura1.setNumero(1);
            factura1.setFecha(new Date());
            factura1.setFormaPago("Efectivo");
            factura1.setTotal(785.21);
            factura1.setDescuento(factura1.getTotal() * 0.25);

            pedido1.setFactura(factura1);

            //DetallePedido

            DetallePedido detped1 = new DetallePedido();

            detped1.setCantidad(8);
            detped1.setSubtotal(40);

            pedido1.addDetallePedido(detped1);

            //Producto

            Producto prod1 = new Producto();

            prod1.setDenominacion("Pizza a la Piedra");
            prod1.setReceta("Azucar, Flores, Muchos Colores");
            prod1.setTipo("Manufacturado");
            prod1.setPrecioVenta(500);
            prod1.setPrecioCompra(300);
            prod1.setStockActual(3);
            prod1.setStockMinimo(1);
            prod1.setTiemposEStimadoCocina(30);
            prod1.setUnidadMedida("Fraccionado");

            detped1.setProducto(prod1);

            //Rubro

            Rubro rubro = new Rubro();

            rubro.setDenominacion("Casero");
            rubro.addProducto(prod1);



            productoRepository.save(prod1);
            rubroRepository.save(rubro);
            facturaRepository.save(factura1);
            pedidoRepository.save(pedido1);
            clienteRepository.save(cliente1);

            // Recuperar el objeto Persona desde la base de datos
            Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
            if (clienteRecuperado != null) {
                System.out.println("Nombre: " + clienteRecuperado.getNombre());
                System.out.println("Apellido: " + clienteRecuperado.getApellido());
                System.out.println("Telefono: " + clienteRecuperado.getTelefono());
                System.out.println("Email: " + clienteRecuperado.getEmail());
            }



        };
    }
}
