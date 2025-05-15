package com.example.Proveedores.Model;

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
    private String id_receptor;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String direccion;

    @Column
    private int telefono;

    @Column
    private String email;

    @Column
    private String nacionalidad;
    }
}
