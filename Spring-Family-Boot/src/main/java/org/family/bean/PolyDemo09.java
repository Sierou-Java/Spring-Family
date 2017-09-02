package org.family.bean;

//哈哈，感觉这道题真心好啊。不知道楼主是从哪里看到的。
//首先这道题楼主要明白以下两点：
//1：继承时，子类会隐藏父类相同的方法，要调用父类方法就必须使用super关键字。
//2：向上转型时，子类会丢失和父类不同的方法，可以使用父类的不同名的所有方法。
public class PolyDemo09 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();//B类型向上转型丢失与A类不同方法
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("⑴    " + a1.show(b));//B类的父类是A，所以A and A
        System.out.println("⑵    " + a1.show(c)); //C类父类的父类是A，D和他是同级。所以A and A
        System.out.println("⑶    " + a1.show(d));//D类方法有，所以不会向上转型，所以A and D
        System.out.println("⑷    " + a2.show(b));
        /*注意这时候a2的两个方法其实是
            public String show(D obj) {
            return ("A and D");
            }
            public String show(A obj) {
            return ("B and A");
            }  B的父类是A，所以B and A
        */
         /**/
        System.out.println("⑸    " + a2.show(c));//C的父类的父类是A，所以B and A；
        System.out.println("⑹    " + a2.show(d));  //D有对应方法，所以A and D
        System.out.println("⑺    " + b.show(b)); /*这个就是继承了，继承除了隐藏父类中和子类同名的方法外，在子类中可以直接使用父类的方法。所以B and B
所以就变成了
public String show(D obj) {
return ("A and D");
}
public String show(B obj) {
return ("B and B");
}
public String show(A obj) {
return ("B and A");
*/
        System.out.println("⑻    " + b.show(c)); //C 的父类是B，所以B and B
        System.out.println("⑸    " + a2.show(c));//C的父类的父类是A，所以B and A；


        System.out.println("⑼    " + b.show(d));//D有相应方法，所以A and D

    }
}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }

}

class C extends B {
}

class D extends B {
}
