import clases.Caja;
import clases.Cliente;
import clases.FilaGenerica;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.TipoDeCliente;
import enums.TipoDePago;

import java.io.File;
import java.util.Random;

import excepciones.MasDeTresProblemas;
import org.json.JSONObject;

public class Main {
     public static void main(String[] args) {
         FilaGenerica<Object> fila = new FilaGenerica<>();
         TipoDeCliente[] tipoCliente = TipoDeCliente.values();
         TipoDePago[] metodoDePago = TipoDePago.values();
         Caja[] cajas = new Caja[5];
         Random random = new Random();

         for(Integer i=0;i<30;i++){
             fila.add(new Cliente(tipoCliente[random.nextInt(0, tipoCliente.length)],
                                    metodoDePago[random.nextInt(0, metodoDePago.length)],
                                    random.nextInt(0,50)));
         }

         for (int i=0;i<5;i++){
             cajas[i]=new Caja();
         }

         System.out.println(fila);

         int index = 0;
         Cliente cliente = null;
         while(!fila.vacia()){
             cliente = (Cliente) fila.desencolar();
             cajas[index].add(cliente);
             if(index== (cajas.length)-1){
                 index = 0;
             }
             else{
                 index++;
             }
         }

         File file = new File("archivoCajas.json");
         ObjectMapper mapper = new ObjectMapper();
         try{
             mapper.writerWithDefaultPrettyPrinter().writeValue(file, cajas);

         }catch (Exception e){
             System.out.println("No se pudo escribir el archivo");
         }

         System.out.println(atender(cajas));

        try{
            cajas = mapper.readValue(file, Caja[].class);

        }catch (Exception e){
            e.printStackTrace();
        }

         System.out.println("Si fue leido bien aqui deberia mostrarse el contenido del mismo");
         for (Caja caja: cajas){
             System.out.println(caja.toString());
         }
    }

    public static String atender(Caja[] cajas){
        String resultados="";
        int i=0;
        for(Caja caja: cajas){
            try{
                if (caja.getCantDeProblemas()>3){
                    throw new MasDeTresProblemas();
                }
                Double tiempoTotalDeLaCaja=0.0;
                for (Double tiempo: caja.getTiempos()){
                    tiempoTotalDeLaCaja+=tiempo;
                }
                Double cantidad=(double)caja.getTiempos().stream().count();
                resultados+="La caja "+i+" tiene un tiempo promedio de "+String.format("%.2f",tiempoTotalDeLaCaja/cantidad)+" segundos\n";
                caja.vaciarCajas();

            } catch (MasDeTresProblemas e) {
                System.out.println("La caja "+ i+" supero los tres problemas");
            }finally {
                i++;
            }
        }

        return resultados;
    }
}
