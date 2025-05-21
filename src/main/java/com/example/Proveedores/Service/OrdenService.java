package com.example.Proveedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proveedores.Model.Orden;
import com.example.Proveedores.Repository.OrdenRepository;

@Service
public class OrdenService {
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> ordenes(){
        return ordenRepository.findAll();
    }

    public Orden guardar(Orden orden){
        return ordenRepository.save(orden);
    }

    public Orden ordenxId(String id){
        return ordenRepository.getReferenceById(id);
    }
}
