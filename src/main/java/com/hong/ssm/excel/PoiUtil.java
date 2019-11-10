package com.hong.ssm.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PoiUtil {
    private PoiUtil() {
    }

    /**
     * Excel2003和Excel2007+创建方式不同
     * Excel2003使用HSSFWorkbook 后缀xls
     * Excel2007+使用XSSFWorkbook 后缀xlsx
     * 此方法可保证动态创建Workbook
     *
     * @param is
     * @return
     */
    public static Workbook createWorkbook(InputStream is) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(is);
    }

    /**
     *导入数据获取数据列表
     * @param wb
     * @return
     */
    public static List<List<Object>> getDataList(Workbook wb) {
        List<List<Object>> rowList = new ArrayList<>();
        for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = wb.getSheetAt(sheetNum);
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (null == row)
                    continue;
                List<Object> cellList = new ArrayList<>();
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    cellList.add(getCellValue(cell));
                }
                rowList.add(cellList);
            }
        }
        return rowList;
    }

    private static String getCellValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC: {
                    short format = cell.getCellStyle().getDataFormat();
                    if (format == 14 || format == 31 || format == 57 || format == 58) {   //excel中的时间格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil.getJavaDate(value);
                        cellvalue = sdf.format(date);
                    }
                    // 判断当前的cell是否为Date
                    else if (HSSFDateUtil.isCellDateFormatted(cell)) {  //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                        // 如果是Date类型则，取得该Cell的Date值           // 对2014-02-02格式识别不出是日期格式
                        Date date = cell.getDateCellValue();
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = formater.format(date);
                    } else { // 如果是纯数字
                        // 取得当前Cell的数值
                        cellvalue = NumberToTextConverter.toText(cell.getNumericCellValue());

                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getStringCellValue().replaceAll("'", "''");
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    cellvalue = null;
                    break;
                // 默认的Cell值
                default: {
                    cellvalue = " ";
                }
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    /**
     * 此方法生成表头并写入表头名称
     *
     * @param nodes 节点
     * @param sheet 工作簿
     * @param style 单元格样式
     * @return 数据加载开始行
     */
    public static int generateHeader(List<HeaderNode> nodes, Sheet sheet, CellStyle style) {
        Map<RowKey, Row> hssfRowMap = new HashMap<>();
        int dataStartRow = 0;
        for (HeaderNode node : nodes) {
            if (!(node.firstRow == node.getLastCol() || node.getFirstCol() == node.getLastCol())) {
                CellRangeAddress cra = new CellRangeAddress(node.getFirstRow(), node.getLastRow(),
                        node.getFirstCol(), node.getLastCol());
                sheet.addMergedRegion(cra);
            }
            dataStartRow = dataStartRow >= node.getLastRow() ? dataStartRow : node.getLastRow();
            RowKey key = new RowKey();
            key.setFirstRow(node.getFirstRow());
            key.setLastRow(node.getLastRow());
            Row row = hssfRowMap.get(key);
            if (null == row) {
                row = sheet.createRow(node.getFirstRow());
                hssfRowMap.put(key, row);
            }
            Cell cell = row.createCell(node.getFirstCol());
            cell.setCellValue(node.getName());
            cell.setCellStyle(style);
        }
        return dataStartRow+1;
    }

    public static class HeaderNode {
        private String name;
        private int firstRow;
        private int lastRow;
        private int firstCol;
        private int lastCol;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFirstRow() {
            return firstRow;
        }

        public void setFirstRow(int firstRow) {
            this.firstRow = firstRow;
        }

        public int getLastRow() {
            return lastRow;
        }

        public void setLastRow(int lastRow) {
            this.lastRow = lastRow;
        }

        public int getFirstCol() {
            return firstCol;
        }

        public void setFirstCol(int firstCol) {
            this.firstCol = firstCol;
        }

        public int getLastCol() {
            return lastCol;
        }

        public void setLastCol(int lastCol) {
            this.lastCol = lastCol;
        }
    }

    private static class RowKey {
        private int firstRow;
        private int lastRow;

        public int getFirstRow() {
            return firstRow;
        }

        public void setFirstRow(int firstRow) {
            this.firstRow = firstRow;
        }

        public int getLastRow() {
            return lastRow;
        }

        public void setLastRow(int lastRow) {
            this.lastRow = lastRow;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RowKey)) return false;
            RowKey key = (RowKey) o;
            return firstRow == key.firstRow &&
                    lastRow == key.lastRow;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstRow, lastRow);
        }
    }

    /**
     * 设置列头单元格样式
     * @param workbook
     * @return
     */
    public static CellStyle getColumnTopStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        font.setColor(IndexedColors.BLACK.getIndex());
        // 字体加粗
        font.setBold(true);
        // 设置字体名字
        font.setFontName("Courier New");

        // 设置样式;
        CellStyle style = workbook.createCellStyle();
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        // 设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        // 设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;
    }

    /**
     *  设置列数据信息单元格样式
     * @param workbook
     * @return
     */
    public static CellStyle getStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short)10);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        CellStyle style = workbook.createCellStyle();
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        // 设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        // 设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

  /*  public static void main(String[] args) {
         // 第一步，创建一个webbook，对应一个Excel文件
        // XSSFWorkbook针对于excel2007+
        // HSSFWorkbook针对于Excel2003(数据超过65536会报错)
        Workbook workbook = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        Sheet sheet = workbook.createSheet("近期公开债卷发行产品信息");
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 水平居中格式
        style.setVerticalAlignment(VerticalAlignment.CENTER); //垂直居中
        List<HeaderNode> nodes = new ArrayList<>();

        HeaderNode headerNode1 = new HeaderNode();
        headerNode1.setName("债券基本信息");
        headerNode1.setFirstRow(0);
        headerNode1.setLastRow(0);
        headerNode1.setFirstCol(0);
        headerNode1.setLastCol(2);
        nodes.add(headerNode1);

        HeaderNode headerNode10 = new HeaderNode();
        headerNode10.setName("债券代码");
        headerNode10.setFirstRow(1);
        headerNode10.setLastRow(1);
        headerNode10.setFirstCol(0);
        headerNode10.setLastCol(0);
        nodes.add(headerNode10);

        HeaderNode headerNode11 = new HeaderNode();
        headerNode11.setName("债券简称");
        headerNode11.setFirstRow(1);
        headerNode11.setLastRow(1);
        headerNode11.setFirstCol(1);
        headerNode11.setLastCol(1);
        nodes.add(headerNode11);

        HeaderNode headerNode12 = new HeaderNode();
        headerNode12.setName("剩余期限(年)");
        headerNode12.setFirstRow(1);
        headerNode12.setLastRow(1);
        headerNode12.setFirstCol(2);
        headerNode12.setLastCol(2);
        nodes.add(headerNode12);

        String date = "2019-11-10";
        HeaderNode headerNode2 = new HeaderNode();
        headerNode2.setName("YY数据(" + date + "更新)");
        headerNode2.setFirstRow(0);
        headerNode2.setLastRow(0);
        headerNode2.setFirstCol(3);
        headerNode2.setLastCol(4);
        nodes.add(headerNode2);

        HeaderNode headerNode20 = new HeaderNode();
        headerNode20.setName("YY估值");
        headerNode20.setFirstRow(1);
        headerNode20.setLastRow(1);
        headerNode20.setFirstCol(3);
        headerNode20.setLastCol(3);
        nodes.add(headerNode20);

        HeaderNode headerNode21 = new HeaderNode();
        headerNode21.setName("YY违约率");
        headerNode21.setFirstRow(1);
        headerNode21.setLastRow(1);
        headerNode21.setFirstCol(4);
        headerNode21.setLastCol(4);
        nodes.add(headerNode21);

        generateHeader(nodes, sheet, style);
        try {
           // 直接将将文件保存在本地，供测试样式使用
            FileOutputStream output = new FileOutputStream("G:\\workbook.xls");
            workbook.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
