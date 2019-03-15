package com.fuybooo.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestBed<T> {
    public SqlSession ss = null;
    private void getSession() throws IOException {
        if (null == this.ss) {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            this.ss = sqlSessionFactory.openSession();
        }
    }
    List<T> getListBySelectId(String id) throws IOException {
        getSession();
        return this.ss.selectList(id);
    }
    void add(String id, T t) throws IOException {
        getSession();
        this.ss.insert(id, t);
    }
    void del(String id, T t) throws IOException {
        getSession();
        this.ss.delete(id, t);
    }
    T selectOne(String id, int intId) throws IOException {
        getSession();
        return this.ss.selectOne(id, intId);
    }
    void update(String id, T t) throws IOException {
        getSession();
        this.ss.update(id, t);
    }
    List<T> listCategoryByName(String id, String name) throws IOException {
        getSession();
        return this.ss.selectList(id, name);
    }
    List<T> listCategoryByIdAndName(String id, Map<String, Object> param) throws IOException {
        getSession();
        return this.ss.selectList(id, param);
    }
}
