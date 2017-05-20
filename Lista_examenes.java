package estructurasdedatos;

public class Lista_examenes{
	public class nodoMedEx {
        private Lista_examenes  hijoDer;
        private Lista_examenes  hijoIzq;
        int costo;
        String Nombre;
        
        public nodoMedEx(String string, int i) {
        	hijoDer = null;
            hijoIzq = null;
            costo = i;
            Nombre=string;
		}
        public void mostrar(){
        	System.out.println(this.Nombre + this.costo);
        }

    }
    
    public nodoMedEx raiz;
    
    public void ABB(){
        nodoMedEx raiz = new nodoMedEx(null, 0);
    }
    
    public boolean esVacio(){
        return (raiz == null);
    }
  //--------------------------Insertar--------------------------------------------    
    public void insertar (String string, int a){
        if(esVacio()){
            nodoMedEx nuevo = new nodoMedEx(string, a);
            nuevo.Nombre=string;
            nuevo.costo = a;
            nuevo.hijoDer = new Lista_examenes ();
            nuevo.hijoIzq = new Lista_examenes ();
            raiz = nuevo;
        }
        else{
            if(a > raiz.costo){
                (raiz.hijoDer).insertar(string, a);
            }
            if (a < raiz.costo){
                (raiz.hijoIzq).insertar(string, a);
            }
        }
    }
    //-------------------------------Busca----------------------
    public Lista_examenes buscar(int a){
        Lista_examenes  arbol1 = null;
        if(!esVacio()){
            if(a == raiz.costo){
                return this;
            }
            else{
                if(a < raiz.costo){
                    arbol1 = raiz.hijoIzq.buscar(a);
                }
                else{
                    arbol1 = raiz.hijoDer.buscar(a);
                }
            }
        }
        return arbol1;
    }
    //------------------Nodo-Hoja?-----------------------------
    public boolean esHoja() {
        boolean hoja = false;
        if( (raiz.hijoIzq).esVacio() && (raiz.hijoDer).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
    //-------------------------Buscar MIn----------------------
    public int buscarMin() {
        Lista_examenes  arbolActual = this;
        while( !arbolActual.raiz.hijoIzq.esVacio() ) {
            arbolActual = arbolActual.raiz.hijoIzq;
        }
        int devuelvo= arbolActual.raiz.costo;
        arbolActual.raiz=null;
        System.out.print(devuelvo);
        return devuelvo;
        
    }
  //--------------------------Eleminar_Nodo---------------------------------------      
    public void eliminar(int a) {
        Lista_examenes paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            }
            else {
                if (!paraEliminar.raiz.hijoIzq.esVacio() && !paraEliminar.raiz.hijoDer.esVacio()) {
                    paraEliminar.raiz.costo = paraEliminar.raiz.hijoDer.buscarMin();
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
  //--------------------------Recorrer_InOrden------------------------------------
    public void inOrder(){
        if (!esVacio()) {
            raiz.hijoIzq.inOrder();
            System.out.print( raiz.mostrar() + ", "  );
            raiz.hijoDer.inOrder();
        }
    }

}
