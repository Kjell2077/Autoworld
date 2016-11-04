/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.main;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.util.mens.Mens;
import static be.vdab.util.mens.Rijbewijs.A;
import static be.vdab.util.mens.Rijbewijs.B;
import static be.vdab.util.mens.Rijbewijs.BE;
import static be.vdab.util.mens.Rijbewijs.C;
import static be.vdab.util.mens.Rijbewijs.CE;
import static be.vdab.util.mens.Rijbewijs.D;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Voertuig.AankoopprijsComparator;
import be.vdab.voertuigen.Voertuig.MerkComparator;
import be.vdab.voertuigen.Vrachtwagen;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Kjell
 */
public class Hoofdprogramma {

    /**
     * @param args the command line arguments
     * @throws be.vdab.util.VolumeException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws DatumException, VolumeException, FileNotFoundException, IOException, ClassNotFoundException {
        Datum d1 = new Datum (1,2,1999);
        Datum d2 = new Datum (15,12,2013);
        Color c1 = new Color (150);
        Color c2 = new Color (140);
        Mens BESTUURDER_A = new Mens("Andree", A, B, C, CE);
        Mens BESTUURDER_B = new Mens("Bernard", B, C, CE, D);
        Mens BESTUURDER_C = new Mens("James", A, B, BE, C, CE, D);
        Volume v1 = new Volume (2,3,4,Maat.meter);
        Volume v2 = new Volume (25,35,40,Maat.decimeter);
        SortedSet <Voertuig> voertuigenSet = new TreeSet <>() ;
        
        Voertuig [] voertuigen = new Voertuig[6];
        //merk,datumEersteIngebruikname,aankoopprijs,zitplaatsen, c, bestuurder, ingezetenen
        Personenwagen personenwagen1 = new Personenwagen ("DAF", d1,30_000,3,c1,BESTUURDER_A);
        Personenwagen personenwagen2 = new Personenwagen ("Volkswagen", d2,30_000,3,c2,BESTUURDER_B);
        Pickup pickup1 = new Pickup ("DAF", d1,50_000,3,c2,v1, BESTUURDER_B);
        Pickup pickup2 = new Pickup ("DAF", d1,45_000,3,c2,v2, BESTUURDER_C);
        //new Vrachtwagen("a", datum, AANKOOPPRIJS_1, ZITPLAATSEN, VOLUME10, MAXIAAM_TOEGELATEN_MASSA_1, AANTAL_ASSEN_2, BESTUURDER_BBECCE)
        Vrachtwagen vrachtwagen1 = new Vrachtwagen ("Volvo", d2,80_000,3,v1,500, 2,BESTUURDER_B);
        Vrachtwagen vrachtwagen2 = new Vrachtwagen ("Volvo", d1,75_000,2,v2,500, 2,BESTUURDER_C);
        voertuigenSet.add(personenwagen1);
        voertuigenSet.add(personenwagen2);
        voertuigenSet.add(pickup1);
        voertuigenSet.add(pickup2);
        voertuigenSet.add(vrachtwagen1);
        voertuigenSet.add(vrachtwagen2);
        
        for (Voertuig v:voertuigenSet){
            System.out.println(v);
        }
        
        List <Voertuig> voertuigenList2 = new ArrayList <>();
        voertuigenList2.addAll(voertuigenSet);
        voertuigenList2.sort(new AankoopprijsComparator());
        Collections.reverse(voertuigenList2);
        for (Voertuig v:voertuigenList2){
            System.out.println(v);
        }
        
        List <Voertuig> voertuigenList3 = new ArrayList <>();
        voertuigenList3.addAll(voertuigenList2);
        voertuigenList3.sort(new MerkComparator());
        for (Voertuig v:voertuigenList3){
            System.out.println(v);
        }
        
        
        try (FileOutputStream fos = new FileOutputStream ("C:\\Users\\kjell.leenknegt\\Documents\\NetBeansProjects\\wagenpark.ser",true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);){
            for (Voertuig v : voertuigenList3) {                
                oos.writeObject(v);
            }
        }
        catch (IOException e){
            e.getMessage();
                }
        
        List <Voertuig> voertuigenList4 = new ArrayList <>();
                
        try (FileInputStream fis = new FileInputStream ("C:\\Users\\kjell.leenknegt\\Documents\\NetBeansProjects\\wagenpark.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);){
            Voertuig v;
            while (ois.readObject() != null){
                v = (Voertuig) ois.readObject();
                voertuigenList4.add(v);
                
            }
        }
        
        catch (StreamCorruptedException o ){
            System.out.println("StreamCorruptedException");  
        }  
//        Thrown:
// If the stream header is invalid.
// If control information not found.
// If control information is invalid.
// JDK 1.1.5 or less attempts to call readExternal on a PROTOCOL_VERSION_2 stream.
        
//        => main is NIET threadsafe, zodoende kan je inlezen en schrijven tegelijk met errors vandien !!!!
        
        catch (ObjectStreamException o ){
            System.out.println("ObjectStreamException");  
        }            
        
        catch (IOException e ){
            System.out.println("file niet gevonden");    
        }
        
        catch (ClassNotFoundException c ){
            System.out.println("klasse niet gevonden");    
        }

        for (Voertuig v:voertuigenList4){
            System.out.println(v);
        }
        
        

    }
    
}
