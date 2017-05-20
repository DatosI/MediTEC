/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmrmk_000
 */
public class Lista_doctores {
  int cont;
  public NodoSplay raiz;
  NodoSplay auxp;
  NodoSplay auxh;
  boolean bandera = true;
  
    //Inserta un elemento en un arbol splay
    public NodoSplay Insertar (String nombre){  
        try{
	if (raiz == null)
	    raiz = new NodoSplay (nombre);
	else{
	    auxp = null;
	    auxh = raiz;
	    while (auxh != null){
	        if  (auxh.nombre.compareTo(nombre)<=0){          ///(nombre <= auxh.nombre){
                    auxp = auxh;
	            auxh = auxh.Hiz;
	        }
	        else{
                    auxp = auxh;
	            auxh = auxh.Hde;
	        }
	    }
	    NodoSplay nuevo = new NodoSplay (nombre);   
	    if(nombre .compareTo(auxp.nombre)<0){  ///   (auxp.nombre < nombre){    //
	        auxp.Hde = nuevo;
	        Subir (auxp, nuevo);
	    }
	    else{
	        auxp.Hiz = nuevo;
	        Subir (auxp, nuevo);
	    }
	}
        }
	    catch(Exception e){
  	}
	    
	return raiz;
    }
  
    //Contructor
    public Lista_doctores(){
        raiz = null;
    }
    
    private boolean esVacio() {
        boolean vacio = true;

        if ( raiz != null){
            vacio = false;
        }
        return vacio;
    }
  
    //rotacion zag zag
    public void zagzag(NodoSplay abuelo){
        try{
  	if(cont<2){		
            cont++;
	    NodoSplay nuevo = new NodoSplay (abuelo.nombre);
	    nuevo.Hiz = abuelo.Hiz;
	    nuevo.Hde = abuelo.Hde;
	    nuevo.Hde = auxp.Hiz;
	    abuelo.Hiz = nuevo;
	    abuelo.Hde = auxp.Hde;
	    
	    
	    if (abuelo == raiz)
	      	bandera = false;
	        auxp = abuelo;
	    }
            else{	
  		cont=0;
            }
        }
  	catch(Exception e){
  	}
    }
  
    //rotacion zag zig
    public void zagzig(NodoSplay abuelo){
        try{
  	if(cont==1 || cont ==2)
            cont=0;
            NodoSplay nuevo = new NodoSplay (abuelo.nombre);
            nuevo.Hiz = abuelo.Hiz;
            nuevo.Hde = abuelo.Hde;
            abuelo.nombre = auxh.nombre;
	    
            nuevo.Hde = auxh.Hiz;
            abuelo.Hiz = nuevo;
            auxp.Hiz = auxh.Hde;
            abuelo.Hde = auxp;
            if (abuelo == raiz){
        	raiz = abuelo;
        	bandera = false;
            }
            auxh = abuelo;
            auxp = TieneAbuelo (auxh);
            }
  	catch(Exception e){
  	}
  	
    }
  
    //rotacion zig zig
    public void zigzig(NodoSplay abuelo){
        try{
  	if(cont<2){
            cont++;
            NodoSplay nuevo = new NodoSplay (abuelo.nombre);
            nuevo.Hiz = abuelo.Hiz;
            nuevo.Hde = abuelo.Hde;
            nuevo.Hiz = auxp.Hde;
            abuelo.Hde = nuevo;
            abuelo.Hiz = auxp.Hiz;
           
            
            if (abuelo == raiz)
          	bandera = false;
                auxp = abuelo;
            }
            else{
            	cont=0;
            }	
        }
  	catch(Exception e){
  	}
 
    }
  
    //rotacion zig zag
    public void zigzag(NodoSplay abuelo){
        try{
  	if(cont==1 || cont ==2)
            cont=0;
            NodoSplay nuevo = new NodoSplay (abuelo.nombre);
            nuevo.Hiz = abuelo.Hiz;
            nuevo.Hde = abuelo.Hde;
            
            nuevo.Hiz = auxh.Hde;
            abuelo.Hde = nuevo;
            auxp.Hde = auxh.Hiz;
            abuelo.Hiz = auxp;
            if (abuelo == raiz){
        	raiz = abuelo;
        	bandera = false;
            }
            auxh = abuelo;
            auxp = TieneAbuelo (auxh);
  	}
  	catch(Exception e){

  	}
    }
  
    //rotacion zig
    public void zig(){
        try{
  	if(cont==2)
            raiz.Hiz = auxh.Hde;
            auxh.Hde = raiz;
            raiz = auxh;
            cont=0;
        }
  	catch(Exception e){

  	}
    }
  
    //rotacion zag
    public void zag(){
         try{
  	if(cont==2)	
            raiz.Hde = auxh.Hiz;
            auxh.Hiz = raiz;
            raiz = auxh;
            cont=0;	
        }
  	catch(Exception e){

  	}    
    }
  
    //sube el recien insertado a la raiz
    public void Subir (NodoSplay padre, NodoSplay hijo){
  	bandera=true;
  	auxp=padre;
  	auxh=hijo;
        while ((bandera == true) && (TieneAbuelo (auxp) != null)){
            NodoSplay abuelo = TieneAbuelo (auxp);
            //zag zag
            if ((abuelo.Hde == auxp) && (auxp.Hde == auxh)){
                zagzag(abuelo);
            }
            else{
            //zag zig
                if ((abuelo.Hde == auxp) && (auxp.Hiz == auxh)){
                    zagzig(abuelo);
                }
                else{
          	//zig zig
                    if ((abuelo.Hiz == auxp) && (auxp.Hiz == auxh)){
                        zigzig(abuelo);
                    }
            //zig zag
            else{
              zigzag(abuelo);
            }
          }
        }
      }
      if (auxh != raiz){
      	//zag
        if (raiz.Hde == auxh){
          zag();
        }
        //zig
        else{
          zig();
        }
      }
  }
  
  //retorna el abuelo de un nieto  
  public NodoSplay TieneAbuelo (NodoSplay nodo){
    if (nodo == raiz)
      return null;
    else{
      NodoSplay padre = null;
      NodoSplay hijo = raiz;
      
      while (hijo.nombre != nodo.nombre){
        if   (hijo.nombre .compareTo(nodo.nombre)<=0  ){               ////////////////////////////////(nodo.nombre <= hijo.nombre){  ///
          padre = hijo;
          hijo = hijo.Hiz;
          //System.out.print(hijo.nombre+"W");
          //System.out.print(nodo.nombre+"Y");
        }
        else{
          padre = hijo;
          hijo = hijo.Hde;
          //System.out.print(hijo.nombre+"S");
         // System.out.print(nodo.nombre+"A");
        }
      //  System.out.print(hijo.nombre+"Q");
       // System.out.print(nodo.nombre+"L");
        
        
      }
      
       // System.out.print("T");
       // System.out.print(padre.nombre +"T");
        return padre;
        
     
  }
  }
  
  //imprime en inorden el arbol splay
  public void Inorden (NodoSplay root){
        if( !esVacio() ) {
            Inorden (raiz.Hiz);
            System.out.print (raiz.nombre);
            Inorden (raiz.Hde);
        }
  }
  public void PreOrden(NodoSplay root) {
        if( !esVacio() ) {
            System.out.print (raiz.nombre);
            PreOrden (root.Hiz);
            PreOrden (root.Hde);
            
        }
    }
  
  //elimina un elemento de un arbol splay y coloca su antecesor
  //en la raiz	
  public NodoSplay Eliminar (String nombre){
      NodoSplay rai = raiz;
    if (nombre == raiz.nombre){
      NodoSplay borrado = raiz;
      if ((raiz.Hiz == null) && (raiz.Hde == null)){
        raiz = null;
        return borrado;
      }
      else{
        if ((raiz.Hiz != null) && (raiz.Hde != null)){
          NodoSplay aux = raiz;
          raiz = MayordeMenores (raiz);
          raiz.Hiz = aux.Hiz;
          raiz.Hde = aux.Hde;
          return borrado;
        }
        else{
          if (raiz.Hde != null){
            raiz = raiz.Hde;
            return borrado;
          }
          else{
            raiz = raiz.Hiz;
            return borrado;
          }
        }
      }
    }
    else{
      try{
      NodoSplay padre = null;
      NodoSplay hijo = raiz;
      while (hijo.nombre != nombre){
        if  (hijo.nombre .compareTo(nombre)<=0  ){    //(nombre <= hijo.nombre){///
          padre = hijo;
          hijo = hijo.Hiz;
        }
        else{
          padre = hijo;
          hijo = hijo.Hde;
        }
      }
      Subir (padre, hijo);
      rai = raiz;
      Eliminar (raiz.nombre);
      return rai;
      }
  	catch(Exception e){
            return rai;

  	}   
    }
  }
  
  //buscar el mayor de los menores
  public NodoSplay MayordeMenores (NodoSplay nodo){
    NodoSplay padre = nodo;
    NodoSplay aux = nodo.Hiz;
    while (aux.Hde != null){
      padre = aux;
      aux = aux.Hde;
    }
    padre.Hde = aux.Hiz;
    return aux;
  }
  
  //buscar un elemento y lo sube a la raiz
  public NodoSplay Buscar (String nombre){
  	
    try{
	    if (nombre == raiz.nombre){
	    	
	 	}
	    else{
	      NodoSplay padre = null;
	      NodoSplay hijo = raiz;
	      
	      while ((hijo != null) && (hijo.nombre != nombre)){
	        if (hijo.nombre .compareTo(nombre)<=0  ){         //((nombre <= hijo.nombre){   //
	          padre = hijo;
	          hijo = hijo.Hiz;
	        }
	        else{
	          padre = hijo;
	          hijo = hijo.Hde;
	        }
	      }
	      if (hijo == null){
	        NodoSplay aux = TieneAbuelo (padre);
	        if (padre != raiz)
	          Subir (aux, padre);
	       
	      }
	      else{
	        Subir (padre, hijo);
	        
	      }
	    } }
	 catch(Exception e){
	 	
	 }
	 return raiz;
   
  }
  
  //retorna si es miembro un elemento
  public boolean Miembro (String nombre,NodoSplay rai){
  	raiz=rai;
    NodoSplay hijo = raiz;
    while ((hijo != null) && (hijo.nombre != nombre)){
      if (hijo.nombre .compareTo(nombre)<=0  ){      // (nombre <= hijo.nombre){ 
        hijo = hijo.Hiz;
      }
      else{
        hijo = hijo.Hde;
      }
    }
    if (hijo == null)
      return false;
    else
      return true;
  }
}

//Nodo splay
class NodoSplay{
    String nombre;
    NodoSplay Hiz;
    NodoSplay Hde;

    public NodoSplay (String dat){
        nombre = dat;
        Hiz = null;
        Hde = null;
    }  
}
