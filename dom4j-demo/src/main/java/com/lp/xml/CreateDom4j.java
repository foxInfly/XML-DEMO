package com.lp.xml;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
 
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * dom4j生成xml
 * 实现步骤：
 * 第一步：创建一个Document实例:
 *       Document doc = DocumentHelper.createDocument();
 * 第二步：先添加一个根结点，然后再添加子结点，构造成一个树形结构
 *       Element root = doc.addElement("root");
 * 第三步：添加xml文件样式（也可自定义样式），并输出xml文件到指定的路径下
 *       OutputFormat format = OutputFormat.createPrettyPrint();
 *       XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
 *       writer.write(doc);
 * @author lp
 */
public class CreateDom4j {
 
    public static void main(String[] args) {
        // 执行dom4j生成xml方法
        createDom4j(new File("dom4j.xml"));
    }
	
    public static void createDom4j(File file) {
        try {
            // 1.创建一个Document实例
            Document doc = DocumentHelper.createDocument();
			
            // 2.添加根节点
            Element root = doc.addElement("root");
			
            // 3.在根节点下添加第一个子节点
            Element oneChildElement= root.addElement("person").addAttribute("attr", "root noe");
            oneChildElement.addElement("people").addAttribute("attr", "child one").addText("person one child one");
            oneChildElement.addElement("people").addAttribute("attr", "child two").addText("person one child two");
			
            // 2.在根节点下添加第二个子节点
            Element twoChildElement= root.addElement("person").addAttribute("attr", "root two");
            twoChildElement.addElement("people").addAttribute("attr", "child one").addText("person two child one");
            twoChildElement.addElement("people").addAttribute("attr", "child two").addText("person two child two");
			
            // xml格式化样式
            // OutputFormat format = OutputFormat.createPrettyPrint(); // 默认样式
			
            // 自定义xml样式
            OutputFormat format = new OutputFormat();
            format.setIndentSize(2);  // 行缩进
            format.setNewlines(true); // 一个结点为一行
            format.setTrimText(true); // 去重空格
            format.setPadText(true);
            format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行
			
            // 输出xml文件
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(doc);
            System.out.println("dom4j CreateDom4j success!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}