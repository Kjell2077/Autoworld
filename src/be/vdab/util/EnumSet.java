/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.AbstractSet;

/**
 *
 * @author kjell.leenknegt
 * @param <Rijbewijs>
 */

public abstract class EnumSet <Rijbewijs extends Enum<Rijbewijs>> extends AbstractSet<Rijbewijs> implements Cloneable, Serializable {
    
}
