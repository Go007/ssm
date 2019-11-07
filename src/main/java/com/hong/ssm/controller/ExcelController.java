package com.hong.ssm.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.hong.ssm.domain.BondIssuerInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author wanghong
 * @date 2019/11/06 15:18
 **/
@RestController
@RequestMapping(value = "/excel")
public class ExcelController {

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
           dynamicHeadWrite(response,date);
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
            data.setBondYield(new BigDecimal(i));
            data.setShortName(i + "xx");
            data.setDefaultRate(new BigDecimal(i));
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
    private void dynamicHeadWrite(HttpServletResponse response,String date) throws IOException {
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
}
