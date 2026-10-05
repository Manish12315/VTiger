package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private static final Date value = null;



	/**
	 * This is generic method to fetch single cell data from excel file
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getDataFromExcel(String sheetname,int rowindex,int cellindex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(IPathUtility.excelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Cell Cell=wb.getSheet(sheetname).getRow(rowindex).getCell(cellindex);
	DataFormatter df=new DataFormatter();
	String value=df.formatCellValue(Cell);
	return value;
	
}


/**
 * This is generic method to write data to Excel file
 * @param sheetName
 * @param rowIndex
 * @param cellIndex
 * @param workbook
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */

public void writeDataToExcel(String sheetName,int rowIndex,int cellIndex,String workbook) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream(IPathUtility.excelPath);
Workbook wb=WorkbookFactory.create(fis);
Cell cell=wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
cell.setCellValue(value);
FileOutputStream fos=new FileOutputStream(IPathUtility.excelPath);
wb.write(fos);
}}