package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestExcell {

    public static void main(String[] args) throws IOException {

        File file = new File("src\\test\\resources\\data\\TestData.xlsx");
        System.out.println(file.exists());

        FileInputStream input = new FileInputStream(file); //

        Workbook book = new XSSFWorkbook(input); // it is reading the Excelfile
        Sheet sheet = book.getSheet("Sheet1");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(0);
        System.out.println(cell);
        System.out.println(sheet.getRow(2).getCell(1));
        System.out.println(sheet.getRow(2).getCell(3));
        Cell cell2 = sheet.getRow(2).getCell(3);
        cell2.setCellValue("PASS");

     //   sheet.createRow(2).createCell(4);
        sheet.getRow(2).createCell(4).setCellValue("8/5/2020");
        sheet.getRow(1).createCell(4).setCellValue("2/3/2019");
        sheet.getRow(3).createCell(4).setCellValue("2/3/2019");
        sheet.getRow(4).createCell(4).setCellValue("2/3/2019");

        FileOutputStream output = new FileOutputStream(file); // Change the file put the file all the uptades we just make we need to insert to the file
        book.write(output);
        output.close();

    }
}
