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
public class ServiceResultDTO implements Serializable
{
    protected String namespace;
    protected String resultCode;
    protected String resultDesc;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
    
    
}
