/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.entity;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anhph
 */
public class NoteTableModel extends AbstractTableModel{

    private List<Note> data;

    public List<Note> getData() {
        return data;
    }

    public void setData(List<Note> data) {
        this.data = data;
    }

    public NoteTableModel(List<Note> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Note row = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getNoteTitle();
            default:
                return "Not Found";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0:
                return "List Note";
            default:
                return "Not Found";
        }
    }
    
}
