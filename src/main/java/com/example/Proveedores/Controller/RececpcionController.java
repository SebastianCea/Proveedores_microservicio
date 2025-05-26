package com.example.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proveedores.Model.Orden;
import com.example.Proveedores.Model.Recepcion;
import com.example.Proveedores.Service.OrdenService;
import com.example.Proveedores.Service.RecepcionService;

@RestController
@RequestMapping("/api/v1/recepciones")
public class RececpcionController {
    @Autowired
    private RecepcionService recepcionService;

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public ResponseEntity<List<Recepcion>> getRecepciones(){
        List<Recepcion> recepciones= recepcionService.recepciones();
        if(recepciones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(recepciones,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity <Recepcion> postRecepcion(@RequestBody Recepcion recepcion){
        String id_link=recepcion.getOrden().getId_orden();

        Orden orden=ordenService.ordenxId(id_link);
        if(orden!=null){
            recepcion.setOrden(orden);
        }

        Recepcion nuevo=recepcionService.guardar(recepcion);
        if(nuevo==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(nuevo,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Recepcion getRecepcion(@PathVariable String id_recepcion){
        return recepcionService.recepcionxId(id_recepcion);
    }

    @DeleteMapping
    public String deleteRecepcion(@PathVariable String id_recepcion){
        return recepcionService.eliminarRecepcion(id_recepcion);
    }
}
