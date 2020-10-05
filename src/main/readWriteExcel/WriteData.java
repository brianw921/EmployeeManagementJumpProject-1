package main.readWriteExcel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import main.models.Department;
import main.models.Employee;
import jxl.write.Number;

public class WriteData {
	
	private static File file = new File("resources/data.xls");
	
	private static WritableWorkbook workbook;
	private static WritableSheet empSheet;
	private static WritableSheet deptSheet;
	
	
	public static void createFile(List<Employee> employees, List<Department> departments) throws IOException, WriteException {
		//if there is no workbook, then create it
		
		if (!file.exists()) {
			workbook = Workbook.createWorkbook(file);
			
			//create header formatting
			empSheet = workbook.createSheet("Employees", 0);
			WritableCellFormat headerFormat = new WritableCellFormat();
			WritableFont font = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD);
			headerFormat.setFont(font);
			headerFormat.setBackground(Colour.LIGHT_BLUE);
			headerFormat.setWrap(true);
			
			//header label for Employees sheet
			Label headerLabel = new Label (0, 0, "ID", headerFormat);
			empSheet.setColumnView(0, 10);
			empSheet.addCell(headerLabel);
			
			headerLabel = new Label(1, 0, "Name", headerFormat);
			empSheet.setColumnView(1, 60);
			empSheet.addCell(headerLabel);
			
			headerLabel = new Label(2, 0, "Title", headerFormat);
			empSheet.setColumnView(2, 60);
			empSheet.addCell(headerLabel);
			
			headerLabel = new Label(3, 0, "Department ID", headerFormat);
			empSheet.setColumnView(3, 60);
			empSheet.addCell(headerLabel);
			
			headerLabel = new Label(4, 0, "Salary", headerFormat);
			empSheet.setColumnView(4, 60);
			empSheet.addCell(headerLabel);
			
			//format data cells
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setWrap(true);
			
			//add first line
			for(Employee employee : employees) {
				try {
					addEmployee(employee);
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Number cellNumber = new Number(0, 1, 1, cellFormat);
//			empSheet.addCell(cellNumber);
			Label cellLabel;// =  new Label(1, 1, "Kingsley", cellFormat);
//			empSheet.addCell(cellLabel);
//			cellLabel = new Label(2, 1, "Shacklebot", cellFormat);
//			empSheet.addCell(cellLabel);
//			cellNumber = new Number(3, 1, 1, cellFormat);
//			empSheet.addCell(cellNumber);
//			
			//create department sheet and header labels
			deptSheet = workbook.createSheet("Departments", 1);
			headerLabel = new Label (0, 0, "Deptarment ID", headerFormat);
			deptSheet.addCell(headerLabel);
			headerLabel = new Label(1, 0, "Department Name", headerFormat);
			deptSheet.addCell(headerLabel);
			
			//Add department information
			cellNumber = new Number(0, 1, 1, cellFormat);
			deptSheet.setColumnView(0, 10);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 1, "Minister for Magic and Support Staff", cellFormat);
			deptSheet.setColumnView(1, 100);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 2, 2, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 2, "Department of Magical Law Enforcement", cellFormat);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 3, 3, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 3, "Department of Magical Accidents and Catastrophes", cellFormat);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 4, 4, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 4, "Department for the Regulation and Control of Magical Creatures", cellFormat);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 5, 5, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 5, "Department of International Magical Cooperation", cellFormat);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 6, 6, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 6, "Department of Magical Transportation", cellFormat);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 7, 7, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 7, "Department of Magical Games and Sports", cellFormat);
			deptSheet.addCell(cellLabel);
			
			cellNumber = new Number(0, 8, 8, cellFormat);
			deptSheet.addCell(cellNumber);
			cellLabel = new Label(1, 8, "Department of Mysteries", cellFormat);
			deptSheet.addCell(cellLabel);			
			
			workbook.write();
			workbook.close();
		}
	}
	
	public static void addEmployee(Employee employee) throws WriteException, IOException, BiffException {
		//find last row and go to the next one
//		workbook = Workbook.createWorkbook(file);
		empSheet = workbook.getSheet(0);
		int newRow = empSheet.getRows();
		//format data cells
		WritableCellFormat cellFormat = new WritableCellFormat();
		cellFormat.setWrap(true);
		
			//add new employee entry in the new row
		Number cellNumber = new Number(0, newRow, employee.getId(), cellFormat);
		empSheet.addCell(cellNumber);
		Label cellLabel = new Label(1, newRow, employee.getName(), cellFormat);
		empSheet.addCell(cellLabel);
		cellLabel = new Label(2, newRow, employee.getTitle(), cellFormat);
		empSheet.addCell(cellLabel);
		cellNumber = new Number(3, newRow, employee.getDepartmentId(), cellFormat);
		empSheet.addCell(cellNumber);
		cellNumber = new Number(4, newRow, employee.getSalary(), cellFormat);
		empSheet.addCell(cellNumber);		
		
	}

}
