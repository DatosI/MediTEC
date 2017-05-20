package estructurasdedatos;

import java.util.Random;

public class NodoCaso_clinico {
	
		String cliente;
	    int ID;
	    String sintomas;
	    Object medicamentos;
	    Object Examenes;
	    
	    public main Casos_Clinicos(String data){
	        String cliente = data;
	        Random num = new Random();
	        int ID= num.nextInt();
	    }
	    public int getID(){
	        return this.ID;
	    }
	    public String getCliente(){
	        return this.cliente;
	    }
	    public void add_medicamentos(String Nombre, int Costo) {
	        Lista_Medicinas nuevo = new Lista_Medicinas(Nombre, Costo);
	        this.insertar(nuevo.getID());
	    }
	    public void add_sintomas(String data){
	        System.out.println(data);
	    }

}
