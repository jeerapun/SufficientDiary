package com.suff.domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeerapu
 */
public class LoginDTO {
    private String username;
    private String password;

    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
}
