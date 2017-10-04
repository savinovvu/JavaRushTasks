package com.javarush.task.task28.task2805;

public class MyThread extends Thread {

    private static int priorityVariant = 1;


    public MyThread() {
        super();
        this.setPriority(priorityVariant++);
        priorityVariant = priorityVariant > 10 ? 1 : priorityVariant;
    }


    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priorityVariant++);
        priorityVariant = priorityVariant > 10 ? 1 : priorityVariant;
    }


  /*  MyThread(Runnable target, AccessControlContext acc) {
        super(target, acc);
    }*/


    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(priorityVariant > group.getMaxPriority()? group.getMaxPriority(): priorityVariant);
        priorityVariant = ++priorityVariant > 10 ? 1 : priorityVariant;
    }


    public MyThread(String name) {
        super(name);
        this.setPriority(priorityVariant++);
        priorityVariant = priorityVariant > 10 ? 1 : priorityVariant;
    }


    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(priorityVariant > group.getMaxPriority()? group.getMaxPriority(): priorityVariant);
        priorityVariant = ++priorityVariant > 10 ? 1 : priorityVariant;
    }


    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priorityVariant++);
        priorityVariant = priorityVariant > 10 ? 1 : priorityVariant;
    }


    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(priorityVariant > group.getMaxPriority()? group.getMaxPriority(): priorityVariant);
        priorityVariant = ++priorityVariant > 10 ? 1 : priorityVariant;
    }


    public MyThread(ThreadGroup group, Runnable target, String name,
                    long stackSize) {
        super(group, target, name);
        this.setPriority(priorityVariant > group.getMaxPriority()? group.getMaxPriority(): priorityVariant);
        priorityVariant = ++priorityVariant > 10 ? 1 : priorityVariant;
    }
}
