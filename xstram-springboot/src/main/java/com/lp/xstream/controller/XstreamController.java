package com.lp.xstream.controller;

import com.lp.xstream.bean.City;
import com.lp.xstream.bean.CityList;
import com.lp.xstream.util.XstreamUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("xstream")
public class XstreamController {

    //http://localhost:8080/xstream/xstream/listCity
    @GetMapping("listCity")
    public List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("city.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) !=null) {
            buffer.append(line);
        }
        br.close();
        // XML转为Java对象
        CityList cityList = (CityList) XstreamUtil.toBean(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
