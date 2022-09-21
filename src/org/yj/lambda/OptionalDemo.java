package org.yj.lambda;

import java.util.Optional;

public class OptionalDemo {


    public static void main(String[] args) {

 /*       String lastName="Yin";
        Optional<String> op1=Optional.of(lastName);

        if(op1.isPresent()){
            System.out.println(op1.get());
        }


        Optional op2=Optional.empty();

        if(op2.isEmpty()){
            System.out.println("op2 is null");
        }*/


        String firstName="Eric";
       // String firstName=null;
        Optional<String> op3=Optional.ofNullable(firstName);

        System.out.println(op3.map(name -> name.length()).map(len->len*2).get());

        System.out.println("----");
    }
}
