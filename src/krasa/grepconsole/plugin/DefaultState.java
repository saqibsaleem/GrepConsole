package krasa.grepconsole.plugin;

import com.intellij.ui.JBColor;
import com.intellij.util.ui.UIUtil;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import krasa.grepconsole.model.GrepColor;
import krasa.grepconsole.model.GrepExpressionItem;
import krasa.grepconsole.model.GrepStyle;
import krasa.grepconsole.model.Profile;

public class DefaultState {
	public static List<Profile> createDefault() {
		List<Profile> profiles = new ArrayList<Profile>();
		Profile profile = new Profile();
		profile.setDefaultProfile(true);
		profiles.add(profile);
		profile.setGrepExpressionItems(createDefaultItems());
		return profiles;
	}

	public static List<GrepExpressionItem> createDefaultItems() {
		List<GrepExpressionItem> items = new ArrayList<GrepExpressionItem>();
		items.add(newItem().style(getGrepStyle(JBColor.RED, UIUtil.isUnderDarcula() ? Color.BLACK : Color.WHITE).bold(true)).grepExpression(".*FATAL.*"));
		items.add(newItem().style(getGrepStyle(JBColor.ORANGE, UIUtil.isUnderDarcula() ? Color.BLACK : null)).grepExpression(".*ERROR.*"));
		items.add(newItem().style(getGrepStyle(JBColor.YELLOW, UIUtil.isUnderDarcula() ? Color.BLACK : null)).grepExpression(".*WARN.*"));
		items.add(newItem().style(getGrepStyle(null, UIUtil.isUnderDarcula() ? Color.GRAY : Color.GRAY)).grepExpression(".*DEBUG.*"));
		items.add(newItem().style(getGrepStyle(null, UIUtil.isUnderDarcula() ? Color.BLACK : Color.LIGHT_GRAY)).grepExpression(".*TRACE.*"));
		return items;
	}

	public static GrepExpressionItem newItem() {
		return new GrepExpressionItem();
	}

	public static GrepStyle getGrepStyle(Color color, Color foreground) {
		GrepStyle grepStyle = new GrepStyle().backgroundColor(new GrepColor(true, color));
		if (foreground != null) {
			grepStyle = grepStyle.foregroundColor(new GrepColor(true, foreground));
		}
		return grepStyle;
	}
}
