package El_barbero_durmiente;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

   public static void main(String a[])
   {
	   //creo los objetos
       Barberia tienda = new Barberia();

       Barbero barbero = new Barbero(tienda);
       
       GeneradorClientes clientes = new GeneradorClientes(tienda);

       //creo los hilos
       Thread barbero_hilo = new Thread(barbero);
       Thread clientes_hilo = new Thread(clientes);
       
       //los inicio llamando al metodo run
       clientes_hilo.start();
       barbero_hilo.start();
   }




}
