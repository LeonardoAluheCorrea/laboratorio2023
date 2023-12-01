/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

import java.util.concurrent.Executor;
/**
 *
 * @author Leo
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Server {
    private final boolean[] turbina = new boolean[10];
    private int temperatura;
    private boolean presion, oxigeno, voltios;

    private Checkeo check;
    private ScheduledExecutorService scheduler;

    private Runnable turbinaTask= () -> this.normalizarTurbinas(); 
    private Runnable presionTask= () -> this.regularPresion(); 
    private Runnable temperaturaTask= () -> this.regularTemperatura(); 
    private Runnable oxigenoTask= () -> this.regularOxigeno(); 
    private Runnable voltiosTask= () -> this.regularVoltios(); 

    private Runnable protocoloTask= () -> this.protocoloDeAccion();

    public Server(Checkeo check) {
        this.check = check;
        this.check.checkProximo();
        //encargado de manejar 
        scheduler= Executors.newScheduledThreadPool(4);
        
        Thread directorPlanta= new Thread(this.protocoloTask);
        directorPlanta.run();
    }

    public boolean isPresion() {
        return presion;
    }

    public boolean isOxigeno() {
        return oxigeno;
    }

    public boolean isVoltios() {
        return voltios;
    }
    public Server(){
        scheduler= Executors.newScheduledThreadPool(4);
        
        Thread directorPlanta= new Thread(this.protocoloTask);
        directorPlanta.run();
    }
    
    
    public boolean getTurbina(int i) {
        return turbina[i];
    }

    public int getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(int t){
        temperatura = t;
    }
    
    public void setTurbina(int i){
        turbina[i] = true;
    }
    
    //El servidor recibe una notificacion de planificador y comienza la cadena
    public boolean revisarEstado(){
        boolean exito = true;
        if (check.check()){
            System.out.println("Todo esta en buen estado");
        }
        else{
            System.out.println("Hay algun problema, enviar al tecnico");
            exito = false;
        }
        return exito;
    }
    public void setCheck(Checkeo check) {
        this.check = check;
    }

    private void normalizarTurbinas() {
        try {
            for(int i=0; i< turbina.length; i++){
            turbina[i]= true;
            System.out.println("turbina "+ i+ " normalizada");
            Thread.sleep(1000);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    private void regularPresion(){
        try {
            System.out.println("Regulando la presion....");
            Thread.sleep(4000);
            System.out.println("Presion regulada");
            presion= true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void regularOxigeno(){
        try {
            System.out.println("Regulando la oxigeno....");
            Thread.sleep(3000);
            System.out.println("Oxigeno regulado");
            oxigeno= true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void regularVoltios(){
        try {
            System.out.println("Regulando la voltios....");
            Thread.sleep(2000);
            System.out.println("Violtios regulados");
            voltios= true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void regularTemperatura(){
        try {
            System.out.println("Regulando la temperatura....");
            Thread.sleep(2000);
            temperatura= 50;
            System.out.println("temperatura regulada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void protocoloDeAccion(){
     
        
        scheduler.scheduleAtFixedRate(turbinaTask, 3, 20, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(temperaturaTask, 3, 25, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(presionTask, 3, 26, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(oxigenoTask, 3, 10, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(voltiosTask, 3, 16, TimeUnit.SECONDS);
    }

    
        
}
