/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appagend;

import entidades.Provincia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
public class ConsultaProvincias {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("T2AgendaPU");
        EntityManager em = emf.createEntityManager();
        
        Query queryProvincias = em.createNamedQuery("Provincia.findAll");
        
        List<Provincia> listProvincias = queryProvincias.getResultList();
        
        /* Formato abreviado del for para mostrarlas provincias
        No lo mostramos puesto que lo vamos a hacer de la forma tradicional
        
        for(Provincia provincia : listProvincias){
        System.out.println(provincia.getNombre());
        */
        
        /* Formato normal del for para mostrar las provincias */
        for(int i=0;i<listProvincias.size();i++){
            Provincia provincia=listProvincias.get(i);
            System.out.println(provincia.getNombre());
        } // Fin del for
    }
                
}
    
