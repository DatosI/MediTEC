
package Árboles;




import java.io.*;


//Arbol AVl
public class ArbolAVL{
    public NodoAVL nodo;
    public boolean Hh;
	        
        
//Inserta un elemento en el arbol
    public  void Insercion (int valor){
        if ((!Miembro (valor,nodo))){
            NodoAVL info = new NodoAVL(valor);          //crea un nuevo nodo con el nuevo valor
            nodo=InsertarBalanceado(nodo,info);
        }
        else
            System.out.println("Error, valor repetido");
        }
        
//Auxiliar de InsercinNodo
    NodoAVL InsertarBalanceado(NodoAVL R, NodoAVL Nodo){
        NodoAVL N1;
	NodoAVL info = Nodo;
            if (ArbolVacio(R)){
                R= info;
		Hh=true;
            }
            else
		if (Nodo.valor < R.valor){
                    R.Izquierdo=InsertarBalanceado(R.Izquierdo,Nodo);
                    if (Hh)
			switch(R.Factbalance){
                            case 1:{
				R.Factbalance= 0;
				Hh=false;
                            }	
                            break;
                            case 0:
                            R.Factbalance= -1; 
                            break;
//se reestructura ya que pasaria a valer-2 y se desequilibra a la izq
                            case -1:{
                                N1=R.Izquierdo;
				if (N1.Factbalance== -1){    
                                    R = RotacionIzquierdaIzquierda(R,N1);
				}
				else{			
                                    R = RotacionIzquierdaDerecha(R,N1);
                            	}
                                Hh = false;
                            }
                            break;
			}		
		}
		else{	
                    if (Nodo.valor > R.valor){
			R.Derecho=InsertarBalanceado(R.Derecho, Nodo);
			if (Hh)
                            switch(R.Factbalance){
				case -1:
				R.Factbalance=0;
				Hh=false;	
				break;
				case 0:
                                R.Factbalance=1; 
				break;
	//se reestructura ya que pasaria a valer-2 y se desequilibra a la izq
				case 1:{
                                    N1=R.Derecho;
                                    if (N1.Factbalance==1){					
                                        R = RotacionDerechaDerecha(R,N1);
                                    }
                                    else{
                                        R = RotacionDerechaIzquierda(R,N1);
                                    }
                                    Hh = false;
                                }
				break;
                            }	
				
                    }
                    else{
			System.out.println("Error: No se pueden numeros iguales");
			Hh = false;
                    }
		}
    return R;	
    }
    
    
//retorna si esta vacio
    public boolean ArbolVacio(NodoAVL R){
	return (R == null);
    }


//rota a la derecha
    NodoAVL RotacionDerechaDerecha(NodoAVL N, NodoAVL N1){
	N.Derecho = N1.Izquierdo;
	N1.Izquierdo = N;
	if (N1.Factbalance==1) {
            N.Factbalance=0;
            N1.Factbalance=0;
	}
	else{
            N.Factbalance = 1;
            N1.Factbalance = -1;
	}
            N= N1;
            return N;
    }
	
    NodoAVL RotacionDerechaIzquierda(NodoAVL N, NodoAVL N1){
        NodoAVL N2;
	N2 = N1.Izquierdo;
	N.Derecho = N2.Izquierdo;
	N2.Izquierdo=N;
	N1.Izquierdo=N2.Derecho;
	N2.Derecho=N1;
	if (N2.Factbalance==1){
            N.Factbalance=-1;
	}
	else{
            N.Factbalance=0;
	}
	if (N2.Factbalance==-1)
            N1.Factbalance=1;
	else
            N1.Factbalance=0;
            N2.Factbalance=0;
            N=N2;
        return N;
    }
	
    NodoAVL RotacionIzquierdaIzquierda(NodoAVL N, NodoAVL N1){
	N.Izquierdo = N1.Derecho;
	N1.Derecho = N;
	if (N1.Factbalance==-1){
            N.Factbalance=0;
            N1.Factbalance=0;
	}
	else{
            N.Factbalance=-1;
            N1.Factbalance=1;
	}
	N=N1;
	return N;
    }
	
    NodoAVL RotacionIzquierdaDerecha(NodoAVL N, NodoAVL N1){
	NodoAVL N2;
    	N2=N1.Derecho;
	N.Izquierdo=N2.Derecho;
	N2.Derecho=N;
	N1.Derecho=N2.Izquierdo;
	N2.Izquierdo=N1;
	if (N2.Factbalance==1)
            N1.Factbalance=-1;
	else
            N1.Factbalance=0;
	if (N2.Factbalance==-1)
            N.Factbalance=1;
        else
            N.Factbalance=0;
            N2.Factbalance=0;
            N=N2;
	return N;
    }


//Para verificar si el valor esta
    private boolean Miembro(int valor, NodoAVL R){
	NodoAVL Aux = R;
	boolean miembro = false;
	while (Aux != null){
            if (valor==Aux.valor){
		miembro = true;
		Aux = null;
            }
            else{
		if (valor>Aux.valor)
                    Aux = Aux.Derecho;
		else{
                    Aux = Aux.Izquierdo;
                    if (Aux == null)
			miembro = false;
		}
            }
	}
	return miembro;
    }
    
    
// funcion que nusca el nodo deseado    
    public NodoAVL Buscar(int valor){
        NodoAVL Aux =nodo;
        NodoAVL Aux2 =nodo;
        if ((Miembro (valor,nodo))){
            while (Aux != null){
                if (valor==Aux.valor){
                    Aux2=Aux;
                    Aux=null;
                }
                else{
                    if (valor>Aux.valor)
                         Aux = Aux.Derecho;
                    else{
                        Aux = Aux.Izquierdo;
                        if (Aux == null)
                            Aux2= null;
                    }
                }
            }
            
        }
        else{
            System.out.println("no existe");
            return Aux2=null;
        }
        System.out.println(Aux2.valor);
        return Aux2;
        
    }

    
    
   //busca la cantidad de nodos de un arbol avl
    int CantidadNodosAVL(NodoAVL A){
	int cont = 0;
	if (A == null) 
            cont = cont;
	else{
            cont = cont + 1 + CantidadNodosAVL(A.Izquierdo) + CantidadNodosAVL(A.Derecho);
	}
	return cont;
    }

    //altura	
    public int Altura(NodoAVL raiz){
	if (raiz == null)
        	return 0;
	else
            return	1 + Math.max(Altura(raiz.Izquierdo), Altura(raiz.Derecho));
    }

    //Despliega la informacion en Postorden
    public void PostOrdenAVL (NodoAVL Nodo){
	if (Nodo == null)
            return;
	
        else{
            PostOrdenAVL (Nodo.Izquierdo);
         
            PostOrdenAVL (Nodo.Derecho);
               System.out.println(Nodo.valor);
	}
    }

    
//Despliega la informacion en Inorden
    public void InordenAVL (NodoAVL Nodo){
        if (Nodo == null)
            return;
	else{
            InordenAVL (Nodo.Izquierdo);
            System.out.println(Nodo.valor);
            InordenAVL (Nodo.Derecho);
	}
    }
}

// Nodo de un AVL
class NodoAVL{
	public int valor;
	//public String Nombre;
	int Factbalance;
	NodoAVL Derecho, Izquierdo;
	NodoAVL (int cod){
		valor = cod;
		//Nombre= Nom;
		
		Factbalance = 0;
		NodoAVL Derecho=null;
		NodoAVL Izquierdo = null;
	}
}