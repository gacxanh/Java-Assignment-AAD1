/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anhph
 */
public class DataConnect {
    private Connection con;
    public Connection Connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:db//Note.db");
        return con;     
    }
}
