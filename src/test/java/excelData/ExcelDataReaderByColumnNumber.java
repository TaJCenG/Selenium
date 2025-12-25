package excelData;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelDataReaderByColumnNumber {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
                "C:\\Users\\TajCh\\OneDrive\\Desktop\\testdata1.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("login");

        String text = "No Value"; // default value

        XSSFRow row = sheet.getRow(2);
        if (row != null) {
            XSSFCell cell = row.getCell(3);
            if (cell != null) {
                DataFormatter formatter = new DataFormatter();
                text = formatter.formatCellValue(cell);
            }
        }
        System.out.println(text);

        wb.close();
        fis.close();

	}

}
