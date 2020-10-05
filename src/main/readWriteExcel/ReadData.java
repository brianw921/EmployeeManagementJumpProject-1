package main.readWriteExcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class ReadData {
	
	
	//Read through each sheet's data
	public Map<Integer, List<String>> readJExcel(String fileLocation)
		throws IOException, BiffException{
		Map<Integer, List<String>> data = new HashMap<>();
		
		Workbook workbook = Workbook.getWorkbook(new File(fileLocation));
		Sheet empSheet = workbook.getSheet(0);
		int rows = empSheet.getRows();
		int columns = empSheet.getColumns();
		
		for (int i = 0; i < rows; i++) {
			data.put(i, new ArrayList<String>());
			for (int j = 0; j < columns; j++) {
				data.get(i)
					.add(empSheet.getCell(j, i)
					.getContents());
			}
		}
		
		Sheet deptSheet = workbook.getSheet(1);
		rows = deptSheet.getRows();
		columns = deptSheet.getColumns();
		
		for (int i = 0; i < rows; i++) {
			data.put(i, new ArrayList<String>());
			for (int j = 0; j < columns; j++) {
				data.get(i)
					.add(deptSheet.getCell(j, i)
					.getContents());
			}
		}
		
		return data;
	}
	

	
	
	
}
