package com.hong.ssm.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.hong.ssm.domain.BondIssuerInfo;
import com.hong.ssm.excel.PoiUtil;
import com.hong.ssm.service.DbService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.*;

/**
 * @author wanghong
 * @date 2019/11/06 15:18
 **/
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

    @Autowired
    private DbService dbService;

    @RequestMapping(value = "export")
    public void export(HttpServletResponse response) throws IOException {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("近期公开债卷发行产品信息", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            // 这里需要设置不关闭流
           /* EasyExcel.write(response.getOutputStream(), BondIssuerInfo.class)
                    .autoCloseStream(Boolean.FALSE).sheet("近期公开债卷发行产品信息")
                    .doWrite(data());*/
            String date = "2019-11-06";
            dynamicHeadWrite(response, date);
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }

    private List<BondIssuerInfo> data() {
        List<BondIssuerInfo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BondIssuerInfo data = new BondIssuerInfo();
            data.setBondCode(i + "test");
            data.setBondYield(new BigDecimal(i + "0.88"));
            data.setShortName(i + "xx");
            data.setDefaultRate(new BigDecimal(i + "0.88"));
            data.setResidualMaturity(i + "");
            list.add(data);
        }
        return list;
    }

    /**
     * 动态头，实时生成头写入
     * <p>
     * 思路是这样子的，先创建List<String>头格式的sheet仅仅写入头,然后通过table 不写入头的方式 去写入数据
     *
     * <p>
     * 1. 创建excel对应的实体对象
     * <p>
     * 2. 然后写入table即可
     */
    private void dynamicHeadWrite(HttpServletResponse response, String date) throws IOException {
        EasyExcel.write(response.getOutputStream(), BondIssuerInfo.class)
                .autoCloseStream(Boolean.FALSE)
                // 这里放入动态头
                .head(head(date))
                .sheet("近期公开债卷发行产品信息")
                .doWrite(data());
    }

    private List<List<String>> head(String date) {
        List<List<String>> list = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("债券基本信息");
        head0.add("债券代码");
        List<String> head1 = new ArrayList<>();
        head1.add("债券基本信息");
        head1.add("债券简称");
        List<String> head2 = new ArrayList<>();
        head2.add("债券基本信息");
        head2.add("剩余期限(年)");
        List<String> head3 = new ArrayList<>();
        head3.add("YY数据(" + date + "更新)");
        head3.add("YY估值");
        List<String> head4 = new ArrayList<>();
        head4.add("YY数据(" + date + "更新");
        head4.add("YY违约率");

        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);

        return list;
    }

    @RequestMapping(value = "/poi")
    public void poi(HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = dbService.jinQiGkZjFxCpInfo("吉林市城市建设控股集团有限公司");
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        String zzDate = String.valueOf(LocalDate.now().minusDays(1));
        String yyDate = String.valueOf(LocalDate.now().minusDays(1));
        if (list.get(0).get("updateDateZz") != null) {
            zzDate = list.get(0).get("updateDateZz").toString();
        }
        if (list.get(0).get("updateDate") != null) {
            yyDate = list.get(0).get("updateDate").toString();
        }

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("近期公开债卷发行产品信息");
        for (int i = 0; i < 8; i++) {
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }
        CellStyle style = PoiUtil.getColumnTopStyle(workbook);
        List<PoiUtil.HeaderNode> nodes = new ArrayList<>();

        PoiUtil.HeaderNode headerNode1 = new PoiUtil.HeaderNode();
        headerNode1.setName("债券基本信息");
        headerNode1.setFirstRow(0);
        headerNode1.setLastRow(0);
        headerNode1.setFirstCol(0);
        headerNode1.setLastCol(2);
        nodes.add(headerNode1);

        PoiUtil.HeaderNode headerNode10 = new PoiUtil.HeaderNode();
        headerNode10.setName("债券代码");
        headerNode10.setFirstRow(1);
        headerNode10.setLastRow(1);
        headerNode10.setFirstCol(0);
        headerNode10.setLastCol(0);
        nodes.add(headerNode10);

        PoiUtil.HeaderNode headerNode11 = new PoiUtil.HeaderNode();
        headerNode11.setName("债券简称");
        headerNode11.setFirstRow(1);
        headerNode11.setLastRow(1);
        headerNode11.setFirstCol(1);
        headerNode11.setLastCol(1);
        nodes.add(headerNode11);

        PoiUtil.HeaderNode headerNode12 = new PoiUtil.HeaderNode();
        headerNode12.setName("剩余期限(年)");
        headerNode12.setFirstRow(1);
        headerNode12.setLastRow(1);
        headerNode12.setFirstCol(2);
        headerNode12.setLastCol(2);
        nodes.add(headerNode12);

        PoiUtil.HeaderNode headerNode3 = new PoiUtil.HeaderNode();
        headerNode3.setName("中债数据(" + zzDate + "更新)");
        headerNode3.setFirstRow(0);
        headerNode3.setLastRow(0);
        headerNode3.setFirstCol(3);
        headerNode3.setLastCol(5);
        nodes.add(headerNode3);

        PoiUtil.HeaderNode headerNode30 = new PoiUtil.HeaderNode();
        headerNode30.setName("隐含评级");
        headerNode30.setFirstRow(1);
        headerNode30.setLastRow(1);
        headerNode30.setFirstCol(3);
        headerNode30.setLastCol(3);
        nodes.add(headerNode30);

        PoiUtil.HeaderNode headerNode31 = new PoiUtil.HeaderNode();
        headerNode31.setName("估价净价");
        headerNode31.setFirstRow(1);
        headerNode31.setLastRow(1);
        headerNode31.setFirstCol(4);
        headerNode31.setLastCol(4);
        nodes.add(headerNode31);

        PoiUtil.HeaderNode headerNode32 = new PoiUtil.HeaderNode();
        headerNode32.setName("估值收益率(%)");
        headerNode32.setFirstRow(1);
        headerNode32.setLastRow(1);
        headerNode32.setFirstCol(5);
        headerNode32.setLastCol(5);
        nodes.add(headerNode32);

        PoiUtil.HeaderNode headerNode2 = new PoiUtil.HeaderNode();
        headerNode2.setName("YY数据(" + yyDate + "更新)");
        headerNode2.setFirstRow(0);
        headerNode2.setLastRow(0);
        headerNode2.setFirstCol(6);
        headerNode2.setLastCol(7);
        nodes.add(headerNode2);

        PoiUtil.HeaderNode headerNode20 = new PoiUtil.HeaderNode();
        headerNode20.setName("YY估值");
        headerNode20.setFirstRow(1);
        headerNode20.setLastRow(1);
        headerNode20.setFirstCol(6);
        headerNode20.setLastCol(6);
        nodes.add(headerNode20);

        PoiUtil.HeaderNode headerNode21 = new PoiUtil.HeaderNode();
        headerNode21.setName("YY违约率");
        headerNode21.setFirstRow(1);
        headerNode21.setLastRow(1);
        headerNode21.setFirstCol(7);
        headerNode21.setLastCol(7);
        nodes.add(headerNode21);

        int rowNum = PoiUtil.generateHeader(nodes, sheet, style);

        CellStyle cs = PoiUtil.getStyle(workbook);
        for (Map<String, Object> item : list) {
            Row row = sheet.createRow(rowNum++);

            Cell cell0 = row.createCell(0);
            if (item.get("bondCode") != null) {
                cell0.setCellValue(item.get("bondCode").toString());
            } else {
                cell0.setCellValue("");
            }
            cell0.setCellStyle(cs);

            Cell cell1 = row.createCell(1);
            if (item.get("shortName") != null) {
                cell1.setCellValue(item.get("shortName").toString());
            } else {
                cell1.setCellValue("");
            }
            cell1.setCellStyle(cs);

            Cell cell2 = row.createCell(2);
            if (item.get("residualMaturity") != null) {
                cell2.setCellValue(item.get("residualMaturity").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(cs);

            Cell cell3 = row.createCell(3);
            if (item.get("impliedRating") != null) {
                cell3.setCellValue(item.get("impliedRating").toString());
            } else {
                cell3.setCellValue("");
            }
            cell3.setCellStyle(cs);

            Cell cell4 = row.createCell(4);
            if (item.get("netPrice") != null) {
                cell4.setCellValue(item.get("netPrice").toString());
            } else {
                cell4.setCellValue("");
            }
            cell4.setCellStyle(cs);

            Cell cell5 = row.createCell(5);
            if (item.get("yieldRate") != null) {
                cell5.setCellValue(item.get("yieldRate").toString());
            } else {
                cell5.setCellValue("");
            }
            cell5.setCellStyle(cs);

            Cell cell6 = row.createCell(6);
            if (item.get("bondYield") != null) {
                cell6.setCellValue(item.get("bondYield").toString());
            } else {
                cell6.setCellValue("");
            }
            cell6.setCellStyle(cs);

            Cell cell7 = row.createCell(7);
            if (item.get("defaultRate") != null) {
                cell7.setCellValue(item.get("defaultRate").toString());
            } else {
                cell7.setCellValue("");
            }
            cell7.setCellStyle(cs);

        }

        String downFileName = "近期公开债卷发行产品信息.xls";
        try {
            //若不进行编码在IE下会乱码
            downFileName = URLEncoder.encode(downFileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            // 清空response
            response.reset();
            response.setContentType("application/vnd.ms-excel");//设置生成的文件类型
            response.setCharacterEncoding("UTF-8");//设置文件头编码方式和文件名
            response.setHeader("Content-Disposition", "attachment; filename=" + downFileName);
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println("文件流操作异常");
        }
    }
}
