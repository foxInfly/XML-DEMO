package com.lp.jaxb.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {
    /**
     * 将XML转为指定的POJO
     * @param clazz 要转换的clazz
     * @param xmlStr 对应的xml
     */
    public static Object xmlStrToOject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject;
        Reader reader;
        JAXBContext context = JAXBContext.newInstance(clazz);
        // XML 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        //以文件流的方式传入这个string
        xmlObject = unmarshaller.unmarshal(reader);
        reader.close();
        return xmlObject;
    }
}