package com.example.Proveedores.Model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name= "Orden_Abastecimiento")
public class Orden {
    @Id
    private String id_orden;

    @Column
    private int cantidad;

    @Column
    private LocalDate fecha_estimada;

    @ManyToOne()
    @JoinColumn( name = "id_proveedor" )
    @JsonBackReference
    private Proveedor proveedor;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference

    private List<Recepcion> recepcion_producto;
}
