/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author kjell.leenknegt
 */
public class Datum implements Comparable<Datum>, Serializable {
    public static final long serialVersionUID = 1L;
    private final int dag;
    private final int maand;
    private final int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {
        
        
        
            if      (!(jaar < 1583 || jaar >= 4100)){
                switch (maand){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dag > 0 & dag <= 31){
                        this.dag = dag;
                        this.maand = maand;
                        this.jaar = jaar;
                        break;
                    }    
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dag > 0 & dag <= 30){
                        this.dag = dag;
                        this.maand = maand;
                        this.jaar = jaar;
                        break;
                    }
                case 2:
                    if (dag > 0 & dag <= (((jaar%4==0)& !(jaar%100==0))|| ((jaar%100==0)& (jaar%400==0))?29:28)){
                        this.dag = dag;
                        this.maand = maand;
                        this.jaar = jaar;
                        break;
                    }
                default:
                    throw new DatumException("ongeldige datum");
                }
                    //((!(jaar < 1583 || jaar >= 4100)) & (((maand == (1|3|5|7|8|10|12)) & (dag > 0 & dag <= 31))||((maand == (4|6|9|11)) & (dag > 0 & dag <= 30))||((maand == 2) & (dag > 0 & dag <= (((jaar%4==0)& !(jaar%100==0))|| ((jaar%100==0)& (jaar%400==0))?29:28))))){                           
//                    this.dag = dag;
//                    this.maand = maand;
//                    this.jaar = jaar;
                }
            
            
            else {
                throw new DatumException("ongeldige datum");
            }
        
                        
    }
       
    
        
    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {
        return jaar;
    }

    @Override
    public int hashCode() {
        int hash = (jaar*10_000+maand*100+dag);
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
        final Datum other = (Datum) obj;
        if (this.dag != other.dag) {
            return false;
        }
        if (this.maand != other.maand) {
            return false;
        }
        if (this.jaar != other.jaar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%1$02d/%2$02d/%3$04d",dag,maand,jaar);
    }
    
    @Override
    public int compareTo(Datum d){
        if (d == null){
            throw new NullPointerException();
        }
        if (this.equals(d)){
            return 0;
        }
        else {
            if (this.jaar*10_000+this.maand*100+this.dag < d.jaar*10_000+d.maand*100+d.dag){
                return -1;
            }
            return 1;
        }
        
    }
    
}
