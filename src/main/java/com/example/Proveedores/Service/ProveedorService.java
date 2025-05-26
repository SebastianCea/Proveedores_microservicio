package com.example.Proveedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proveedores.Model.Proveedor;
import com.example.Proveedores.Repository.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> proveedores(){
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public Proveedor proveedorxId(String id){
        return proveedorRepository.getReferenceById(id);
    }

    public String eliminarProveedor(String id){
        if(proveedorRepository.existsById(id)){
            proveedorRepository.deleteById(id);
            return "Proveedor eliminado";
        }
        return "No se encontró al proveedor";
    }
}
