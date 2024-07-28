package StepDefinition;




import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static final String FILE_PATH = "src/test/resources/testdata.xlsx";

    public static String getData(int sheetNumber, int rowNumber, int cellNumber) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        String data = cell.getStringCellValue();
        workbook.close();
        return data;
    }
}

