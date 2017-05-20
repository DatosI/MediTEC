package Árboles;

import java.util.Vector;


public class Arbol_AVL {
    String  raiz;
    
    Vector<String> miVector = new Vector<String>();
    Arbol_AVL  subABizq;
    Arbol_AVL  subABder;
 
    
    
 // Constructor de un arbol vacio   
    public Arbol_AVL () {
        raiz = "";
        subABizq = null;
        subABder = null;
    }
    
    // constructor de una hoja  
    public Arbol_AVL ( String raiz ) {
       this.raiz = ( raiz ); 
       subABizq = null;
       subABder = null;
    }

    
    
 

    private boolean esVacio() {
        boolean vacio = true;

        if ( raiz != ""){
            vacio = false;
        }
        return vacio;
    }
    
    /*esta función inserta una hoja nueva al arbol sea al lado izquierdo o derecho
    resive un boleano y un char
    como salida tiene insertar una hoja al arbol de tipo char
    restricción:que el valor que entre sea tipo char y el booleano
    */
  
  

    public void insertar(String nuevo ) {
	if( esVacio() ) {
            raiz = ( nuevo );
            subABizq = new Arbol_AVL();
            subABder = new Arbol_AVL();
        }
	else if (nuevo.compareTo(raiz)<0){                        //el valor nuevo es menor q la raiz
	    subABizq.insertar(nuevo);
            if(altura(subABizq)-altura(subABder )  == 2){
                if (nuevo.compareTo(subABizq.raiz)<0){           //el valor nuevo es mayor q la raiz del subarbol izquierdo
                    subABizq  =rotarIzq(subABizq );
                }
                else {
                    subABizq.subABizq = rotarDer(subABizq);
		    subABizq= rotarIzq(subABizq);
                }
                
            }
        }
        else if(nuevo.compareTo(raiz) > 0) {                    //el valor nuevo es mayor q la raiz
            subABder.insertar(nuevo);
            if(altura(subABder) - altura(subABizq) == 2){       //el subarbol der es mas alto que el subarbol izquierdo y esta desbalanceado
                    if(nuevo.compareTo(subABder.raiz) > 0){     //el valor nuevo es mayor q la raiz del subABder
                        subABder = rotarDer(subABder);
                    }
                    else {
                        subABder.subABder = rotarIzq(subABder);
                        subABder = rotarDer(subABder);
                    }

            }
        }
       
        
    }
    

    /*esta funcion busca el String para seleccionarlo, para luego en usarlo en otros metodos
    recibe el char que se quiere seleccionar
    retorna donde esta ese char para su posterior uso
    restriccion: que exista el char para buscar y que el arbol tenga elementos
    */
    public Arbol_AVL buscar( String x ) {
        Arbol_AVL buscado = null;
        try{
            if (!esVacio()) {
                if( x.compareTo(raiz)<0 ) {
                    buscado = subABizq.buscar(x);
                } else if ( x.compareTo(raiz)>0 ) {
                    buscado = subABder.buscar(x);
                } else {
                    return this;
                }
            } //Una excepci�n
            //System.out.println(buscado.raiz);
            return buscado;
        }
        catch (Exception e) {
            buscado=null;
            System.out.println("no existe");
            return buscado;
        }
    }
    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    //Rotaciones
    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    public Arbol_AVL rotarIzq(Arbol_AVL n) {
	Arbol_AVL nraiz = n.subABizq;
	n.subABizq = nraiz.subABder;
	nraiz.subABder = n;
	
	return nraiz;
    }

    /**
     * Metodo para rotar a la derecha
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    public Arbol_AVL rotarDer(Arbol_AVL n) {
        Arbol_AVL nraiz = n.subABder;
	n.subABder = nraiz.subABizq;
	nraiz.subABizq = n;
	
	return nraiz;
        
        
    }
	    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    public Arbol_AVL buscarMax() {
        Arbol_AVL arbolActual = this;

        while( !arbolActual.subABder.esVacio() ) {
            arbolActual = arbolActual.subABder;
        }
        //System.out.println(arbolActual.raiz);
        return arbolActual;
    }
    
////////////////////////////////////////////////////////////////////////////////

    public Arbol_AVL buscarMin() {
        Arbol_AVL arbolActual = this;

        while( !arbolActual.subABizq.esVacio() ) {
            arbolActual = arbolActual.subABizq;
        }
        //System.out.println(arbolActual.raiz);
        return arbolActual;
    }
    /*esta funcion nos permite saber si el nodo consultado es hoja o no
    recive un booleano
    retorna un booleano indicando si es hoja o no
    restriccion: que las hojas tengan datos dentro, ya que si son vacias no seria hoja
    */
    private boolean esHoja() {
        boolean hoja = false;

        if( subABizq.esVacio() && subABder.esVacio() ) {
            hoja = true;
        }

        return hoja;
    }
    
    
    
//--------------------------Obtener_Alruta--------------------------------------      
      public int altura() {
        if (esVacio()) {
            return -1;
        }
        
        else {
            
            
            return (1 + Math.max(subABizq.altura(),subABder.altura()));
        }
       
        
    } 
    
      public int altura(Arbol_AVL a) {
        
        if (a.esVacio()) {
           
            return -1;
        }
        
        else {
            return (1 + Math.max(a.subABizq.altura(),a.subABder.altura()));
                 
             }
                       
        
        
    } 
    
//--------------------------Equilibrio------------------------------------------       
     public boolean Balance(){
        if(Math.abs(altura(subABder)-altura(subABizq ))  <2){                   //balanceado
            System.out.print(true);
            return true;            
        }
        else{
            System.out.print(false);
            return false;            
        }     
    }
     
  
//------------------------------------------------------------------------------ 
     
 
     
     
//------------------------------------------------------------------------------      
    /*
     public int profundidad(T dato){
    	Nodo<T> nodo = new Nodo<T>(dato);
    	int profundidad = 0;
    	while(compararDato(nodo.getDato(), this.getRaiz().getDato())!=0){
    		profundidad++;
    		nodo = padre(nodo);
    	}
    	
    	return profundidad;
    }
    */
    
    /*esta función nos ayuda a eliminar un elemento del arbol
    recive el elemento que se desea eliminar
    retorna nada
    restriccion: que sea tipo char, y que tenga ese elemento
    */
     public void eliminar(String a ) {
        Arbol_AVL aEliminar = buscar(a);

        if (aEliminar != null) {
            if( aEliminar.esHoja() ) {
                aEliminar.raiz = "";
            } else {
                Arbol_AVL  min =  aEliminar.subABder.buscarMin();
                aEliminar.raiz = min.raiz;
                min.eliminar(min.raiz);
            }
        }
    }


    public void PreOrden() {
        if( !esVacio() ) {
            System.out.println( raiz );
            subABizq.PreOrden();
            subABder.PreOrden();
        }
    }

    public void InOrden() {
        if( !esVacio() ) {
            subABizq.InOrden();
            System.out.println( raiz );
            subABder.InOrden();
        }
    }

    public void PosOrden() {
        if( !esVacio() ) {
            subABizq.PosOrden();
            subABder.PosOrden();
            System.out.println( raiz );
        }
    }


    public void porNivel() {
        Vector<Arbol_AVL> cola = new Vector<Arbol_AVL>();
        Arbol_AVL arbol;

        cola.add(this);
        while( !cola.isEmpty() ) {
            arbol = cola.elementAt(0);
            cola.remove(0);
            System.out.println( arbol.raiz );
            if ( !arbol.subABizq.esVacio() ) cola.add( arbol.subABizq );
            if (!arbol.subABder.esVacio() ) cola.add( arbol.subABder );
        }
    }
    
    
    
    
    
}

    




   
