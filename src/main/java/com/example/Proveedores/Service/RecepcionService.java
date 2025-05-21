package com.example.Proveedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proveedores.Model.Recepcion;
import com.example.Proveedores.Repository.RecepcionRepository;

@Service
public class RecepcionService {
    @Autowired
    private RecepcionRepository recepcionRepository;

    public List<Recepcion> recepciones(){
        return recepcionRepository.findAll();
    }
    
    public Recepcion guardar(Recepcion recepcion){
        return recepcionRepository.save(recepcion);
    }

    public Recepcion recepcionxId(String id){
        return recepcionRepository.getReferenceById(id);
    }
}
