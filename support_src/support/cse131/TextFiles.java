package support.cse131;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class TextFiles {
	public static String readAll(Path path) {
		try {
			byte[] bytes = Files.readAllBytes(path); // TODO: specify char set?
			return new String(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String readAll(File file) {
		return readAll(file.toPath());
	}

	public static void writeAll(Path path, String text) {
		try {
			Files.write(path, text.getBytes()); // TODO: specify char set?
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void writeAll(File file, String text) {
		writeAll(file.toPath(), text);
	}
}
