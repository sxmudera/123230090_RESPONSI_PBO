/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lab Informatika
 */

import controller.ParkirController;
import model.ParkirModel;
import view.MainView;

public class Main {
    
    public static void main(String[] args){
        MainView view = new MainView();
        ParkirModel model = new ParkirModel();
        new ParkirController(view, model);
        view.setVisible(true);
    }
}
