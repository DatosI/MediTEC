


package Nodo;

import Árboles.Arbol_Splay;




public class ListaDoctores {
    public Arbol_Splay Lista;
	
	
	
	
	public void Insertar(Doctor doc){
            NodoSplay a = new NodoSplay(doc);
	    Lista.Insertar(a);
		
	}
        
        
  
}

