import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;

public class ExcelValidation {
    public static void main(String[] args) throws Exception {
        //String filePath = "PRESHOW_2021-12-10_12-00-00.370_SameDay_SQLDAG_POW.xlsx";
        //String filePath = "test.xlsx";
        String filePath = "file_example_XLSX_10.xlsx";
        Workbook workbook = null;
        File xlsxFile = new File(filePath);
        if(xlsxFile.exists()){
            try {
                workbook = WorkbookFactory.create(xlsxFile);
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("File Not Found.");
            }
        }


        if(workbook != null){

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for(Cell cell : row){
                    switch (cell.getCellType()){
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case BLANK:
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case _NONE:
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            break;
                        case ERROR:
                            break;
                    }
                }
            }
            workbook.close();
        }

    }
}
