package clases;

import enums.TipoDeCliente;
import enums.TipoDePago;

import java.io.Serializable;

public class Cliente implements Serializable {
    private TipoDeCliente tipoCliente;
    private TipoDePago tipoPago;
    private Integer cantarticulos;

    public Cliente() {
    }

    public Cliente(TipoDeCliente tipoCliente, TipoDePago tipoPago, Integer cantarticulos) {
        this.tipoCliente = tipoCliente;
        this.tipoPago = tipoPago;
        this.cantarticulos = cantarticulos;
    }

    public TipoDeCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoDeCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public TipoDePago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoDePago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getCantarticulos() {
        return cantarticulos;
    }

    public void setCantarticulos(Integer cantarticulos) {
        this.cantarticulos = cantarticulos;
    }

    public Double calcularTiempo(){
        Double tiempo = (double) (cantarticulos * 30);
        tiempo = TipoDePago.sumarTiempoPorPago(tiempo, tipoPago);
        tiempo = TipoDeCliente.sumarTiempoPorTipo(tiempo, tipoCliente);
        return tiempo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipoCliente=" + tipoCliente +
                ", tipoPago=" + tipoPago +
                ", cantarticulos=" + cantarticulos +
                '}';
    }
}
