package com.example.Proveedores.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proveedores.Model.Recepcion;

@Repository
public interface RecepcionRepository extends JpaRepository<Recepcion, String> {
    
}
