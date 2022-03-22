package com.lp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(0,"0");
        list.add(0,"1");
        list.add(0,"2");
        list.add(0,"3");
        list.add(0,"4");
        list.add(0,"5");
        list.add(0,"6");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+":"+list.get(i));
        }
    }
}
