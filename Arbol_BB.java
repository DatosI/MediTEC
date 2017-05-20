package Árboles;

import java.util.ArrayList;
import java.util.Vector;



   


public class Arbol_BB {
    public String  raiz;
    
    Vector<String> miVector = new Vector<String>();
    Arbol_BB subABizq;
    Arbol_BB subABder;

// Constructor de un arbol vacio
    public Arbol_BB() {
        raiz = "";
        subABizq = null;
        subABder = null;
    }

// constructor de una hoja  
    public Arbol_BB( String raiz ) {
       this.raiz = ( raiz ); 
        subABizq = null;
        subABder = null;
    }
    /*esta función revisa si el char que le llega está vacio o tiene una letra
    resive un boleano
    retorna un boleano indicando si el char esta vacio o no
    restriccion: que el valor que ingrese sea booleano
    */
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
    public void insertar(String  nuevo ) {
        if( esVacio() ) {
            raiz = ( nuevo );
            subABizq = new Arbol_BB();
            subABder = new Arbol_BB();
        } else {
            if (nuevo.compareTo(raiz)<0){
               subABizq.insertar(nuevo);
            }else if (nuevo.compareTo(raiz)>0) {
                subABder.insertar(nuevo);
            }
        }
    }
    /*esta funcion busca el String para seleccionarlo, para luego en usarlo en otros metodos
    recibe el char que se quiere seleccionar
    retorna donde esta ese char para su posterior uso
    restriccion: que exista el char para buscar y que el arbol tenga elementos
    */
    
    public ArrayList<Data> buscar1( String x ,Arbol_BB buscado ) {
        
        
        ArrayList<Data> lista = new ArrayList<Data>();
        int tam= x.length();
        String nombre;
        Data data= new Data();
        
        
        //System.out.println(x.compareTo(buscado.raiz.substring(0,tam)));
        try{
            if (!esVacio()) {
                              
                if( x.compareTo(buscado.raiz.substring(0,tam))==0 ) {
                  
                    data.Altura= buscado.altura();
                    data.nombre=buscado.raiz;
                    lista.add(data );
                    lista.addAll(buscar1(x , buscado.subABder));
                    lista.addAll(buscar1(x, buscado.subABizq));
                    
                    
                  
                } else {
                    buscar1(x , buscado.subABder);
                    buscar1(x, buscado.subABizq);
                    
                }
                
            } //Una excepci�n
            //System.out.println(buscado.raiz);
            System.out.println(lista.get(0).nombre);
            return lista;
        }
        catch (Exception e) {
            
            //System.out.println("no existe");
            
            return lista;
        }
        
    }
    
    
    
    
    public Arbol_BB buscar( String x ) {
        Arbol_BB buscado = null;
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

    public Arbol_BB buscarMax() {
        Arbol_BB arbolActual = this;

        while( !arbolActual.subABder.esVacio() ) {
            arbolActual = arbolActual.subABder;
        }
        //System.out.println(arbolActual.raiz);
        return arbolActual;
    }
    
////////////////////////////////////////////////////////////////////////////////

    public Arbol_BB buscarMin() {
        Arbol_BB arbolActual = this;

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
    
    /*esta función nos ayuda a eliminar un elemento del arbol
    recive el elemento que se desea eliminar
    retorna nada
    restriccion: que sea tipo char, y que tenga ese elemento
    */
     public void eliminar(String a ) {
        Arbol_BB aEliminar = buscar(a);

        if (aEliminar != null) {
            if( aEliminar.esHoja() ) {
                aEliminar.raiz = "";
            } else {
                Arbol_BB  min =  aEliminar.subABder.buscarMin();
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
        Vector<Arbol_BB> cola = new Vector<Arbol_BB>();
        Arbol_BB arbol;

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


class Data{
    public int Altura;
    public int Profundidad;
    public int ruta;
    public String nombre;

    public Data() {
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int Altura) {
        this.Altura = Altura;
    }

    public int getProfundidad() {
        return Profundidad;
    }

    public void setProfundidad(int Profundidad) {
        this.Profundidad = Profundidad;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

   
}

    

