
package Árboles;


import Nodo.Doctor;
import java.io.*;
import java.lang.*;
import Nodo.NodoSplay;


public class Arbol_Splay {

  int cont;
  public NodoSplay raiz;
  NodoSplay auxp;
  NodoSplay auxh;
  boolean bandera = true;
  
  //Inserta un elemento en un arbol splay
    public NodoSplay Insertar (NodoSplay codl){
	try{
	    if (raiz == null)
	        raiz = new NodoSplay (codl.doc);
            else{
	        auxp = null;
	        auxh = raiz;
	        while (auxh != null){
                    if (codl.codl <= auxh.codl){
		        auxp = auxh;
		        auxh = auxh.Hiz;
		    }
                    else{
		        auxp = auxh;
		        auxh = auxh.Hde;
                    }   
		}
		NodoSplay nuevo = new NodoSplay (codl.doc);
		if (auxp.codl <codl.codl){
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
    
    
  //Constructor
  public Arbol_Splay(){
    raiz = null;
  }
  
  //rotacion zag zag
  public void zagzag(NodoSplay abuelo){
  	try{
            if(cont<2){
                cont++;
	        NodoSplay nuevo = new NodoSplay (abuelo.doc);
	        nuevo.Hiz = abuelo.Hiz;
	        nuevo.Hde = abuelo.Hde;
	        nuevo.Hde = auxp.Hiz;
	        abuelo.Hiz = nuevo;
	        abuelo.Hde = auxp.Hde;
	        abuelo.codl = auxp.codl;
	      
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
                NodoSplay nuevo = new NodoSplay (abuelo.doc);
                nuevo.Hiz = abuelo.Hiz;
                nuevo.Hde = abuelo.Hde;
                abuelo.codl = auxh.codl;

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
  		NodoSplay nuevo = new NodoSplay (abuelo.doc);
  		nuevo.Hiz = abuelo.Hiz;
        	nuevo.Hde = abuelo.Hde;
        	nuevo.Hiz = auxp.Hde;
        	abuelo.Hde = nuevo;
        	abuelo.Hiz = auxp.Hiz;
        	abuelo.codl = auxp.codl;
        	
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
            NodoSplay nuevo = new NodoSplay (abuelo.doc);
            nuevo.Hiz = abuelo.Hiz;
            nuevo.Hde = abuelo.Hde;
            abuelo.codl = auxh.codl;
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
            raiz.Hde = auxh.Hiz;
            auxh.Hiz = raiz;
            raiz = auxh;
            cont=0;
  	}
  	catch(Exception e){
  	}
    } 
  
    //sube el recien insertado a la raiz
    private void Subir (NodoSplay padre, NodoSplay hijo){
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
    private NodoSplay TieneAbuelo (NodoSplay nodo){
        if (nodo == raiz)
            return null;
        else{
            NodoSplay padre = null;
            NodoSplay hijo = raiz;
            while (hijo != nodo){
                if (nodo.codl <= hijo.codl){
                    padre = hijo;
                    hijo = hijo.Hiz;
                }
                else{
                    padre = hijo;
                    hijo = hijo.Hde;
                }
            }
            return padre;
        }
    }
  
    //imprime en inorden el arbol splay
    public void Inorden (NodoSplay root){
  	if(root==null)
            return;
  	else{
            Inorden (root.Hiz);
            System.out.print (root.codl + " ");
            Inorden (root.Hde);
  	}
    }
  
    //elimina un elemento de un arbol splay y coloca su antecesor
    //en la raiz	
    public NodoSplay Eliminar (int codl){
        NodoSplay rai=raiz ;
        if (codl == raiz.codl){
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
                while (hijo.codl != codl){
                    if (codl <= hijo.codl){
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
                Eliminar (raiz.codl);
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
    public NodoSplay Buscar (int codl){
        try{
            if (codl == raiz.codl){
	    	}
	    else{
                NodoSplay padre = null;
                NodoSplay hijo = raiz;
                while ((hijo != null) && (hijo.codl != codl)){
                    if (codl <= hijo.codl){
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
	    }
	}
	catch(Exception e){
        }
        System.out.print(raiz.codl);
	return raiz;
    }
  
    //retorna si es miembro un elemento
    private boolean Miembro (int dat,NodoSplay rai){
  	raiz=rai;
        NodoSplay hijo = raiz;
        while ((hijo != null) && (hijo.codl != dat)){
            if (dat <= hijo.codl){
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
