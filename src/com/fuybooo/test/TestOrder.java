package com.fuybooo.test;

import com.fuybooo.pojo.Order;
import com.fuybooo.pojo.OrderItem;
import com.fuybooo.pojo.Product;

import java.io.IOException;
import java.util.List;

public class TestOrder {
    public static void main(String[] args) throws IOException {
        TestBed<Order> tb = new TestBed<>();
        List<Order> os = tb.getListBySelectId("listOrder");
//        addOrderItem();
//        deleteOrderItem();
        for (Order o: os) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for (OrderItem oi: ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),
                        oi.getProduct().getPrice(), oi.getNumber());
            }
        }
    }
    public static void addOrderItem() throws IOException {
        Order o1 = new TestBed<Order>().selectOne("getOrder", 1);
        Product p6 = new TestBed<Product>().selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        oi.setNumber(200);
        TestBed<OrderItem> tb = new TestBed<>();
        tb.add("addOrderItem", oi);
        tb.ss.commit();
        tb.ss.close();
    }
    public static void deleteOrderItem() throws IOException {
        Order o1 = new TestBed<Order>().selectOne("getOrder", 1);
        Product p6 = new TestBed<Product>().selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        TestBed<OrderItem> tb = new TestBed<>();
        tb.del("deleteOrderItem", oi);
        tb.ss.commit();
        tb.ss.close();
    }
}
