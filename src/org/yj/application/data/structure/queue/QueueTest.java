package org.yj.application.data.structure.queue;

public class QueueTest {



    public static void main(String[] args)
    {
        /*Queue queue = new Queue(3);
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.print();

   *//*     queue.add(7);
        queue.add(9);
        queue.print();*//*
        System.out.println("--------------------------");
        queue.remove();
        queue.print();

        System.out.println("--------------------------");
        queue.remove();
        queue.print();

        System.out.println("--------------------------");
        queue.add(7);
        queue.print();*/

        MyQueue myQueue= new MyQueue(3);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);

        myQueue.showElement();

        System.out.println("--------------------------");

        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.showElement();



    }

}
