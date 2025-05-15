package com.example.Proveedores.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Proveedor {
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "Proveedor")
public class proveedor {
    @Id
    private String id_proveedor;

    @Column
    private String destino;

    @Column
    private String estado;

    @Column
    private String origen;

    @Column
    private String id_cliente;

    @Column
    private String id_venta;

    @Column
    private LocalDate fecha_salida;

    @Column 
    private LocalDate fecha_entrega;
    }
}
