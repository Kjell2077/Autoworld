/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

/**
 *
 * @author kjell.leenknegt
 */
public enum DIV {
    
    INSTANCE;
    
    private int laatste3tekens;
    
    public Nummerplaat getNummerplaat(){
        
        
        if (laatste3tekens==1000){
            laatste3tekens=1;
            }     
        return new Nummerplaat( String.format("AAA%03d", laatste3tekens++) );
    }

    public static DIV getINSTANCE() {
        return INSTANCE;
    }
    
    
    
}
