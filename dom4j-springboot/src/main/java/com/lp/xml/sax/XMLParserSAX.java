package com.lp.xml.sax;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.List;

/**
 * XMLParserSAX.java：解析XML文件并写入到List<Book>集合，
 * 这样做的好处是实现了将任意平台都能处理的XML数据转化为了Java能处理的对象，
 * 方便在Java或Android开发中的后续数据处理，比如说：在Android中，从服务器上获取到XML文件，通过该方法解析数据并存入到对象，
 * 再将该对象绑定到适配器用于Listview的显示，一种很常用的开发需求。
 */
public class XMLParserSAX {
 
	public static void main(String[] args) {
		File file = new File("books.xml");
//		List<Book> books = xmlReader(file);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<!-- Edited by XMLSpy -->\n" +
				"<bookstore>\n" +
				"    <book category=\"cooking\">\n" +
				"        <title lang=\"en\">Everyday Italian</title>\n" +
				"        <author>Giada De Laurentiis</author>\n" +
				"        <year>2005</year>\n" +
				"        <price>30.00</price>\n" +
				"    </book>\n" +
				"    <book category=\"children\">\n" +
				"        <title lang=\"en\">Harry Potter</title>\n" +
				"        <author>J K. Rowling</author>\n" +
				"        <year>2005</year>\n" +
				"        <price>29.99</price>\n" +
				"    </book>\n" +
				"    <book category=\"web\">\n" +
				"        <title lang=\"en\">XQuery Kick Start</title>\n" +
				"        <author>James McGovern</author>\n" +
				"        <author>Per Bothner</author>\n" +
				"        <author>Kurt Cagle</author>\n" +
				"        <author>James Linn</author>\n" +
				"        <author>Vaidyanathan Nagarajan</author>\n" +
				"        <year>2003</year>\n" +
				"        <price>49.99</price>\n" +
				"    </book>\n" +
				"    <book category=\"web\" cover=\"paperback\">\n" +
				"        <title lang=\"en\">Learning XML</title>\n" +
				"        <author>Erik T. Ray</author>\n" +
				"        <year>2003</year>\n" +
				"        <price>39.95</price>\n" +
				"    </book>\n" +
				"</bookstore>";
		List<Book> books = xmlReader2(xml);
//		List<Book> books = saxParser(new File("books.xml"));
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
	//使用SAXParser来解析 
	public static List<Book> saxParser(File file) {
		try {
			// 1.创建解析工厂
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();// 获取单例
			// 2.得到解析器
			SAXParser saxParser = saxParserFactory.newSAXParser();
			// 3.得到内容处理器
			SaxHandler saxHandler = new SaxHandler();
			// 4.解析器绑定内容处理器，并解析xml文件
			saxParser.parse(file, saxHandler);
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//使用XMLReader 来解析 
	public static List<Book> xmlReader(File file) {
		try {
			// 1.新建一个工厂类SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2.让工厂类产生一个SAX的解析类SAXParser
			SAXParser parser = factory.newSAXParser();
			// 3.从SAXPsrser中得到一个XMLReader实例
			XMLReader reader = parser.getXMLReader();
			// 4.得到内容处理器
			SaxHandler saxHandler = new SaxHandler();
			// 5.把自己写的handler注册到XMLReader中，一般最重要的就是ContentHandler
			reader.setContentHandler(saxHandler);
			// 6.将一个xml文档或者资源变成一个java可以处理的InputStream流后，解析正式开始
			InputSource inputSource = new InputSource(new FileInputStream(file));
			reader.parse(inputSource);
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//使用XMLReader 来解析
	public static List<Book> xmlReader2(String xml) {
		try {
			// 1.新建一个工厂类SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2.让工厂类产生一个SAX的解析类SAXParser
			SAXParser parser = factory.newSAXParser();
			// 3.从SAXPsrser中得到一个XMLReader实例
			XMLReader reader = parser.getXMLReader();
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
			reader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
			reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
			reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			// 4.得到内容处理器
			SaxHandler saxHandler = new SaxHandler();
			// 5.把自己写的handler注册到XMLReader中，一般最重要的就是ContentHandler
			reader.setContentHandler(saxHandler);
			// 6.将一个xml文档或者资源变成一个java可以处理的InputStream流后，解析正式开始
			StringReader stringReader = new StringReader(xml);
			InputSource inputSource = new InputSource(stringReader);
			reader.parse(inputSource);
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}