package edu.sef;

interface BaseLike<A> {
    default void runner(A value) {
        System.out.println(value);
    }
}

class Base<A> implements BaseLike<A>{
    protected void someMethod(int x) {
        System.out.println("This is the value for x: " + x);
    }
}

class Child<A> extends Base<A> {
    @Override
    public void someMethod(int x){
        System.out.println("This is the overridden value for x: " + x);
    }
}

public class Solution {
    public static void main(String[] args) {
        Base<Integer> objectBase = new Child<Integer>();
        objectBase.someMethod(120);

        objectBase = new Base<Integer>();
        objectBase.someMethod(120);

        BaseLike<Integer> base = new Base<Integer>();
        base.runner(123);
//        base.runner("String");

        BaseLike<String> baseImmut = new BaseLike<String>() {};
        baseImmut.runner("This is a string.!");
    }
}
