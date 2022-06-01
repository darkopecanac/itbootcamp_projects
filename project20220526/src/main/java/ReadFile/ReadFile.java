package ReadFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
  public static void main(String[] args) {

    try {
      FileInputStream inputStream = new FileInputStream(new File("itbootcamp.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
      XSSFSheet sheet = workbook.getSheet("Test");

      CellReference cellReference = new CellReference("A1");

//      Row row = sheet.getRow(cellReference.getRow());
//      Cell cell = row.getCell(cellReference.getCol());
//      double value = cell.getNumericCellValue();
//      System.out.println(value);
      XSSFRow row = sheet.getRow(cellReference.getRow());
      XSSFCell cell = row.getCell(cellReference.getCol());

      System.out.println(cell.getRawValue());

    } catch (FileNotFoundException e) {
        System.out.println("Dokument nije pronadjen!");
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}