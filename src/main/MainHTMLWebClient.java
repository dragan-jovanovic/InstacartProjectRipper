package main;

import java.io.*;
import java.net.*;

import textWriter.TextWriterHtml;

public class MainHTMLWebClient {
	
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://www.instacart.com/accounts/login");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(
                                         connection.getOutputStream());
        out.write("document.getElementById(\"user_email\").value = \"dragan.jovanovic@me.com\";");
        out.write("document.getElementById(\"user_password\").value = \"gS65.rPqvT85;rLp\";");
        out.write("document.getElementById(\"new_user\").submit()");
        out.close();

        BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    connection.getInputStream()));
        String decodedString;
        TextWriterHtml textWriterHtml = new TextWriterHtml("TestPage2");
        
        while ((decodedString = in.readLine()) != null) {
            textWriterHtml.write(decodedString);
        }
        in.close();
        textWriterHtml.close();
    }
}