/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Leo
 */
public class CheckOxigeno extends Checkeo{

    private Server server;
    
    @Override
    public boolean check() {
        boolean exito;
        if (!server.isOxigeno()){
            exito = false;
            System.out.println("WARNING: OXIGENO BAJO");
        }
        else{
            exito = checkProximo();
        }
        return exito;
    }
    
}
