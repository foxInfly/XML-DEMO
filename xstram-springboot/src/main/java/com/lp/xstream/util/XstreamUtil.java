package com.lp.xstream.util;

import com.thoughtworks.xstream.XStream;

public class XstreamUtil {
    public static Object toBean(Class<?> clazz, String xml) {
        Object xmlObject;
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        xstream.autodetectAnnotations(true);
        xmlObject = xstream.fromXML(xml);
        return xmlObject;
    }
}