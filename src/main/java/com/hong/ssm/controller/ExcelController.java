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
            EasyExcel.write(response.getOutputStream(), BondIssuerInfo.class)
                    .autoCloseStream(Boolean.FALSE).sheet("近期公开债卷发行产品信息")
                    .doWrite(data());
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

}
