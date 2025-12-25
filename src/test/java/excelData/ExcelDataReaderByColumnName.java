package excelData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReaderByColumnName  {
	
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\TajCh\\OneDrive\\Desktop\\testdata1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow headerRow = sheet.getRow(0);
		
		int cellIndex = -1;
		for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            if (headerRow.getCell(i).getStringCellValue()
                    .trim().equalsIgnoreCase("DateCreated")) {
                cellIndex = i;
                break;
            }
        }// Safety check
		if (cellIndex == -1) {
            System.out.println("Column not found");
            wb.close();
            fis.close();
            return;
        }
		
		//Read DATA row
        XSSFRow dataRow = sheet.getRow(1);
        XSSFCell cell = dataRow.getCell(cellIndex);
	    DataFormatter formatter = new DataFormatter();
	    String text = formatter.formatCellValue(cell);
	   System.out.println(text);

	  wb.close();
	  fis.close();
	}

}
