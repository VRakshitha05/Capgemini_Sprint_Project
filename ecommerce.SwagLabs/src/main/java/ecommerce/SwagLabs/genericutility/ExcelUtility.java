package ecommerce.SwagLabs.genericutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public String readDataFromExcel(String sheetName, int row, int cell) throws Exception {

        FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        if (workbook.getSheet(sheetName) == null) {
            fis.close();
            throw new RuntimeException(
                    "Excel sheet '" + sheetName + "' not found in TestData.xlsx");
        }

        String data = workbook
                .getSheet(sheetName)
                .getRow(row)
                .getCell(cell)
                .toString();

        workbook.close();
        fis.close();

        return data;
    }
}