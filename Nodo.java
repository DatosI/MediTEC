package Nodo;





public class Nodo {
    private int dato;
    private Nodo Next;
    private Nodo Previous;

    public Nodo() {
        this.dato = dato;
        this.Next = Next;
        this.Previous = Previous;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return Next;
    }

    public void setNext(Nodo Next) {
        this.Next = Next;
    }

    public Nodo getPrevious() {
        return Previous;
    }

    public void setPrevious(Nodo Previous) {
        this.Previous = Previous;
    }
 
}

