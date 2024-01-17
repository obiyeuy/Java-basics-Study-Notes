package com.yueyibo.dao_.test;

import com.yueyibo.dao_.dao.BeautyDAO;
import com.yueyibo.dao_.domain.Beauty;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    //测试Beauty对beauty表crud操作
    @Test
    public void testBeautyDAO() {
        BeautyDAO beautyDAO = new BeautyDAO();
        //1.查询
        List<Beauty> beautys = beautyDAO.queryMulti("select * from beauty where id >= ?", Beauty.class, 1);
        System.out.println("查询结果");
        for (Beauty beauty : beautys) {
            System.out.println(beauty);
        }

        //2.查询单行结果
        Beauty beauty = beautyDAO.querySingle("select * from beauty where id = ?", Beauty.class, 13);
        System.out.println("查询结果");
        System.out.println(beauty);

        //3.查询单行单列结果
        Object o = beautyDAO.queryScalar("select name from beauty where id = ?", 13);
        System.out.println("查询结果");
        System.out.println(o);

        //4.dml操作
        int rows = beautyDAO.update("insert into beauty values(null,?,?,?,?,null,?)", "乐", "女", "1999-1-1", "12345678", 1);
        System.out.println(rows > 0 ? "执行成功" : "执行失败");
    }
}
