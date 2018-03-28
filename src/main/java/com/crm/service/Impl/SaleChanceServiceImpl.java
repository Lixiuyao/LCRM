package com.crm.service.Impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.SaleChance;
import com.crm.mapper.SaleChanceMapper;
import com.crm.service.ISaleChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


	@Service
	public class SaleChanceServiceImpl implements ISaleChanceService {
		@Autowired
		private SaleChanceMapper saleChanceMapper;
		
		@Override
		public DataGrideResult pageList(Integer page, Integer rows, SaleChance saleChance) {
			//1.设置分页
			PageHelper.startPage(page, rows);
			
			List<SaleChance> list = 	saleChanceMapper.pageList(saleChance);
			//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
			PageInfo pageInfo = new PageInfo<>(list);
			Integer total = (int)pageInfo.getTotal();
			return new DataGrideResult<>(total, list);
		}

		@Override
		public ServerResponse delete(String ids) {
			String[] idsArray = ids.split(",");
			int count = saleChanceMapper.deleteAll(idsArray);
			if (count == idsArray.length) {
				return ServerResponse.createSuccess("删除成功");
			}
			return ServerResponse.createError("删除失败");
		}

		@Override
		public ServerResponse insert(SaleChance saleChance) {
			int insert = saleChanceMapper.insert(saleChance);
			if (insert>0) {
				return ServerResponse.createSuccess("添加成功");
			}
			return ServerResponse.createError("添加失败");
		}

		@Override
		public ServerResponse update(SaleChance saleChance) {
			int count = saleChanceMapper.updateByPrimaryKey(saleChance);
			if (count>0) {
				return ServerResponse.createSuccess("修改成功");
			}
			return ServerResponse.createError("修改失败");
		}

		@Override
		public ServerResponse<SaleChance> selectById(Integer id) {
			SaleChance saleChance = saleChanceMapper.selectByPrimaryKey(id);
			if (saleChance != null) {
				return ServerResponse.createSuccess("查找成功", saleChance);
			}
			return ServerResponse.createError("查找失败");
		}

		@Override
		public ServerResponse updateDevResult(Integer saleChanceId, Integer devResult) {
			Integer count = saleChanceMapper.updateDevResult(saleChanceId,devResult);
			if (count>0) {
				return ServerResponse.createSuccess("修改成功");
			}
			return ServerResponse.createError("GG思密达");
		}

		@Override
		public void exportExcel(HttpServletResponse response) {
			//1.查询用户列表
			List<SaleChance> list = saleChanceMapper.selectAll();
			//2.写到excel
			// 1、创建工作簿：Workbook。
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 2、创建工作表：Sheet。
			HSSFSheet sheet = workbook.createSheet("用户列表");
			// 设置默认的列宽
			sheet.setDefaultColumnWidth(25);
			// 2.1创建合并单元格对象
			CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 6, 1, 12);
			sheet.addMergedRegion(cellRangeAddress);
			// 3、创建行：Row。
			HSSFRow rowTitle = sheet.createRow(2);
			// 4、创建单元格：Cell。
			HSSFCell cellTitle = rowTitle.createCell(1);

			HSSFCellStyle style = createStyle(workbook, 25);
			cellTitle.setCellStyle(style);
			cellTitle.setCellValue("用户列表");

			HSSFRow rowHead = sheet.createRow(7);
			/* 创建单元格 */
			String[] array = { "编号", "客户名称", "概要", "联系人" };
			for (int i = 0; i < array.length; i++) {
				HSSFCell cellHead = rowHead.createCell(i + 1);
				HSSFCellStyle headStyle = createStyle(workbook, 13);
				cellHead.setCellStyle(headStyle);
				cellHead.setCellValue(array[i]);
			}

			HSSFCellStyle styleCenter = workbook.createCellStyle();
			styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);//center horizontal alignment
			styleCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
			
			//遍历输出数据库中的数据到excel中
			for (int i = 0; i < list.size(); i++) {
				
				HSSFRow row = sheet.createRow(8 + i);
				HSSFCell cellId =  row.createCell(1);
				cellId.setCellStyle(styleCenter);
				cellId.setCellValue(list.get(i).getId());
				HSSFCell cellName =  row.createCell(2);
				cellName.setCellStyle(styleCenter);
				cellName.setCellValue(list.get(i).getCustomerName());
				HSSFCell cellDescription =  row.createCell(3);
				cellDescription.setCellStyle(styleCenter);
				cellDescription.setCellValue(list.get(i).getDescription());
				HSSFCell cellLinkman =  row.createCell(4);
				cellLinkman.setCellStyle(styleCenter);
				cellLinkman.setCellValue(list.get(i).getLinkMan());
			}
			
			response.setContentType("applicaiton/x-excel");
			// 3.以附件的形式返回给浏览器
			ServletOutputStream outputStream = null;
			try {
				response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户列表.xls".getBytes(), "ISO-8859-1"));
				outputStream = response.getOutputStream();
				workbook.write(outputStream);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 输出excel到文件
				if (workbook != null) {
					try {
						workbook.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		

		private HSSFCellStyle createStyle(HSSFWorkbook workbook, int fontSize) {
			//创建单元格样式
			HSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//center horizontal alignment
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
			//创建字体
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//字体加粗
			font.setFontHeightInPoints((short)fontSize);//设置字体大小
			//加载字体到样式
			style.setFont(font);
			return style;
		}
	}


