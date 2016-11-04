/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author Kjell
 */
public enum Maat implements Serializable, Comparable<Maat> {
    centimeter (1), decimeter (10), meter (100); 
    
    private final int waarde;
    public static final long serialVersionUID = 1L;
    
    Maat(int waarde){
        this.waarde=waarde;
    }

    public int getWaarde() {
        return waarde;
    }
    public int get3DWaarde() {
        return waarde*waarde*waarde;
    }      
}
