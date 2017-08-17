# 磊哥：
 
把具有相同的业务逻辑的模块，进行统一的处理，日志，异常，事务。

# 丁哥：

是一个面向切面，体现在拦截器，拦截东西，代理似的，方法执行前后、环绕。


aop：面向接口编程，
    
    mvc：  dao、service、controller
        controller：
            @Autowired Service ： 接口
                serviceimpl  add
                    面向对象编程，多态 ： 父类指针指向之类对象，得有继承，之类重写父类方法
                面向接口编程，
    
    动态代理、静态代理。
    
    静态代理：手动编写代理类
    动态代理：通过反射机制，创造出代理对象
    
    
    Spring-AOP机制：JDK 
    默认：Cglib动态代理
         

    mybatis 动态代理
