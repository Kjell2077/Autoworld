/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author kjell.leenknegt
 */
public class Mens implements Serializable, Comparable<Mens> {
    public static final long serialVersionUID = 1L;
    private String naam;
    private Set<Rijbewijs> rijbewijzen = new TreeSet<>();
    
    public Mens(String naam, Rijbewijs... rijbewijzen) {
        this.naam = naam;
        this.rijbewijzen.addAll(Arrays.asList(rijbewijzen));
    }   

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Rijbewijs[] getRijbewijs() {
        return rijbewijzen.toArray(new Rijbewijs[rijbewijzen.size()]);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(naam)
                .append(rijbewijzen)
                .toHashCode();
    }

    @Override
    @SuppressWarnings("BoxedValueEquality")
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
        final Mens other = (Mens) obj;
        return naam.equals(other.naam) && 
               CollectionUtils.isEqualCollection(rijbewijzen, other.rijbewijzen);
    }

    @Override
    /**
     * Ammelie
     * Ammelie(B)
     * Ammelie(B, B+E, C, C+E)
     */
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder().
               append(naam);
       if(!rijbewijzen.isEmpty()){
           stringBuilder.append("(")
                        .append(StringUtils.join(rijbewijzen,", "))
                        .append(")");
       }
       return stringBuilder.toString();
    }
    
    @Override 
    public int compareTo(Mens m){
        return this.naam.compareTo(m.naam);
        }
    
}
