/*
 * package utilities;
 * 
 * import org.apache.commons.net.ftp.FTP; import
 * org.apache.commons.net.ftp.FTPClient;
 * 
 * import java.io.FileInputStream; import java.io.IOException;
 * 
 * public class FTPUpload { public static void uploadFile(String localFilePath,
 * String remoteFilePath, String server, String user, String pass) throws
 * IOException { FTPClient ftpClient = new FTPClient(); try {
 * ftpClient.connect(server); ftpClient.login(user, pass);
 * ftpClient.enterLocalPassiveMode();
 * ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 * 
 * try (FileInputStream fis = new FileInputStream(localFilePath)) { boolean done
 * = ftpClient.storeFile(remoteFilePath, fis); if (done) {
 * System.out.println("The file is uploaded successfully."); } } } catch
 * (IOException ex) { ex.printStackTrace(); } finally { ftpClient.logout();
 * ftpClient.disconnect(); } } }
 * 
 */