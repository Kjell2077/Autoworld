/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author Kjell
 */
public class Volume implements Serializable, Comparable<Volume> {
    public static final long serialVersionUID = 1L;
    private int hoogte, breedte, diepte;
    private Maat maat;
    private long volumeinhoudcm3;


    public Volume(int hoogte, int breedte, int diepte, Maat maat)throws VolumeException {
        if (hoogte>=0 && breedte>=0 && diepte>=0){
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.diepte = diepte;
        this.maat = maat;
        
        }
        
        else {
            throw new VolumeException("de ingegeven waardes moeten minstens 0 zijn");
        }   
       
    }

    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public int getDiepte() {
        return diepte;
    }

    public void setDiepte(int diepte) {
        this.diepte = diepte;
    }

    public Maat getMaat() {
        return maat;
    }

    public void setMaat(Maat maat) {
        this.maat = maat;
    }
    public long getVolume(){
       return ((long)breedte)*hoogte*diepte*maat.get3DWaarde();
    }

    @Override
    public String toString() {
        return hoogte + "(h)x" + breedte + "(b)x" + diepte + "(d) " + maat;
    }
    //"1(h)x2(b)x1903(d) centimeter"
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(hoogte)
                .append(breedte)
                .append(diepte)
                .append(maat)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Volume other = (Volume) obj;
        if (this.hoogte != other.hoogte) {
            return false;
        }
        if (this.breedte != other.breedte) {
            return false;
        }
        if (this.diepte != other.diepte) {
            return false;
        }
        if (this.maat != other.maat) {
            return false;
        }
        return true;
    }

    
    @Override
    public int compareTo(Volume v){
        return (int) (this.getVolume()- v.getVolume());
    }
    
    
}
