package org.dw.threadWaiting;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class FileDownLoader extends Thread{
	
	private String url;
	private String fileName;
	
	public FileDownLoader (String url, String fileName) {
		this.url = url;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Started to Download: "+fileName );
			
			URL resourceToDownload = new URL(url);
			URLConnection connection = resourceToDownload.openConnection();
			InputStream input = connection.getInputStream();
			
			File fileToSave = new File (fileName);
			Files.copy(input, fileToSave.toPath());
			
			input.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
