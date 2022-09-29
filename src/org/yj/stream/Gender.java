package org.yj.stream;

import java.util.Arrays;

public enum Gender {
    MALE(1, "man"), FEMALE(2, "woman");
    int code;
    String desc;

    Gender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static void main(String[] args) {

        //Arrays.stream(Gender.values()).forEach(System.out::println);
        for(Gender gender:Gender.values())
        {
            System.out.println(gender);
        }
        Gender gender = Gender.valueOf("MALE");
        if (gender == Gender.MALE) {
            System.out.println("----");
        }
    }
}
