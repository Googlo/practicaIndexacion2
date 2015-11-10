/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author moulay
 */
public class Ocurrences implements Comparable {
    private Integer dID;
    private Integer tf;
    
    public Ocurrences(Integer dID, Integer tf) {
        this.dID = dID;
        this.tf = tf;
    }
    
    public Integer getdID() {
        return dID;
    }
    
    public Integer getTf() {
        return tf;
    }

    @Override
    public int compareTo(Object o) {
        Ocurrences o2 = (Ocurrences)o;
        return tf.compareTo(o2.tf);
    }
}
