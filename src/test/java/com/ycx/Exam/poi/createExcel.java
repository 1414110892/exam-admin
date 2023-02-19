package com.ycx.Exam.poi;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class createExcel {

	//桌面生成excel文件
	public static void createExcel() throws IOException {
		// 获取桌面路径
		FileSystemView fsv = FileSystemView.getFileSystemView();
		String desktop = fsv.getHomeDirectory().getPath();
		String filePath = desktop + "/template.xls";

		File file = new File(filePath);
		OutputStream outputStream = new FileOutputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("单选题");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("年级");
		row.createCell(1).setCellValue("学科");
		row.createCell(2).setCellValue("知识点");
		row.createCell(3).setCellValue("题干");
		row.createCell(4).setCellValue("选项A");
		row.createCell(5).setCellValue("选项B");
		row.createCell(6).setCellValue("选项C");
		row.createCell(7).setCellValue("选项D");
		row.createCell(8).setCellValue("选项E");
		row.createCell(9).setCellValue("选项F");
		row.createCell(10).setCellValue("选项G");
		row.createCell(11).setCellValue("选项H");
		row.createCell(11).setCellValue("解析");
		row.createCell(11).setCellValue("分数");
		row.createCell(11).setCellValue("选项H");
		row.createCell(11).setCellValue("选项H");
		row.setHeightInPoints(30); // 设置行的高度

		HSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("1");
		row1.createCell(1).setCellValue("NO00001");

//		// 日期格式化
//		HSSFCellStyle cellStyle2 = workbook.createCellStyle();
//		HSSFCreationHelper creationHelper = workbook.getCreationHelper();
//		cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
//		sheet.setColumnWidth(2, 20 * 256); // 设置列的宽度
//
//		HSSFCell cell2 = row1.createCell(2);
//		cell2.setCellStyle(cellStyle2);
//		cell2.setCellValue(new Date());
//
//		row1.createCell(3).setCellValue(2);
//
//
//		// 保留两位小数
//		HSSFCellStyle cellStyle3 = workbook.createCellStyle();
//		cellStyle3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
//		HSSFCell cell4 = row1.createCell(4);
//		cell4.setCellStyle(cellStyle3);
//		cell4.setCellValue(29.5);
//
//
//		// 货币格式化
//		HSSFCellStyle cellStyle4 = workbook.createCellStyle();
//		HSSFFont font = workbook.createFont();
//		font.setFontName("华文行楷");
//		font.setFontHeightInPoints((short)15);
//		font.setColor(HSSFColor.RED.index);
//		cellStyle4.setFont(font);
//
//		HSSFCell cell5 = row1.createCell(5);
//		cell5.setCellFormula("D2*E2");  // 设置计算公式
//
//		// 获取计算公式的值
//		HSSFFormulaEvaluator e = new HSSFFormulaEvaluator(workbook);
//		cell5 = e.evaluateInCell(cell5);
//		System.out.println(cell5.getNumericCellValue());


		workbook.setActiveSheet(0);
		workbook.write(outputStream);
		outputStream.close();
	}

	//读取Excel，解析数据
	public static void readExcel() throws IOException{
		String filePath = "E:\\毕设\\ycx\\ExamSys\\src\\main\\java\\com\\ycx\\Exam\\file\\11.xlsx";

		FileInputStream fileInputStream = new FileInputStream(filePath);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
		HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
		HSSFSheet sheet = workbook.getSheet("单选题");

		int lastRowIndex = sheet.getLastRowNum();
		System.out.println(lastRowIndex);
		for (int i = 0; i <= lastRowIndex; i++) {
			HSSFRow row = sheet.getRow(i);
			if (row == null) { break; }

			short lastCellNum = row.getLastCellNum();
			for (int j = 0; j < lastCellNum; j++) {
				String cellValue = row.getCell(j).getStringCellValue();
				System.out.println(cellValue);
			}
		}


		bufferedInputStream.close();
	}

}