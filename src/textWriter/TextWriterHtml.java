package textWriter;

import java.io.File;
import java.io.IOException;

import JSci.io.TextWriter;

public class TextWriterHtml {

	private static TextWriter textWriter;
	private static File file;
	private static final String root = "/Users/draganjovanovic/Documents/Projects/InstaCartRipper";
	
	public TextWriterHtml(String fileName) {
		
		file = new File(root + "/" + fileName + ".html");
		initialiseTextWriter();
	}
	
	private void initialiseTextWriter() {
		
		try {
			textWriter = new TextWriter(file, (char) 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String text) {
		
		try {
			textWriter.write(text);
			textWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		
		try {
			textWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
