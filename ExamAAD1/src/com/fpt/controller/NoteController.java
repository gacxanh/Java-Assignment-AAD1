/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.controller;

import com.fpt.entity.Note;
import com.fpt.model.NoteModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anhph
 */
public class NoteController {
    NoteModel nm = new NoteModel();
    public boolean addNoteController(Note p){
        return nm.addNote(p);
    }
    
    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Note> list() throws ClassNotFoundException, SQLException{
        return nm.listNote();
    }
    
    public List<Note> getListSearch(String noteName) throws ClassNotFoundException, SQLException{
        return nm.findNote(noteName);
    }
}
