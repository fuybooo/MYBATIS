package com.fuybooo.test;

import com.fuybooo.pojo.Category;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    public static void main(String[] args) throws IOException {
        TestMybatis tm = new TestMybatis();
        TestBed<Category> tb = new TestBed<>();
        tm.getList(tb);
        Category c1 = new Category();
        // 测试新增
//        c1.setName("新的category");
//        tb.add("addCategory", c1);
        // 测试删除
//        c1.setId(5);
//        tb.del("deleteCategory", c1);
        // 测试查询单个
//        Category c = tb.selectOne("getCategory", 2);
//        System.out.println(c.getName());
//        c1.setId(2);
//        c1.setName("这是修改后的内容");
//        tb.update("updateCategory", c1);
        // 测试模糊查询
//        List<Category> cs = tb.listCategoryByName("listCategoryByName", "哈");
//        for (Category c: cs) {
//            System.out.println(c.getName());
//        }
        // 测试多条件查询
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        param.put("name", "是");
        List<Category> cs = tb.listCategoryByIdAndName("listCategoryByIdAndName", param);
        for (Category c: cs) {
            System.out.println(c.getName());
        }
        tm.getList(tb);
        tb.ss.commit();
        tb.ss.close();
    }

    private void getList(TestBed<Category> tb) throws IOException {
        List<Category> cs = tb.getListBySelectId("listCategory");
        System.out.println("查询并且打印 start：");
        for (Category c: cs) {
            System.out.println(c.getName());
        }
        System.out.println("查询并且打印 end：");
    }
}
