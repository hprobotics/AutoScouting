/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.beastiebots.utilities;

import java.util.Date;

/**
 *
 * @author Jacob
 */
public abstract class Timestamped {
    Date timestamp;
    
    public Timestamped() {
        timestamp = new Date();
    }
    
    public Timestamped(long time) {
        timestamp = new Date(time);
    }
    
    public Date getDate(){
        return timestamp;
    }
    
    public void updateDate() {
        timestamp = new Date();
    }
    
    public void setDate(long time) {
        timestamp = new Date(time);
    }
}
