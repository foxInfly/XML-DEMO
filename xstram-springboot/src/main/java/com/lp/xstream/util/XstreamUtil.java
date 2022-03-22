package com.lp.xstream.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.security.*;

import java.io.File;
import java.lang.reflect.Member;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.regex.Pattern;

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