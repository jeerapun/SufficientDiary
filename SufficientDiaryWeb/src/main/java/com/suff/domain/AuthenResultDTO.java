/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.domain;

import java.io.Serializable;

/**
 *
 * @author Jeerapu
 */
public class AuthenResultDTO extends ServiceResultDTO implements Serializable 
{
    private TrxUser trxUser = null;

    public TrxUser getTrxUser() {
        return trxUser;
    }

    public void setTrxUser(TrxUser trxUser) {
        this.trxUser = trxUser;
    }
    
}
