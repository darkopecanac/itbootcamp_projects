package WriteFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

  public static void main(String[] args) {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Test");
    Row row = sheet.createRow(0);

    for ( int i = 0; i < 5; i++ ) {
      Cell cell  = row.createCell(i);

      cell.setCellValue(i);
    }

//    Cell cell1 = row.createCell(1);
//    cell1.setCellValue(10);

    try {
      FileOutputStream outputStream = new FileOutputStream(new File("itbootcamp.xlsx"));
      workbook.write(outputStream);

      outputStream.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}