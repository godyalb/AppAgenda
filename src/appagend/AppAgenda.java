/*
CREADO POR ALBERTO GODINO BERROCAL
APP AGENDA
*/

package appagend;

import entidades.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ALBERTO GODINO BERROCAL
 */
public class AppAgenda {

    public static void main(String[] args) {
        
        //Conecta con la base de datos
        Map<String, String> emfProperties = new HashMap<>();
        //emfProperties.put("javax.persistence.jdbc.user", "APP");
        //emfProperties.put("javax.persistence.jdbc.password", "usuario");
        emfProperties.put("javax.persistence.jdbc.schema-generation.database.action", "create");
        emfProperties.put("javax.persistence.jdbc.url","jdbc:derby:BDAgenda;create=true");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("T2AgendaPU");
        EntityManager em = emf.createEntityManager();
 
        /* Se puede iniciar una transacción sobre dicho EntityManager con una 
        sentencia como esta: */
        em.getTransaction().begin();
        
        /* Una vez realizadas las operaciones deseadas, se deben confirmar realizando
        su volcado definitivo a la base de datos */
        em.getTransaction().commit();
 
/* Lo comentamos para no crearnos mas "sevilla" */       
        /* Crearemos ahora otra provincia para "Sevilla", utilizando ahora el 
        método constructor sin parámetros. */
//        Provincia provinciaSevilla=new Provincia();
//        provinciaSevilla.setNombre("Sevilla");
        
        /* Ahora, para que ambos objetos se almacenen en la base de datos 
        se deberá iniciar la transacción */
//        em.getTransaction().begin();
//       em.persist(provinciaSevilla);
//        em.getTransaction().commit();
/* Fin del comentario para no añadir más "sevilla" */   

/* Podemos eliminar una provincia con el siguiente código */
/*
        Provincia provinciaId12 = em.find(Provincia.class, 12);
        em.getTransaction().begin();
        if (provinciaId12 != null){
        em.remove(provinciaId12);
        }else{
        System.out.println("No hay ninguna provincia con ID=12");
        }
        em.getTransaction().commit();
*/        
        // Cerramos la conexión con la base de datos
        em.close();
        emf.close();
        try{
            DriverManager.getConnection("jdbc:derby:DB;shutdown=true");
        } catch (SQLException ex){
        }

    }
    
}
