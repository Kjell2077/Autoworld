/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author Kjell
 */
public class VolumeException extends Exception {
    public VolumeException() {}
    public VolumeException(String omschrijving){
        super(omschrijving);
    }
    public VolumeException(String omschrijving, Throwable oorzaak){
        super(omschrijving,oorzaak);
    }
    public VolumeException(Throwable oorzaak){
        super(oorzaak);
    }
}