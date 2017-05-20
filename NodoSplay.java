
package Nodo;


public class NodoSplay {
            
        public int codl;
        public Doctor doc;
        public NodoSplay Hiz;
        public NodoSplay Hde;

    public NodoSplay (Doctor doc){
        codl =doc.id;
        this.doc=doc;
        Hiz = null;
        Hde = null;
    }
    
    
 
}
