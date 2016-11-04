/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.awt.Color;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Kjell
 */
public class Personenwagen extends Voertuig {
   
   private Color kleur;
   protected static Rijbewijs[] toegestaneRijbewijzen = new Rijbewijs[] {Rijbewijs.B, Rijbewijs.BE};
   protected static int MAX_ZITPLAATSEN = 8;
    /**
     *
     * @param merk
     * @param datumEersteIngebruikname
     * @param aankoopprijs
     * @param zitplaatsen
     * @param KLEUR
     * @param bestuurder
     * @param ingezetenen
     */
    public Personenwagen (String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color KLEUR , Mens bestuurder, Mens... ingezetenen)   {
        super (merk,datumEersteIngebruikname,aankoopprijs,zitplaatsen, bestuurder, ingezetenen);
        setKleur(KLEUR);
    
    }
    
    public java.awt.Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        if(kleur != null) {
        this.kleur = kleur;
        }
    }
       
    
    @Override
    public String toString() {
        return super.toString()+" "+zitplaatsen;
        
    //String toString = String.format("%s %s %s %s %s", nummerplaatString, merkString, datumString, aankoopprijsString, "Ammelie(B, B+E, C, C+E)");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nummerplaat) + Objects.hashCode(this.kleur);
        return hash;
    }
//@Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 97 * hash + Objects.hashCode(this.nummerplaat);
//        return hash;
//    }
    
    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen(){
        return toegestaneRijbewijzen;
    }
    @Override
    protected int getMAX_ZITPLAATSEN(){
        return MAX_ZITPLAATSEN;
    }
       
}
