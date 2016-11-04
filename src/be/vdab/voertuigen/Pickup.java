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
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Kjell
 */
public class Pickup extends Personenwagen implements Laadbaar, Serializable {
    public static final long serialVersionUID = 1L;
    private Volume volume;
    
    public Pickup (String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color c , Volume v, Mens bestuurder, Mens... ingezetenen)   {
        super (merk,datumEersteIngebruikname,aankoopprijs,zitplaatsen, c, bestuurder, ingezetenen);
        this.volume = v;
                       
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
    public String toString(){
    return super.toString()+" "+volume;
     
    }
    
}
