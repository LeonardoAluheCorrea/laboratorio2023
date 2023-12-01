/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Leo
 */
public class CheckTurbinas extends Checkeo{
    private Server server;

    public CheckTurbinas(Server server) {
        this.server = server;
    }

    @Override
    public boolean check() {
        boolean exito = true;
        int i = 0;
        while (exito && i < 10){//Checkea que todas las turbinas esten en false
            exito = server.getTurbina(i);
            if (!exito){
                System.out.println("WARNING: REVISAR TURBINA " + i);
            }
            i++;
        }
        return checkProximo();
    }
    
}
