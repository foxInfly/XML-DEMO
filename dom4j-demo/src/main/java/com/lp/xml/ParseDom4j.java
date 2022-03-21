package com.lp.xml;
 
import java.io.File;
import java.util.Iterator;
import java.util.List;
 
import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
 
/**
 * dom4j解析xml
 * 实现步骤：
 *
 * 第一步：创建一个SAXReader解析器：
 *       SAXReader reader = new SAXReader();
 * 第二步：解析xml文件，重新构建成一个Document对象
 *       Document doc = reader.read(file);
 * 第三步：处理Document对象信息，在控制台打印
 * @author ouyangjun
 */
public class ParseDom4j {
 
    public static void main(String[] args) {
        // 执行dom4j解析xml方法
        parseDom4j(new File("dom4j.xml"));
    }
	
    public static void parseDom4j(File file) {
        try {
            // 1.创建一个SAXReader解析器
            SAXReader reader = new SAXReader();
			
            // 2.读取xml文件,转换成Document结点
            Document doc = reader.read(file);
 
            // 3.递归打印xml文档信息
            StringBuffer buffer = new StringBuffer();
            parseElement(doc.getRootElement(), buffer);
            System.out.println(buffer);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
	
    public static void parseElement(Element element, StringBuffer buffer) {
        buffer.append("<").append(element.getName());
        List<Attribute> attrs = element.attributes();
        if (attrs != null) {
            for (Attribute attr : attrs) {
                buffer.append(" ").append(attr.getName()).append("=\"").append(attr.getValue()).append("\"");
            }
        }
        buffer.append(">");
        
        Iterator<Node> iterator = element.nodeIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node instanceof Element) {
                Element eleNode = (Element) node;
                parseElement(eleNode, buffer);
            }
            if (node instanceof Text) {
                Text text = (Text) node;
                buffer.append(text.getText());
            }
            if (node instanceof CDATA) {
                CDATA dataNode = (CDATA) node;
                buffer.append(dataNode.getText());
            }
            if (node instanceof Comment) {
                Comment comNode = (Comment) node;
                buffer.append(comNode.getText());
            }
        }
        buffer.append("</"+element.getName()+">");
    }
}