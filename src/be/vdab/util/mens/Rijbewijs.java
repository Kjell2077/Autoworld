/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

/**
 *
 * @author kjell.leenknegt
 */
public enum Rijbewijs {
    A ("A"),B ("B"),BE ("B+E"),C ("C"),CE ("C+E"),D("D"),DE ("D+E"); 
    
    private String rijbewijstekst;
    
    Rijbewijs(String rijbewijstekst){
        this.rijbewijstekst=rijbewijstekst;
    }
      
       
    public String getRijbewijstekst() {
        return rijbewijstekst;
    }
    
        
    public void setRijbewijstekst(String rijbewijstekst) {
        this.rijbewijstekst = rijbewijstekst;
    }
    @Override
    public String toString(){
        return rijbewijstekst;
    }
    
    
    
}