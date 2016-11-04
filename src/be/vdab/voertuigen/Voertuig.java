/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.Voertuig.AankoopprijsComparator;
import be.vdab.voertuigen.Voertuig.MerkComparator;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kjell.leenknegt
 */
public abstract class Voertuig implements Serializable, Comparable<Voertuig> {
    public static final long serialVersionUID = 1L;
    protected Nummerplaat nummerplaat;
    protected String merk;
    protected Datum datumEersteIngebruikname;
    protected int aankoopprijs;
    protected final int zitplaatsen;
    protected Mens bestuurder;
    protected Set<Mens> inzittendenSetExclusiefBestuurder = new TreeSet<>();
    protected Set <Mens> inzittendenSet = new TreeSet<>();
//    protected static Rijbewijs[] toegestaneRijbewijzen;    
    protected Set <String> inzittendenNamenSet = new TreeSet<>();
    
    
    
    

    public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... ingezetenen)   {
        this.nummerplaat = DIV.getINSTANCE().getNummerplaat();
        this.merk = merk;
        setDatumEersteIngebruikname(datumEersteIngebruikname);
        this.aankoopprijs = aankoopprijs;
        if ((zitplaatsen>getMAX_ZITPLAATSEN())){
            throw new IllegalArgumentException();
        }
                
        if ((zitplaatsen<1)){
            throw new IllegalArgumentException();
        }
        else {
        this.zitplaatsen = zitplaatsen;
        }
        setBestuurder(bestuurder);
        for (Mens m:ingezetenen){
                addIngezetene(m);
            }      
       
               
    }    
      
    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
    
    public Datum getDatumEersteIngebruikname() {
        return datumEersteIngebruikname;
    }
    public final void setDatumEersteIngebruikname(Datum d)throws DatumException{
        this.datumEersteIngebruikname=d;
    }
    
    public int getAankoopprijs() {
        return aankoopprijs;
    }

    protected abstract int getMAX_ZITPLAATSEN();

    public void setAankoopprijs(int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }
    public final void addIngezetene(Mens m) {
        if (!(this.inzittendenSet.contains(m))){
            if (this.inzittendenSet.size() < zitplaatsen){
                this.inzittendenSet.add(m);
                }
                    else {
                        throw new MensException("er zijn teveel inzittenden") ;
                    }        
                }
        
    } 
    
       
    
    public Set getIngezetenen(){
        return inzittendenSet;
    }
    
    public Set getIngezeteneExclusiefBestuurder(){
        inzittendenSetExclusiefBestuurder.addAll(inzittendenSet);
        inzittendenSetExclusiefBestuurder.remove(bestuurder);
        return inzittendenSetExclusiefBestuurder;
    }
    
    public boolean isIngezetene (Mens m){
        return (inzittendenSet.contains(m));
    }
    
    public void setBestuurder(Mens m) {
        if (m!=null) {
            
                boolean checkGeldigRijbewijs = false;
                for (Rijbewijs r:this.getToegestaneRijbewijzen()){
                    if (Arrays.asList(m.getRijbewijs()).contains(r)){
                        checkGeldigRijbewijs = true;
                    }
                }
                if (checkGeldigRijbewijs){
                    addIngezetene(m);
                    bestuurder=m;   
                
                }
                else {
                    throw new MensException ("bestuurder heeft geen geldig rijbewijs");
                }
                            
        }
           
    }    
    
    public Mens getBestuurder(){
        return bestuurder;
        
    }
    
    public int getZitplaatsen (){
        return zitplaatsen;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().
        append(nummerplaat).append(" ").append(merk).append(" ").append(datumEersteIngebruikname).append(" ").append(aankoopprijs).append(" ").append(this.getBestuurder());
        if (getIngezeteneExclusiefBestuurder().size()>0){ stringBuilder.append(" [");}
        
        for (Mens m: inzittendenSetExclusiefBestuurder){
            inzittendenNamenSet.add(m.getNaam());
        }
        stringBuilder.append(StringUtils.join(inzittendenNamenSet,", "));
        if (inzittendenSetExclusiefBestuurder.size()>0){ stringBuilder.append("]");}
        return stringBuilder.toString();
    //String toString = String.format("%s %s %s %s %s", nummerplaatString, merkString, datumString, aankoopprijsString, "Ammelie(B, B+E, C, C+E)");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nummerplaat);
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
        final Voertuig other = (Voertuig) obj;
        if (!Objects.equals(this.nummerplaat, other.nummerplaat)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Voertuig v){
        if (v==null){
            throw new NullPointerException();
        }        
        return this.nummerplaat.compareTo(v.nummerplaat);
    }
    
    protected abstract Rijbewijs[] getToegestaneRijbewijzen();
    
     
    public static AankoopprijsComparator getAankoopprijsComparator() {
         return new AankoopprijsComparator();
        }
    
    public static class AankoopprijsComparator implements Comparator<Voertuig> {
        
        @Override
        public int compare(Voertuig v1, Voertuig v2){
            if (v1==null||v2==null){
            throw new NullPointerException();
        } 
            return v1.aankoopprijs-v2.aankoopprijs;
        }
    }
     
    
    public static MerkComparator getMerkComparator() {
         return new MerkComparator();
    }
    
    public static class MerkComparator implements Comparator<Voertuig> {
        
        @Override
        public int compare(Voertuig v1, Voertuig v2){
            if (v1==null||v2==null){
                throw new NullPointerException();
            } 
            return v1.merk.compareTo(v2.merk);
        }
    }
    
    
     
}
