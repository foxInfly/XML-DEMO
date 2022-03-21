package com.lp.xml.sax;

import lombok.Data;

@Data
public class Book {
	//种类？
	private String category;
	private String titleLang;
	private String title;
	private String author;
	private Integer year;
	private Double price;
	
	
	@Override
	public String toString() {
		return "Book [category=" + category + ", titleLang=" + titleLang + ", title=" + title + ", author=" + author + ", year=" + year + ", price=" + price + "]";
	}
	//生成字段的get、set方法
}