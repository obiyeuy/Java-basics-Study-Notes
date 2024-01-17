package com.yueyibo.self_study.improve.homework;



import org.junit.jupiter.api.Test;

import java.util.List;

@SuppressWarnings({"all"})
public class GenericHomeWork {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 10, "jack"));
        dao.save("002", new User(2, 18, "tom"));
        dao.save("003", new User(3, 18, "john"));

        List<User> list = dao.list();
        System.out.println(list);
        dao.update("003", new User(3, 58, "mailn"));
        list = dao.list();
        System.out.println(list);

        System.out.println("id=003" + dao.get("003"));
    }
}
