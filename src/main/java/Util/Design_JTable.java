/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import javax.swing.JTable;

/**
 *
 * @author vivas
 */
public class Design_JTable {

    public void ocultarColumnas(JTable tabla, int... indices) {
        for (int index : indices) {
            tabla.getColumnModel().getColumn(index).setMinWidth(0);
            tabla.getColumnModel().getColumn(index).setMaxWidth(0);
            tabla.getColumnModel().getColumn(index).setWidth(0);
            tabla.getColumnModel().getColumn(index).setPreferredWidth(0);
        }
    }
}
