package clases;

import java.util.LinkedList;
import java.util.Queue;

public class FilaGenerica <T>{
    private Queue<T> fila_espera = new LinkedList<>();

    public void add(T nuevo){
        fila_espera.add(nuevo);
    }

    public T desencolar(){
        return fila_espera.poll();
    }

    @Override
    public String toString() {
        return "FilaGenerica{" +
                "fila_espera=" + fila_espera +
                '}';
    }

    public Boolean vacia(){
        if(fila_espera.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
