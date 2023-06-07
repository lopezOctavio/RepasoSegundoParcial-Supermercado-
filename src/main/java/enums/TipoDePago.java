package enums;

public enum TipoDePago {
    EFECTIVO,
    TARJETAsinPROBLEMA,
    TARJETAconPROBLEMA;

    public static Double sumarTiempoPorPago(Double tiempo, TipoDePago tipo){
        if(tipo==EFECTIVO){
            tiempo*=1.0;
        }
        if(tipo==TARJETAsinPROBLEMA){
            tiempo*=1.5;
        }
        if(tipo==TARJETAconPROBLEMA){
            tiempo*=5.0;
        }
        return tiempo;
    }
}
