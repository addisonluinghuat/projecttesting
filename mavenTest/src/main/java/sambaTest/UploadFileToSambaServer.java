package sambaTest;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class UploadFileToSambaServer {
	static final String USER_NAME = "pi";
	static final String PASSWORD = "raspberry";
	// e.g. Assuming your network folder is: \my.myserver.netsharedpublicphotos
	static final String NETWORK_FOLDER = "smb://raspberrypi.local/share/";

	public static void main(String args[]) {
		String fileContent = "This is a test file";

		new UploadFileToSambaServer().copyFiles(fileContent, "testFile.text");
	}

	public boolean copyFiles(String fileContent, String fileName) {
		boolean successful = false;
		try {
			String user = USER_NAME + ":" + PASSWORD;
			System.out.println("User: " + user);

			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
			String path = NETWORK_FOLDER + fileName;
			System.out.println("Path: " + path);

			SmbFile sFile = new SmbFile(path, auth);
			SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
			sfos.write(fileContent.getBytes());

			successful = true;
			System.out.println("Successful" + successful);
		} catch (Exception e) {
			successful = false;
			e.printStackTrace();
		}
		return successful;
	}
}
