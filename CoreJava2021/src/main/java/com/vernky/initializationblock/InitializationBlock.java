package com.vernky.initializationblock;

class B
{

    static  {
        System.out.println("this is B class static block ");
    }

    int b;
    {
        System.out.println("B as Initialization block ");
    }
B(int b)
{

    System.out.println("this is B Constructor  ");
}

}
class A extends B
{
    int a;
    int b;
    {
        System.out.println("A as Initialization block ");
    }
    A(){
        super(7);
        System.out.println("default Contor");
    }
    A(int a, int b)
    {
        super(b);
     System.out.println("This is parameeraized Const");
    }

    static  {
        System.out.println("this is A class static block ");
    }


}



public class InitializationBlock {

    public static void main(String[] args) {

        System.out.println("Let Prove it ");

       A a = new A ();
        A b = new A ();



    }
}
