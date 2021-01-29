/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.render;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author JSULCAG
 */
public class TCellEditorCbx  extends DefaultCellEditor{

    public TCellEditorCbx(JComboBox comboBox) {
        super(comboBox);
        setClickCountToStart(1);
        delegate = new javax.swing.DefaultCellEditor.EditorDelegate(){
            
        };
    }
    
}
