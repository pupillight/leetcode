package org.yj.application.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {

    private void process(List<User> users) {

    }

    private int id;
    private String name;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "yj");
        User user2 = new User(2, "yzy");
        users.stream().sorted((e1, e2) -> e1.getId() - e2.getId());
        users.stream().collect(Collectors.toMap(item -> item.getId(), item -> item.getName()));
        Map map = users.stream().collect(Collectors.groupingBy(item -> item.getId()));


    }
}
