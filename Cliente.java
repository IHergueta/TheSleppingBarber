package El_barbero_durmiente;

import java.util.Date;

public class Cliente implements Runnable{
	
	   String nombre;
	   Date tiempo;

	   Barberia tienda;

	   public Cliente(Barberia tienda)
	   {
	       this.tienda = tienda;
	   }

	   public String getNombre() {
	       return nombre;
	   }

	   public Date getTiempo() {
	       return tiempo;
	   }

	   public void setNombre(String nombre) {
	       this.nombre = nombre;
	   }

	   public void setTiempo(Date tiempo) {
	       this.tiempo = tiempo;
	   }

	   public void run()
	   {
		   //cuando se cree un hilo de cliente
	       aPelar();
	   }
	   
	   //se utiliza el syn para apropiarnos del objeto y poder ponerlo en esta lista
	   private synchronized void aPelar()
	   {
		   tienda.cola(this);
	   }
	}
