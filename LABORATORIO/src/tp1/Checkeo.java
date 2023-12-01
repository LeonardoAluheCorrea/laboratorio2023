/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Leo
 */
public abstract class Checkeo {
    private Checkeo proximo;
    
    
    public static Checkeo enlace(Checkeo primero, Checkeo... cadena){
        Checkeo cabeza = primero;
        for (Checkeo proximoEnCadena: cadena){
            cabeza.proximo = proximoEnCadena;
            cabeza = proximoEnCadena;
        }
        return primero;
    }
    
    public abstract boolean check();
            
    protected boolean checkProximo(){
        boolean exito;
        if (proximo == null){
            exito = true;
        }
        else{
            exito = proximo.check();
        }
        return exito;
    }
}