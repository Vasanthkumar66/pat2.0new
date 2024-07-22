package utilities;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import factory.BaseClass;

public class DataWriter {
	public static String filePath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static List<String> emailID;
	public static List<String> phoneno;

	public static void data(String path) throws IOException {

		filePath = path;
		FileInputStream fileInputStream = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheetAt(1); // Assuming you want to update the first sheet

		

		int emailColumnIndex = 9; // Assuming email is in the 10th column (index 9)
		int phoneColumnIndex = 12; // Assuming phone number is in the 13th column (index 12)

		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Loop through rows 1 to 5 (assuming 0 is header row)
			Row row = sheet.getRow(i);

			if (row != null) {

				

				// email details
				Cell emailCell = row.getCell(emailColumnIndex);
				if (emailCell == null) {
					emailCell = row.createCell(emailColumnIndex);
				}
				switch (i) {
				case 22:
					emailCell.setCellValue("");
					break;
				case 23:
					emailCell.setCellValue("vasanth@");
					break;
				case 24:
					emailCell.setCellValue("vasanth@examly.in");
					break;
				default:
					emailCell.setCellValue(BaseClass.randomeString() + "@examly.in"); // New email value
					System.out.println("email updated");
					break;
				}
				

				
				// phone no details
				Cell phoneCell = row.getCell(phoneColumnIndex);
				if (phoneCell == null) {
					phoneCell = row.createCell(phoneColumnIndex);
				}
				
				switch (i) {
				case 29:
					phoneCell.setCellValue("");
					break;
				case 30:
					phoneCell.setCellValue("9809");
					break;
				case 31:
					phoneCell.setCellValue("7708492878");
					break;
				default:
					phoneCell.setCellValue(BaseClass.randomeNumber(10)); // New phone number value
					System.out.println("phone no updated");
					break;
				}
				
				
			}
		}

		FileOutputStream fileOutputStream = new FileOutputStream(filePath);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		workbook.close();

		/*
		 * FileInputStream fileInputStream1 = new FileInputStream(filePath); Workbook
		 * verifyWorkbook = new XSSFWorkbook(fileInputStream1); Sheet verifySheet =
		 * verifyWorkbook.getSheetAt(0);
		 * 
		 * for (int i = 1; i <= 5; i++) { Row row = verifySheet.getRow(i); if (row !=
		 * null) { Cell emailCell = row.getCell(9); Cell phoneCell = row.getCell(12);
		 * assertTrue(emailCell.getStringCellValue().equals("updated_email@example.com")
		 * ); assertTrue(phoneCell.getStringCellValue().equals("1234567890")); } }
		 * 
		 * verifyWorkbook.close(); }
		 */

	}
}
