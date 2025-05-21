package com.example.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proveedores.Model.Orden;
import com.example.Proveedores.Model.Proveedor;
import com.example.Proveedores.Service.OrdenService;
import com.example.Proveedores.Service.ProveedorService;

@RestController
@RequestMapping("/api/v1/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Orden>> getOrden(){
        List<Orden> ordenes=ordenService.ordenes();
        if(ordenes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordenes,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Orden> postOrden(@RequestBody Orden orden){
        String id_link=orden.getProveedor().getId_proveedor();

        Proveedor proveedor=proveedorService.proveedorxId(id_link);
        if(proveedor!=null){
            orden.setProveedor(proveedor);
        }

        Orden nuevo = ordenService.guardar(orden);
        if(nuevo==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(nuevo,HttpStatus.CREATED);
    }
}
