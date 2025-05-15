package com.example.Proveedores.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Proveedores.Model.Proveedor;

@Repository
public class ProveedorRepository {
    
    private List<Proveedor> proveedor = new ArrayList<>();

    public Proveedor create(Proveedor proveedor){
        proveedor.add(proveedor);
        System.out.println(proveedor.toString());
        return proveedor;
        }

    public List<Proveedor> readAll(){
        return proveedor;    
    }

    public Proveedor read(String id_proveedor){
        for (Proveedor proveedor : proveedores){
            if(proveedor.getId_proveedor()==id_proveedor){
                return proveedor;
            }
        }
        return null;
    }

    public Proveedor update(String id_proveedor, Proveedor pmodificada){
        Proveedor pr=read(id_proveedor);
        if(pr!=null){
            pr.setId_receptor(pmodificada.getId_receptor());
            pr.setNombre(pmodificada.getNombre());
            pr.setApellido(pmodificada.getApellido());
            pr.setDireccion(pmodificada.getDireccion());
            pr.setTelefono(pmodificada.getTelefono());
            return pr;
        }
        return null;
    }
    
    public String delete (String id_envio){
        envio kill=read(id_envio);
        if(kill!=null){
            envios.remove(kill);
            return "Envío Eliminado";
        }
        return "Envío no encontrado";
    }
}
