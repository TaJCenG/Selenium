package excelData;

public class MajorMinorProg {

	private static final String FILE_PATH = "C:\\Users\\TajCh\\OneDrive\\Desktop\\data.xlsx";
	private static final String SHEET_NAME = "People";

    private static final int NAME_COL = 0;
    private static final int AGE_COL = 1;
    private static final int STATUS_COL = 2;
    private static final int ADULT_AGE = 18;

    public static void main(String[] args) throws Exception {

        ExcelAPI excelApi = new ExcelAPI(FILE_PATH);

        int rowCount = excelApi.getRowCount(SHEET_NAME);

        // Start from row 1 (skip header)
        for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {

            String name = excelApi.getCellData(SHEET_NAME, rowIndex, NAME_COL);
            String ageValue = excelApi.getCellData(SHEET_NAME, rowIndex, AGE_COL);

            if (ageValue == null || ageValue.trim().isEmpty()) {
                System.out.println("Row " + rowIndex + " : Age missing for " + name);
                continue;
            }

            int age = (int) Double.parseDouble(ageValue.trim());


            if (age >= ADULT_AGE) {
                excelApi.setCellData(SHEET_NAME, rowIndex, STATUS_COL, "MAJOR");
                System.out.println(
                        "Name: " + name + " | Age: " + age + " → Status: MAJOR");
            } else {
                excelApi.setCellData(SHEET_NAME, rowIndex, STATUS_COL, "MINOR");
                System.out.println(
                        "Name: " + name + " | Age: " + age + " → Status: MINOR");
            }
        }
    
	}

}
