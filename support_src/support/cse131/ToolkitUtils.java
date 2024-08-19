package support.cse131;

import java.awt.Toolkit;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ToolkitUtils {
	@SuppressWarnings("deprecation")
	public static int getMenuShortcut() {
		// return Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
		return Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
	}
}
