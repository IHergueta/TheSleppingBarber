	package El_barbero_durmiente;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Barberia{
	
	//este es el numero de sillas que hay en la tienda
	   int nSillas=3;
	   //aqui van a ir los clientes
	   List<Cliente> listaClientes;

	   public Barberia(){
		   
		   //esto es un tipo de lista la cual puedes añadir un dato al final o al principio sin que este completa la lista,es decir, puedes elegeir la posicion que tu quieras
	       listaClientes = new LinkedList<Cliente>();
	       
	   }
	   
	   //creo el metodo cola 
		 public void cola(Cliente cliente){
				   
			 //aqui el cliene entra en la barberia consu nombre y tiempo
			       System.out.println("Cliente : "+cliente.getNombre()+ " ha entrado en la barberia "+cliente.getTiempo());
		
			       //se utiliza el syn para apropiarnos del objeto y poder ponerlo en esta lista
			       synchronized (listaClientes)
			       
			       {
			    	   
			    	   //los clientes no pueden superar el numero de sillas de la tienda
			           if(listaClientes.size() == nSillas)
			        	   
			           {
			        	   
			        	   //si no hay sillas espera
			               System.out.println("No hay sillas libres para que se pueda sentar "+cliente.getNombre());
			               System.out.println("Cliente "+cliente.getNombre()+" Espera...");
			               return ;
			               
			           }
		
			           //el offer pone el cliente al final del la lista de espera gracias al linkedlist
			           ((LinkedList<Cliente>)listaClientes).offer(cliente);
			           System.out.println("Cliente : "+cliente.getNombre()+ " se sienta.");
			            
			           //y el notify despierta 
			           if(listaClientes.size()==1)
			        	   
			        	   listaClientes.notify();
			           
			       }  
			   }

		 //metodo para cortar el pelo
	   public void cortarPelo(){
		   
	       Cliente cliente;
	       System.out.println("Barbero esperando.");
	       
	       //se utiliza el syn para apropiarnos del objeto y poder ponerlo en esta lista
	       synchronized (listaClientes)
	       
	       {

	    	   //mientras que la lista sea igual a cero
	           while(listaClientes.size()==0)
	        	   
	           {
	        	   
	               System.out.println("Barbero esperando a algun cliente");
	               
	               try{
	            	   
	            	   //espera
	            	   listaClientes.wait();
	            	   
	               }
	               
	               catch(InterruptedException e){
	            	   
	                   e.printStackTrace();
	                   
	               }
	           }
	           
	           //si sale del while que mande un cliente al barbero
	           System.out.println("Barbero encontro a un cliente en cola.");
	           //el metodo poll devuelve el elemento en cabeza de la array
	           cliente = (Cliente)((LinkedList<?>)listaClientes).poll();
	           
	       }
	       
	       long duracion=0;
	       try{
	    	   
	           System.out.println("Cortandole el pelo a "+cliente.getNombre());
	           
	           //inicialio una duracion aleatoria
	           duracion = (long)(Math.random()*10);
	           TimeUnit.SECONDS.sleep(duracion);
	           
	       }
	       
	       catch(InterruptedException iex){
	    	   
	           iex.printStackTrace();
	           
	       }
	       
	       System.out.println("Servicio terminado  : "+cliente.getNombre() + " en "+duracion+ " segundos.");
	       
	   }

	  
} 