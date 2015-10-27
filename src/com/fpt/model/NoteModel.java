/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.model;

import com.fpt.entity.Note;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhph
 */
public class NoteModel {
    private Connection con;
    DataConnect db = new DataConnect();
    List<Note> list = new ArrayList<>();
    
    public boolean addNote(Note n){
        try {
            con = db.Connect();
            String sqlQuery = "insert into Note(NoteTitle, NoteContent) values (?,?)";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, n.getNoteTitle());
            pst.setString(2, n.getNoteContent());
            pst.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return false;
    }
    
    public List<Note> listNote() throws ClassNotFoundException, SQLException{
        con = db.Connect();
        String sqlQuery = "select * from Note";
        PreparedStatement pst = con.prepareStatement(sqlQuery);
        ResultSet rs = pst.executeQuery();
        list.clear();
        while(rs.next()){
            Note a = new Note(rs.getString("NoteTitle"), rs.getString("NoteContent"));
            list.add(a);
        }
        return list;
    }
    
    public List<Note> findNote(String noteName) throws ClassNotFoundException, SQLException{
        con = db.Connect();
        String sqlQuery = "select * from Note where NoteTitle = ?";
        PreparedStatement pst = con.prepareStatement(sqlQuery);
        pst.setString(1, noteName);
        ResultSet rs = pst.executeQuery();
        list.clear();
        while(rs.next()){
            Note a = new Note(rs.getString("NoteTitle"), rs.getString("NoteContent"));
            list.add(a);
        }
        return list;
    }
}
