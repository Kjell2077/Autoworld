/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author Kjell
 */
public class Boekentas implements Laadbaar, Serializable {
    public static final long serialVersionUID = 1L;
    private Volume volume;
    private String kleur;    

    public Boekentas(String kleur, Volume volume) { 
        if (kleur != null && volume != null){
        this.kleur=kleur;
        this.volume = volume;
        }
        else {
            throw new IllegalArgumentException("alle waarden moeten ingevuld worden");
        }
        
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(volume)
                .append(kleur)
                .toHashCode();
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if (kleur != null){
        this.kleur = kleur;
        }
        else {
            throw new IllegalArgumentException ();
        }
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
        final Boekentas other = (Boekentas) obj;
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        if (!Objects.equals(this.kleur, other.kleur)) {
            return false;
        }
        return true;
    }
    
    @Override
    public Volume getLaadvolume (){
        return this.volume;
    }
    
    @Override
    public void setLaadvolume (Volume v){
        if (v!= null){
        this.volume=v;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "boekentas "+kleur + " " + volume;
    }
    
    
}
