package com.example.Proveedores.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "Proveedores")
public class Proveedor {
    @Id
    private String id_proveedor;

    @Column (length = 50, nullable = false)
    private String nombre;

    @Column (length = 50, nullable = false)
    private String direccion;

    @Column (length = 20, nullable = false)
    private int telefono;

    @Column (length = 50,  nullable = false)
    private String email;

    @Column (length = 30, nullable = false)
    private String nacionalidad;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference

    private List<Orden> orden_Abastecimiento;

}
