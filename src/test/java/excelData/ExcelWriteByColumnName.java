package excelData;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelWriteByColumnName {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\TajCh\\OneDrive\\Desktop\\testdata1.xlsx";
        String sheetName = "login";
        String columnName = "Result";   // Column Header
        int dataRowNum = 3;             // Row where data should be written
        String valueToInsert = "Passed BY name";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);

            //Get Header Row
            XSSFRow headerRow = sheet.getRow(0);
            int colIndex = -1;

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                if (headerRow.getCell(i).getStringCellValue()
                        .trim().equalsIgnoreCase(columnName)) {
                    colIndex = i;
                    break;
                }
            }

            if (colIndex == -1) {
                throw new RuntimeException("Column '" + columnName + "' not found");
            }

            //Get or Create Data Row
            XSSFRow dataRow = sheet.getRow(dataRowNum);
            if (dataRow == null) {
                dataRow = sheet.createRow(dataRowNum);
            }

            //Get or Create Cell
            XSSFCell cell = dataRow.getCell(colIndex);
            if (cell == null) {
                cell = dataRow.createCell(colIndex);
            }

            cell.setCellValue(valueToInsert);

            //Step 4: Write to Excel
            FileOutputStream fos = new FileOutputStream(filePath);
            wb.write(fos);

            fos.close();
            wb.close();
            fis.close();

            //SUCCESS MESSAGE
            System.out.println("Data inserted successfully");
            System.out.println("Value      : " + valueToInsert);
            System.out.println("Sheet Name : " + sheetName);
            System.out.println("Row Number : " + dataRowNum);
            System.out.println("Column     : " + columnName);

        } catch (Exception e) {
            System.out.println("There is an issue while inserting data");
            e.printStackTrace();
        }

	}

}
