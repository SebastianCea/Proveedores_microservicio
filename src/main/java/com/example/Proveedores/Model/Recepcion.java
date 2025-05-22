package com.example.Proveedores.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name= "Recepcion")
public class Recepcion {
    @Id
    private String id_recepcion;

    @Column(nullable = false)
    private LocalDate fecha_recepcion;

    @Column(nullable = false)
    private int cantidad_recibida;

    @ManyToOne()
    @JoinColumn(name = "id_orden")
    @JsonBackReference
    private Orden orden;
    

    /*id_producto FK*/
}
