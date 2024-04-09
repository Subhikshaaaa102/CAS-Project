package utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet s;
	public static FileOutputStream file;
	public static void excelUtility() throws FileNotFoundException {
		String path = System.getProperty("user.dir")+"\\TestData\\News_Around_Cognizant.xlsx";
		file = new FileOutputStream(path);
		wb=new XSSFWorkbook();
		s=wb.createSheet("Sheet1");
	}
	
	public static void output(List<String> aroundCognizant, List<String> seeAll, List<String> newsDesc) throws FileNotFoundException {
		ExcelUtility.excelUtility();
		XSSFRow row1 = s.createRow(0);
		row1.createCell(0).setCellValue("Around Cognizant News Header");
		for(int row=1; row<7; row++) {
			XSSFRow rows = s.createRow(row);
			rows.createCell(0).setCellValue(aroundCognizant.get(row-1));
		}
		
		XSSFRow row2 = s.createRow(10);
		row2.createCell(0).setCellValue("See All News Header");
		for(int row=11; row<16; row++) {
			XSSFRow rows = s.createRow(row);
			rows.createCell(0).setCellValue(seeAll.get(row-11));
		}
		
		XSSFRow row3 = s.createRow(18);
		row3.createCell(0).setCellValue("News");
		for(int row=19; row<24; row++) {
			XSSFRow rows = s.createRow(row);
			rows.createCell(0).setCellValue(newsDesc.get(row-19));
		}
		
	}
	
	public static void closeExcel() throws IOException {
		wb.write(file);
		wb.close();
		file.close();
	}
}
