package clases;

import enums.TipoDePago;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Caja implements Serializable {
    private Queue<Cliente> clientesEnCaja;
    private ArrayList<Double> tiempos;
    private int cantDeProblemas;



    public Caja() {
        this.clientesEnCaja =new LinkedList<>();
        this.tiempos = new ArrayList<>();
        this.cantDeProblemas = 0;
    }

    public Queue<Cliente> getClientesEnCaja() {
        return clientesEnCaja;
    }

    public void setClientesEnCaja(Queue<Cliente> clientesEnCaja) {
        this.clientesEnCaja = clientesEnCaja;
    }

    public ArrayList<Double> getTiempos() {
        return tiempos;
    }

    public void setTiempos(ArrayList<Double> tiempos) {
        this.tiempos = tiempos;
    }

    public int getCantDeProblemas() {
        return cantDeProblemas;
    }

    public void setCantDeProblemas(int cantDeProblemas) {
        this.cantDeProblemas = cantDeProblemas;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "clientesEnCaja=" + clientesEnCaja +
                ", tiempos=" + tiempos +
                ", cantDeProblemas=" + cantDeProblemas +
                '}';
    }

    public void vaciarCajas(){
        this.clientesEnCaja.clear();
        this.tiempos.clear();
        this.cantDeProblemas=0;
    }

    public void add(Cliente nuevo){
        if(clientesEnCaja.isEmpty()){
            clientesEnCaja.add(nuevo);
            tiempos.add(nuevo.calcularTiempo());
        }else{
            clientesEnCaja.add(nuevo);
            tiempos.add(nuevo.calcularTiempo()+tiempos.get(tiempos.size()-1));
        }
        if(nuevo.getTipoPago()== TipoDePago.TARJETAconPROBLEMA){
            this.cantDeProblemas++;
        }
    }

    public Cliente salirDeCaja(){
        return clientesEnCaja.poll();
    }

}
