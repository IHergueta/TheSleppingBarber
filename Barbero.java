package El_barbero_durmiente;

public class Barbero implements Runnable{
	
	   Barberia tienda;

	   public Barbero(Barberia tienda){
		   
	       this.tienda = tienda;
	       
	   }
	   
	   //cuando se cree un hilo de barbero
	   public void run(){
		   
	       try{
	    	   
	    	   //espera
	           Thread.sleep(10000);
	           
	       }
	       
	       catch(InterruptedException e){
	    	   
	           e.printStackTrace();
	           
	       }
	       
	       System.out.println("EL barbero esta listo..");
	       
	       while(true){
	    	   
	    	   //empieza a cortar el pelo
	    	   tienda.cortarPelo();
	    	   
	       }
	   }
	}



