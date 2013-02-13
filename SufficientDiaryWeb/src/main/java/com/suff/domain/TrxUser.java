/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suff.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Jeerapu
 */
public class TrxUser implements Serializable 
{
    private String suffId;
    private String username;
    private String credential;
    private Timestamp expiry;
    private String status;
    private Timestamp lastLogin;
    private Timestamp created;
    private String createdBy;
    private Timestamp lastUpd; 
    private String updBy;

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Timestamp getExpiry() {
        return expiry;
    }

    public void setExpiry(Timestamp expiry) {
        this.expiry = expiry;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getLastUpd() {
        return lastUpd;
    }

    public void setLastUpd(Timestamp lastUpd) {
        this.lastUpd = lastUpd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuffId() {
        return suffId;
    }

    public void setSuffId(String suffId) {
        this.suffId = suffId;
    }

    public String getUpdBy() {
        return updBy;
    }

    public void setUpdBy(String updBy) {
        this.updBy = updBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "TrxUser{" + "suffId=" + suffId + ", username=" + username + ", credential=" + credential + ", expiry=" + expiry + ", status=" + status + ", lastLogin=" + lastLogin + ", created=" + created + ", createdBy=" + createdBy + ", lastUpd=" + lastUpd + ", updBy=" + updBy + '}';
    }
    
    
    
}
