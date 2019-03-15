package com.fuybooo.test;

import com.fuybooo.pojo.Product;

import java.io.IOException;
import java.util.List;

public class TestProduct {
    public static void main(String[] args) throws IOException {
        List<Product> cs = TestBed.getListBySelectId("listProduct");
        for (Product c: cs) {
            System.out.println(c.getName());
        }
    }
}
