/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Kjell
 */
public class Vrachtwagen extends Voertuig implements Laadbaar {
    public static final long serialVersionUID = 1L;
    private Volume volume;
    private static final int MAX_ZITPLAATSEN = 3;    
    private int maximaalToegelatenMassa, aantalAssen;
    protected static Rijbewijs[] toegestaneRijbewijzen = new Rijbewijs[] {Rijbewijs.C, Rijbewijs.CE, Rijbewijs.D,Rijbewijs.DE};
    
    //new Vrachtwagen("a", datum, AANKOOPPRIJS_1, ZITPLAATSEN, VOLUME10, MAXIAAM_TOEGELATEN_MASSA_1, AANTAL_ASSEN_2, BESTUURDER_BBECCE)
    public Vrachtwagen (String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Volume laadvolume,int maximaalToegelatenMassa,int aantalAssen, Mens bestuurder, Mens... ingezetenen)  {
        super (merk,datumEersteIngebruikname,aankoopprijs,zitplaatsen, bestuurder, ingezetenen);
        this.volume=laadvolume;
        this.maximaalToegelatenMassa=maximaalToegelatenMassa;
        this.aantalAssen=aantalAssen;
    }

    
    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }
    
    @Override
    public Volume getLaadvolume (){
        return this.volume;
    }
    
    @Override
    public void setLaadvolume (Volume v){
        this.volume=v;
    }
    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen(){
        return toegestaneRijbewijzen;
    }
    @Override
    protected int getMAX_ZITPLAATSEN(){
        return MAX_ZITPLAATSEN;
    }
    @Override
    public String toString(){
    return super.toString()+" assen:"+aantalAssen+", maximaal toegelaten massa:"+maximaalToegelatenMassa+", laadvolume:"+volume;
    }
    
}
