package co.edu.unicauca.cor.app;


import co.edu.unicauca.cor.domain.Claim;
import co.edu.unicauca.cor.domain.ClaimManager;
import co.edu.unicauca.cor.domain.TypeEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michel Andrea Vallejo, Mannuel Fernando Granoble 
 */
public class prueba {

    /*
     *   Tipo                Atendido por 
     *  BASIC           mariaortega@gmail.com
     *  DELIVERY        oscarsanchez@gmail.com
     *  HIGH            kate@gmail.com
     *  UNCLASSIFIED    mfgranoble@gmail.com
     */
    
    @Test
    public void testLevelOne() {
        System.out.println("Claim Level One");
        
        ClaimManager manager = new ClaimManager();
         manager.createAthentionFlow();
         
         Claim claim = new Claim(1, "Tiempo de entrega", "¿Cual es el promedio de entrega de mi domicilio?", TypeEnum.BASIC);
         //La solicitud fue atendida 
         assertEquals(manager.getLevelOne().attend(claim),true);
         assertEquals(claim.isAttended(), true);
         
         

    }
    
    public void testLevelTwo() {
        System.out.println("Claim Level Two");
        
        ClaimManager manager = new ClaimManager();
         manager.createAthentionFlow();
         
         Claim claim = new Claim(2, "Cobro exajerado del domicilio", "El mensajero me cobró mucho por el domicilio", TypeEnum.DELIVERY);
         //La solicitud fue atendida 
         assertEquals(manager.getLevelOne().attend(claim),true);
         assertEquals(manager.getLevelTwo().attend(claim),true);
         assertEquals(manager.getLevelThree().attend(claim),false);
         assertEquals(claim.isAttended(), true);
       
    }
    
    public void testLevelThree() {
        System.out.println("Claim Level Three");
        
        ClaimManager manager = new ClaimManager();
         manager.createAthentionFlow();
         
         Claim claim = new Claim(3, "Calidad del producto", "La comida del restaurante popayan casero estaba fria", TypeEnum.HIGH);
         //La solicitud fue atendida 
         assertEquals(manager.getLevelOne().attend(claim),true);
         assertEquals(manager.getLevelTwo().attend(claim),true);
         assertEquals(manager.getLevelThree().attend(claim),true);
         assertEquals(manager.getLevelFour().attend(claim),false);
         assertEquals(claim.isAttended(), true);
       
    }
    
    public void testLevelFour() {
        System.out.println("Claim Level Four");
        
        ClaimManager manager = new ClaimManager();
         manager.createAthentionFlow();
         
         Claim claim = new Claim(4, "Producto equivocado", "Me enviaron el pedido que no era", TypeEnum.UNCLASSIFIED);
         //La solicitud fue atendida
         assertEquals(manager.getLevelOne().attend(claim),true);
         assertEquals(manager.getLevelTwo().attend(claim),true);
         assertEquals(manager.getLevelThree().attend(claim),true);
         assertEquals(manager.getLevelFour().attend(claim),true);
         assertEquals(claim.isAttended(), true);
       
    }
    
    public void testError() {
        System.out.println("Claim no atentida");
        
        ClaimManager manager = new ClaimManager();
         manager.createAthentionFlow();
         
         Claim claim = new Claim(5, "No llego el producto", "Ya paso la fecha maxima de entrega del pedido y todavia no llega ", TypeEnum.NONE);
        
         assertEquals(manager.getLevelOne().attend(claim),false);
         assertEquals(manager.getLevelTwo().attend(claim),false);
         assertEquals(manager.getLevelThree().attend(claim),false);
         assertEquals(manager.getLevelFour().attend(claim),false);
         assertEquals(claim.isAttended(), false);
       
    }

}
