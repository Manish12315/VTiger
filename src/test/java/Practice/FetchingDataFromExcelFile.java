package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

import genericUtility.ExcelUtility;

public class FetchingDataFromExcelFile {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	ExcelUtility eutility=new ExcelUtility();
	String value1=eutility.getDataFromExcel("Animal",4, 4);
	System.out.println(value1);
	String value2=eutility.getDataFromExcel("Flowers", 3, 5);
	System.out.println(value2);
	String value3=eutility.getDataFromExcel("Actors", 2, 2);
	System.out.println(value3);
}
}