/*
* @Autor Frank
* Dit is een oefening.
 */

package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author frank.roelants
 */
public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    public static final long serialVersionUID = 1L;
    private final String plaat;
    
    
    protected Nummerplaat(String plaat) {
        this.plaat = plaat;      
      
    }

    public String getPlaat() {
        return plaat;
    }
        
      

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.plaat);
        return hash;
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
        final Nummerplaat other = (Nummerplaat) obj;
        if (!Objects.equals(this.plaat, other.plaat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return plaat;
    }

    @Override
    public int compareTo(Nummerplaat nummerplaat)  {
        if (nummerplaat.plaat==null){
            throw new NullPointerException();
        }
        else { 
            return this.getPlaat().compareTo(nummerplaat.plaat);
        }
        
         
    }
    
    
}
