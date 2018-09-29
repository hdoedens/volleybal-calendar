package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ftp {

	private static Logger log = Logger.getLogger("ftp-logger");

	public static void upload(File fileToUpload, String remoteFilename, String host, String uploadPath, String username, String password) throws IOException {

		log.setLevel(Level.INFO);
		try {
			Handler handler = new FileHandler("ftp.log");
			handler.setFormatter(new java.util.logging.SimpleFormatter());
			log.addHandler(handler);
		} catch (SecurityException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}

		String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
		uploadPath = uploadPath+"/%s";
		int BUFFER_SIZE = 1024;

		ftpUrl = String.format(ftpUrl, username, password, host, String.format(uploadPath, remoteFilename));
		log.info("Upload URL: " + ftpUrl);

		try {
			URL url = new URL(ftpUrl);
			URLConnection conn = url.openConnection();
			OutputStream outputStream = conn.getOutputStream();
			FileInputStream inputStream = new FileInputStream(fileToUpload.getAbsolutePath());

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outputStream.close();

			log.info("ftp upload gelukt");
		} catch (IOException ex) {
			ex.printStackTrace();
			log.severe("ftp upload mislukt");
		}
	}
}
