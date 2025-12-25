package excelData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataWriterByColumnNumber {

	public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\TajCh\\OneDrive\\Desktop\\testdata1.xlsx";
        String sheetName = "login";
        int rowNum = 3;
        int colNum = 4;
        String valueToInsert = "Passed";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);

            // Get or create row
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            // Get or create cell
            XSSFCell cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }

            cell.setCellValue(valueToInsert);

            FileOutputStream fos = new FileOutputStream(filePath);
            wb.write(fos);

            fos.close();
            wb.close();
            fis.close();
            
            System.out.println("Data inserted successfully");
            System.out.println("Value      : " + valueToInsert);
            System.out.println("Sheet Name : " + sheetName);
            System.out.println("Row Number : " + rowNum);
            System.out.println("Column No  : " + colNum);

        } catch (Exception e) {
            System.out.println("There is an issue while inserting data");
            e.printStackTrace();
        }
	}
}
