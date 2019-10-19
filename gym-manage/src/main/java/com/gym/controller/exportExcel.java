package com.gym.controller;



import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.dao.SysEmployeeDao;
import com.gym.entity.SysEmployee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class exportExcel {
	@Autowired
	private SysEmployeeDao sysEmployeeDao;
    @RequestMapping("/excelEmpExport")
    @ResponseBody
    public void excelExport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //开始模拟获取数据，实际应该在数据库查出来
    	List<SysEmployee> list2 = sysEmployeeDao.findAllObject();
        //List<SysEmployee> list = new ArrayList<>();
		/*
		 * list.add(new SysEmployee(1, "从前", "男", 20, "430381199904122613", "大专", "董事会",
		 * "董事长", 50000, "2019-09-19")); list.add(new SysEmployee(2, "叶昊之", "男", 20,
		 * "430381199904122613", "大专", "董事会", "董事长", 50000, "2019-09-19")); list.add(new
		 * SysEmployee(3, "大哥", "男", 20, "430381199904122613", "大专", "董事会", "董事长",
		 * 50000, "2019-09-19"));
		 */
//EXCEL表导出核心代码
        //   声明一个Excel
        HSSFWorkbook wb=null;
        //title代表的是你的excel表开头每列的名字
        String[] title =new String[]{"id","姓名","性别","年龄","身份证","学历","部门","职位","薪资","入职时间"};
        String name="测试";
        //excel文件名
        String fileName = name+".xls";
        //sheet名
        String sheetName = name+"表";
        //二维数组铺满整个Excel
        String[][] content = new String[list2.size()][title.length];
        //--------------------------------------------------------------------------------------------
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        //设置背景色
        //style.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //设置边框
        //style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置居右
        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//水平居右
        style.setVerticalAlignment(HSSFCellStyle.ALIGN_RIGHT);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        //设置字体
        HSSFFont font=wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 8);//设置字体大小
        HSSFFont font2=wb.createFont();
        font2.setFontName("仿宋_GB2312");
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font2.setFontHeightInPoints((short) 12);
        style.setFont(font);//选择需要用到的字体格式
        //设置列宽
        sheet.setColumnWidth(0, 4567);//第一个参数代表列id（从0开始），第二个参数代表宽度值
        sheet.setColumnWidth(1, 4567);//第一个参数代表列id（从1开始），第二个参数代表宽度值
        sheet.setColumnWidth(2, 4567);//第一个参数代表列id（从2开始），第二个参数代表宽度值
        sheet.setColumnWidth(3, 4567);//第一个参数代表列id（从3开始），第二个参数代表宽度值
        sheet.setColumnWidth(4, 8000);//第一个参数代表列id（从4开始），第二个参数代表宽度值
        sheet.setColumnWidth(5, 4567);
        sheet.setColumnWidth(6, 4567);
        sheet.setColumnWidth(7, 4567);
        sheet.setColumnWidth(8, 4567);
        sheet.setColumnWidth(9, 6000);
        style.setWrapText(true);//设置自动换行
        //加边框
        HSSFCellStyle cellStyle=wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //把list放进content里
        for (int i = 0; i < list2.size(); i++) {
            content[i] = new String[title.length];
            SysEmployee obj = list2.get(i);
            content[i][4] = obj.getIdNumber();
            content[i][6] = obj.getDepartment();
            content[i][2] = obj.getGender();
            content[i][9] = obj.getHiredate();
            content[i][5] = obj.getEduBackground();
            content[i][1] = obj.getName();
            content[i][7] = obj.getPosition();
            content[i][3] = obj.getAge().toString();
            content[i][8] = obj.getSalary().toString();
            content[i][0] = obj.getId().toString();
        }
        //添加数据进入excel
        for(int i=0;i<content.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<content[i].length;j++){
          //将内容按顺序赋给对应的列对象
                HSSFCell cel = row.createCell(j);
                cel.setCellValue(content[i][j]);
            } }
        //响应到客户端
        try {
            try {
                try {
                    fileName = new String(fileName.getBytes(),"ISO8859-1");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

