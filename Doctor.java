package Nodo;

import Árboles.Arbol_BB;
import Árboles.Arbol_Splay;



public class Doctor {
    public String nombre;
    public int id;
    Arbol_BB listacitas;
    Arbol_Splay doctor;
	
	
	
	
	
    public Doctor(int id, String nombre) {
        super();
	this.id=id;
	this.nombre = nombre;
	}
	
	
        public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arbol_BB getListacitas() {
		return listacitas;
	}
	public void setListacitas(Arbol_BB listacitas) {
		this.listacitas = listacitas;
	}
	
	
	
	
	

}
    

