package enums;

public enum TipoDeCliente {
    COMUN,
    JUBILADO,
    EMBARAZADA;

    public static Double sumarTiempoPorTipo(Double tiempo, TipoDeCliente tipo){
        if(tipo==COMUN){
            tiempo*=1.15;
        }
        if(tipo==JUBILADO){
            tiempo*=1.25;
        }
        if(tipo==EMBARAZADA){
            tiempo*=1.2;
        }
        return tiempo;
    }

}
