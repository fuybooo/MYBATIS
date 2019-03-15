package com.fuybooo.test;

import com.fuybooo.pojo.Product;

import java.io.IOException;
import java.util.List;

public class TestProduct {
    public static void main(String[] args) throws IOException {
        TestBed<Product> tb = new TestBed<>();
        List<Product> ps = tb.getListBySelectId("listProduct");
        for (Product p: ps) {
            System.out.println(p + "对应的分类是：\t" + p.getCategory());
        }
        tb.ss.commit();
        tb.ss.close();
    }
}
