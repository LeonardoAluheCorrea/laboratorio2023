/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Leo
 */
public class CheckPresion extends Checkeo{
    private Server server;
            
    @Override
    public boolean check() {
        boolean exito;
        if (!server.isPresion()){
            exito = false;
            System.out.println("WARNING: PRESION BAJA");
        }
        else{
            exito = checkProximo();
        }
        return exito;
    }
    
}
