package krasa.grepconsole.gui;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.jetbrains.annotations.Nullable;

import com.intellij.ui.BooleanTableCellEditor;
import com.intellij.ui.BooleanTableCellRenderer;

public class CheckBoxJavaBeanColumnInfo<T, Boolean> extends JavaBeanColumnInfo {
	public CheckBoxJavaBeanColumnInfo(String name, String propertyName) {
		super(name, propertyName);
	}

	@Nullable
	@Override
	public TableCellRenderer getRenderer(Object o) {
		return new BooleanTableCellRenderer();
	}

	@Nullable
	@Override
	public TableCellEditor getEditor(Object o) {
		return new BooleanTableCellEditor();
	}
}
