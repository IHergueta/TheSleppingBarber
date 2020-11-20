package El_barbero_durmiente;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GeneradorClientes implements Runnable{
	
   Barberia tienda;

   public GeneradorClientes(Barberia tienda){
	   
       this.tienda = tienda;
   }

   //cuando se cree un hilo de generadorclientea
   public void run()
   {
       while(true)
       {
    	   //creo el cliente
           Cliente cliente = new Cliente(tienda);
           //le meto la variable del tiempo en el que entra en el momento justo
           cliente.setTiempo(new Date());
           //creo u nnuevo hilo de cliente
           Thread elcliente = new Thread(cliente);
           //le meto el nombre al cliente gracias al id del hilo
           cliente.setNombre("Hilo "+elcliente.getId());
           //llamo al metodo run
           elcliente.start();

           try
           {
        	   //que se espere un tiempo aleatorio
               TimeUnit.SECONDS.sleep((long)(Math.random()*10));
           }
           catch(InterruptedException iex)
           {
               iex.printStackTrace();
           }
       }
   }
}

