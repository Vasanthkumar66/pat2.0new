package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public static HashMap<String, String> storeValues = new HashMap<>();

    public static List<HashMap<String, String>> data(String filepath, String sheetName) {

        List<HashMap<String, String>> mydata = new ArrayList<>();

        try {
            FileInputStream fs = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row HeaderRow = sheet.getRow(0);
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j);
                    switch (currentCell.getCellType()) {
                        case STRING:
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            double numericValue = currentCell.getNumericCellValue();
                            // Check if the numeric value is an integer
                            if (numericValue == (int) numericValue) {
                                currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf((int) numericValue));
                            } else {
                                currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(numericValue));
                            }
                            break;
                        case BOOLEAN:
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getBooleanCellValue()));
                            break;
                        case FORMULA:
                            switch (currentCell.getCachedFormulaResultType()) {
                                case STRING:
                                    currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    numericValue = currentCell.getNumericCellValue();
                                    if (numericValue == (int) numericValue) {
                                        currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf((int) numericValue));
                                    } else {
                                        currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(numericValue));
                                    }
                                    break;
                                case BOOLEAN:
                                    currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getBooleanCellValue()));
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Unhandled cell type");
                            break;
                    }
                }
                mydata.add(currentHash);
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mydata;
    }
}
