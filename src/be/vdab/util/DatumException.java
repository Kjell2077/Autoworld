/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author kjell.leenknegt
 */
public class DatumException extends RuntimeException {
    public DatumException() {}
    public DatumException(String omschrijving){
        super(omschrijving);
    }
    public DatumException(String omschrijving, Throwable oorzaak){
        super(omschrijving,oorzaak);
    }
    public DatumException(Throwable oorzaak){
        super(oorzaak);
    }
}
