/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ParkirModel;
import view.MainView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ParkirController {
    private MainView view;
    private ParkirModel model;
    
    public ParkirController(MainView view, ParkirModel model){
        this.view = view;
        this.model = model;
        
        loadTableData();
        view.getAddButton().addActionListener(e->addData());
        view.getEditButton().addActionListener(e->editData());
        view.getDeleteButton().addActionListener(e->deleteData());
    }
    
    private void loadTableData(){
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);
        for (Object[] row : model.getParkir()){
            tableModel.addRow(row);
        }
    }
    
    private void addData(){
        String namaP = view.getTxtNamaP().getText().trim();
        String plat = view.getTxtPlat().getText().trim();
        String merk = view.getTxtMerk().getText().trim();
        String durasiStr = view.getTxtDurasi().getText().trim();
        
        try{
            int durasi = Integer.parseInt(durasiStr);
            
            model.addParkir(namaP, plat, merk, durasi);
            clearForm();
            loadTableData();
            
            JOptionPane.showMessageDialog(view, "Data berhasil ditambahkan!");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(view, "Druasi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void editData(){
        int selected = view.getSelectedRowIndex();
        String namaP = view.getTxtNamaP().getText().trim();
        String plat = view.getTxtPlat().getText().trim();
        String merk = view.getTxtMerk().getText().trim();
        String durasiStr = view.getTxtDurasi().getText().trim();
        
        try{
            int id = (int) view.getTableModel().getValueAt(selected, 0);
            
            int durasi = Integer.parseInt(durasiStr);
            
            model.editParkir(id, namaP, plat, merk, durasi);
            clearForm();
            loadTableData();
            
            JOptionPane.showMessageDialog(view, "Data berhasil diubah!");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(view, "Durasi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteData(){
        int selected = view.getSelectedRowIndex();
        
        int id = (int) view.getTableModel().getValueAt(selected, 0);
        //int confirm = JOptionPane.showConfirmDialog(view, "Yakin Ingin menghapus data ini?")
        
        model.deleteParkir(id);
        clearForm();
        loadTableData();
        JOptionPane.showMessageDialog(view, "Data berhasil dihapus!");
    }
    
    private void clearForm(){
        view.getTxtNamaP().setText("");
        view.getTxtPlat().setText("");
        view.getTxtMerk().setText("");
        view.getTxtDurasi().setText("");
        view.getTable().clearSelection();
    }
}
