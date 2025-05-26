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

import com.example.Proveedores.Model.Proveedor;
import com.example.Proveedores.Service.ProveedorService;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getProveedor(){
        List<Proveedor> proveedores=proveedorService.proveedores();
        if(proveedores.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(proveedores,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proveedor> postProveedor(@RequestBody Proveedor proveedor){
        Proveedor nuevo= proveedorService.guardar(proveedor);
        if(nuevo==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(proveedor,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedor(@PathVariable String id_proveedor){
        return proveedorService.proveedorxId(id_proveedor);
    }

    @DeleteMapping
    public String deleteProveedor(@PathVariable String id_proveedor){
        return proveedorService.eliminarProveedor(id_proveedor);
    }
}
