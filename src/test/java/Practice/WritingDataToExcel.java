package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class WritingDataToExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\Recursion\\com.crm.VTIGER\\src\\test\\java\\Practice\\FetchingDataFromExcelFile.java");
    Workbook wb=WorkbookFactory.create(fis);
    Cell cell= (Cell) wb.getSheet("Flowers").getRow(4).getCell(3);
    ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue("Rosy");
    FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\Recursion\\com.crm.VTIGER\\src\\test\\java\\Practice\\FetchingDataFromExcelFile.java");
    wb.write(fos);
    
}
}
