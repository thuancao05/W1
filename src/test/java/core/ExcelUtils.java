package core;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelUtils {
    private static XSSFSheet ExcelSheet;
    private static XSSFWorkbook xssfWorkbook;

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            xssfWorkbook = new XSSFWorkbook(ExcelFile);
            ExcelSheet = xssfWorkbook.getSheet(SheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = ExcelSheet.getLastRowNum();
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols + startCol; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    private static String getCellData(int rowIndex, int colIndex) {
        DataFormatter formatter = new DataFormatter();
        XSSFCell cell;
        try {
            cell = ExcelSheet.getRow(rowIndex).getCell(colIndex);
            if (cell == null) {
                return "";
            } else {
                return formatter.formatCellValue(cell);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void writeHeadingExcelFile() throws IOException{
        XSSFWorkbook xssfWorkbook2 = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook2.createSheet("Test result");
        Row row = xssfSheet.createRow(0);
        xssfSheet.setColumnWidth(0,16900);
        row.createCell(0).setCellValue("Test case");
        row.createCell(1).setCellValue("Result");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/testResult.xlsx");
            xssfWorkbook2.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeAppendExcelFile(String testcase, String result) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/testResult.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Test result");
        int lastRow = xssfSheet.getLastRowNum();
        Row row = xssfSheet.createRow(lastRow + 1);
        row.createCell(0).setCellValue(testcase);
        row.createCell(1).setCellValue(result);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/testResult.xlsx");
            xssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
