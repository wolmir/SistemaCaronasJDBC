/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.views.emprestimo;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author Bruna
 */
public class ComboBoxEditor extends DefaultCellEditor {

    public ComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }
}
