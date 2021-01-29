

package lissa.render;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

public class TCellEditor extends DefaultCellEditor{
    public TCellEditor(final JCheckBox pve) {
        super(pve);
        setClickCountToStart(1);
        delegate = new javax.swing.DefaultCellEditor.EditorDelegate() {
            @Override
            public void setValue(Object value) {
                boolean selected = false;
                if (value instanceof Boolean) {
                    selected = ((Boolean)value).booleanValue();
                }
                else if (value instanceof String) {
                    selected = value.equals("true");
                }
                pve.setSelected(selected);
            }
            @Override
            public Object getCellEditorValue() {
                return Boolean.valueOf(pve.isSelected());
            }
        };
	pve.addActionListener(delegate);
        pve.setRequestFocusEnabled(false);
    }    
}
