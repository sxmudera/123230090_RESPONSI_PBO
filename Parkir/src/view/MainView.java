/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lab Informatika
 */
public class MainView extends JFrame {
   private JTable table;
   private DefaultTableModel tableModel;
   
   private JTextField txtNamaP, txtPlat, txtMerk, txtDurasi;
   private JButton addBtn, deleteBtn, editBtn;
   
   private int selectedRowIndex = -1;
   
   public MainView(){
       setTitle("Aplikasi Parkir");
       setSize(500, 500);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       
       txtNamaP = new JTextField(); 
       txtPlat = new JTextField(); 
       txtMerk = new JTextField(); 
       txtDurasi = new JTextField();
       
       addBtn = new JButton("Add"); 
       deleteBtn = new JButton("Delete"); 
       editBtn = new JButton("Edit");
       
       JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
       form.add(new JLabel("Nama Pengguna Parkir")); form.add(txtNamaP);
       form.add(new JLabel("Plat Mobil")); form.add(txtPlat);
       form.add(new JLabel("Merk Mobil")); form.add(txtMerk);
       form.add(new JLabel("Durasi Parkir")); form.add(txtDurasi);
       
       JPanel btn = new JPanel(new GridLayout(1, 3, 10, 0));
       btn.add(addBtn);
       btn.add(editBtn);
       btn.add(deleteBtn);
       
       JPanel topPanel = new JPanel(new BorderLayout(0, 10));
       topPanel.setBorder(BorderFactory.createTitledBorder("Input Parkir"));
       topPanel.add(form, BorderLayout.CENTER);
       topPanel.add(btn, BorderLayout.SOUTH);
       add(topPanel, BorderLayout.SOUTH);
       
       tableModel = new DefaultTableModel(new Object[]
                    {"ID", "Nama Pengguna Parkir", "Plat Mobil", "Merk Mobil", 
                    "Durasi Parkir", "Total Biaya"}, 0);
       
       table = new JTable(tableModel);
       JScrollPane scrollPane = new JScrollPane(table);
       add(scrollPane, BorderLayout.CENTER);
       
       table.addMouseListener(
        new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                selectedRowIndex = table.getSelectedRow();
                if (selectedRowIndex >= 0){
                    txtNamaP.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
                    txtPlat.setText(tableModel.getValueAt(selectedRowIndex, 2).toString());
                    txtMerk.setText(tableModel.getValueAt(selectedRowIndex, 3).toString());
                    txtDurasi.setText(tableModel.getValueAt(selectedRowIndex, 4).toString());
                }
            }
        });
   }
   
   public JButton getAddButton(){
       return addBtn;
   }
   
   public JButton getEditButton(){
       return editBtn;
   }
   
   public JButton getDeleteButton(){
       return deleteBtn;
   }
   
   public JTable getTable(){
       return table;
   }
   
   public DefaultTableModel getTableModel(){
       return tableModel;
   }
   
   public JTextField getTxtNamaP(){
       return txtNamaP;
   }
   
   public JTextField getTxtPlat(){
       return txtPlat;
   }
   
   public JTextField getTxtMerk(){
       return txtMerk;
   }
   
   public JTextField getTxtDurasi(){
       return txtDurasi;
   }
   
   public int getSelectedRowIndex(){
       return selectedRowIndex;
   }
}
