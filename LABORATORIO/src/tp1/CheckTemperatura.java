/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Leo
 */
public class CheckTemperatura extends Checkeo{
    private Server server;

    public CheckTemperatura(Server server) {
        this.server = server;
    }

    @Override
    public boolean check() {
        boolean exito;
        if (server.getTemperatura() > 100){
            exito = false;
            System.out.println("WARNING: TEMPERATURA ALTA");
        }
        else{
            exito = checkProximo();
        }
        return exito;
    }
    
}
