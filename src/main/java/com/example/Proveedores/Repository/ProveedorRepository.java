package com.example.Proveedores.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proveedores.Model.Proveedor;



@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String>  {

}
