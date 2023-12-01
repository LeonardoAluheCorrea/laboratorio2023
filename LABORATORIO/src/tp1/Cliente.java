package tp1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cliente {
    public static void main(String[] args) {
        ScheduledExecutorService exeSer= Executors.newScheduledThreadPool(1);
        Server server= new Server();
        Checkeo check1= new CheckTemperatura (server);
        Checkeo check2= new CheckTurbinas(server);
        Checkeo.enlace(check1,check2);
        
        server.setCheck(check1);
            
         

        Runnable task= () -> server.revisarEstado();

        //ejecuta tareas con un delay inicial y cada un periodo de tiempo
        exeSer.scheduleAtFixedRate(task, 3, 10, TimeUnit.SECONDS);

    }
}
