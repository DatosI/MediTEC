package Árboles;


//Árbol Binario de Busqueda.  (int)



public class Arbol_Binario_de_Busqueda {

    private class nodoArbol {
        private Arbol_Binario_de_Busqueda  hijoDer;
        private Arbol_Binario_de_Busqueda  hijoIzq;
        private int dato;
        
        private void nodoArbol(){
            hijoDer = null;
            hijoIzq = null;
            dato = 0;
        }
    }
    
    public nodoArbol raiz;
    
    public void ABB(){
        nodoArbol raiz = new nodoArbol();
    }
    
    public boolean esVacio(){
        return (raiz == null);
    }


//--------------------------Buscar----------------------------------------------

    
    public Arbol_Binario_de_Busqueda  buscar(int a){
        Arbol_Binario_de_Busqueda  arbol1 = null;
        if(!esVacio()){
            if(a == raiz.dato){
                return this;
            }
            else{
                if(a < raiz.dato){
                    arbol1 = raiz.hijoIzq.buscar(a);
                }
                else{
                    arbol1 = raiz.hijoDer.buscar(a);
                }
            }
        }
        return arbol1;
    }

//--------------------------Insertar--------------------------------------------    
    public void insertar (int a){
        if(esVacio()){
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hijoDer = new Arbol_Binario_de_Busqueda ();
            nuevo.hijoIzq = new Arbol_Binario_de_Busqueda ();
            raiz = nuevo;
        }
        else{
            if(a > raiz.dato){
                (raiz.hijoDer).insertar(a);
            }
            if (a < raiz.dato){
                (raiz.hijoIzq).insertar(a);
            }
        }
    }

//--------------------------Buscar_Minimo---------------------------------------   
    public int buscarMin() {
        Arbol_Binario_de_Busqueda  arbolActual = this;
        while( !arbolActual.raiz.hijoIzq.esVacio() ) {
            arbolActual = arbolActual.raiz.hijoIzq;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        System.out.print(devuelvo);
        return devuelvo;
        
    }

    
    
//--------------------------Buscar_Maximo---------------------------------------  
    public int buscarMax() {
        Arbol_Binario_de_Busqueda  arbolActual = this;
        while( !arbolActual.raiz.hijoDer.esVacio() ) {
            arbolActual = arbolActual.raiz.hijoDer;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        System.out.print(devuelvo);
        return devuelvo;
    }

    
    
//--------------------------Comprobar_si_es_hoja--------------------------------  
    public boolean esHoja() {
        boolean hoja = false;
        if( (raiz.hijoIzq).esVacio() && (raiz.hijoDer).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }


//--------------------------Eleminar_Nodo---------------------------------------      
    public void eliminar(int a) {
        Arbol_Binario_de_Busqueda  paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            }
            else {
                if (!paraEliminar.raiz.hijoIzq.esVacio() && !paraEliminar.raiz.hijoDer.esVacio()) {
                    paraEliminar.raiz.dato = paraEliminar.raiz.hijoDer.buscarMin();
                }
                else {
                    if (paraEliminar.raiz.hijoIzq.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.hijoDer.raiz;
                    }
                    else{
                        paraEliminar.raiz = paraEliminar.raiz.hijoIzq.raiz;
                    }
                }
            }
        }
    }
    
    
//--------------------------Obtener_Alruta--------------------------------------      
    public int altura() {
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + Math.max(((raiz.hijoIzq).altura()), ((raiz.hijoDer).altura())));
        }
    }


//--------------------------Recorrer_PreOrden-----------------------------------     
   public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato + ", "  );
            raiz.hijoIzq.preOrder();
            raiz.hijoDer.preOrder();
        }
    }

   
   
   
//--------------------------Recorrer_InOrden------------------------------------
    public void inOrder(){
        if (!esVacio()) {
            raiz.hijoIzq.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.hijoDer.inOrder();
        }
    }

    
    
    
//--------------------------Recorrer_PosOrden----------------------------------- 
    public void posOrder(){
        if (!esVacio()) {
            raiz.hijoDer.posOrder();
            raiz.hijoIzq.posOrder();
            System.out.print( raiz.dato + ", "  );
 
        }
    }  
    
    

//------------------------------------------------------------------------------     
    
    
}






