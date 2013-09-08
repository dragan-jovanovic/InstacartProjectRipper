package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import JSci.io.TextWriter;


public class Main {
	
	private URL url;
	private URLConnection urlConnection;
	private static final String root = "/Users/draganjovanovic/Documents/Projects/InstaCartRipper";

	private URLConnection pageConnection(String link) {
		
		try {
			url = new URL(link);
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}
		
        try {
			return url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private BufferedReader urlBufferedReader(URLConnection urlConnection) {
		
        try {
        	
        	return new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        } catch (IOException e) {
        	
        	e.printStackTrace();
        	return null;
		}
	}
	
	private File initialiseFile() {
		
		String fileName = "Test";
		String fileType = "html";
		return new File(root + '/' + fileName + '.' + fileType);
	}
	
	private void dumbToFile(BufferedReader in) {
		
		TextWriter textWriter;
        String inputLine;
        
		try {
			textWriter = new TextWriter(initialiseFile(), (char) 0);
			
			while ((inputLine = in.readLine()) != null) {
				
				textWriter.write(inputLine);
				textWriter.flush();
			}
			
			textWriter.close();
			in.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		String urlString = args[0];
		main.urlConnection = main.pageConnection(urlString);
		
		BufferedReader bufferedReader = main.urlBufferedReader(main.urlConnection);
		main.dumbToFile(bufferedReader);
	}
}
