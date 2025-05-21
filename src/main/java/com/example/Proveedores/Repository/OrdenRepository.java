package com.example.Proveedores.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proveedores.Model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, String> {

}
