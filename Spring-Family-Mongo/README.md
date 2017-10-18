# mongodb简介

MongoDB（来自于英文单词“Humongous”，中文含义为“庞大”）是可以应用于各种规模的企业、各个行业以及各类应用程序的开源数据库。基于分布式文件存储的数据库。由C++语言编写。旨在为WEB应用提供可扩展的高性能数据存储解决方案。MongoDB是一个高性能，开源，无模式的文档型数据库，是当前NoSql数据库中比较热门的一种。

MongoDB是一个介于关系数据库和非关系数据库之间的产品，是非关系数据库当中功能最丰富，最像关系数据库的。他支持的数据结构非常松散，是类似json的bjson格式，因此可以存储比较复杂的数据类型。Mongo最大的特点是他支持的查询语言非常强大，其语法有点类似于面向对象的查询语言，几乎可以实现类似关系数据库单表查询的绝大部分功能，而且还支持对数据建立索引。

传统的关系数据库一般由数据库（database）、表（table）、记录（record）三个层次概念组成，MongoDB是由数据库（database）、集合（collection）、文档对象（document）三个层次组成。MongoDB对于关系型数据库里的表，但是集合中没有列、行和关系概念，这体现了模式自由的特点。

MongoDB中的一条记录就是一个文档，是一个数据结构，由字段和值对组成。MongoDB文档与JSON对象类似。字段的值有可能包括其它文档、数组以及文档数组。MongoDB支持OS X、Linux及Windows等操作系统，并提供了Python，PHP，Ruby，Java及C++语言的驱动程序，社区中也提供了对Erlang及.NET等平台的驱动程序。

MongoDB的适合对大量或者无固定格式的数据进行存储，比如：日志、缓存等。对事物支持较弱，不适用复杂的多文档（多表）的级联查询。文中演示mongodb版本为3.4。


## 下载

```bash
curl -O https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.0.6.tgz
```

## 解压

```bash
tar -zxvf mongodb-linux-x86_64-3.0.6.tgz
```

## 将解压包拷贝到指定目录进行安装

```bash
sudo mv  mongodb-linux-x86_64-3.0.6/ /usr/local/mongodb  
```
**然后将MongoDB的安装目录添加到Path当中，记得如果你的最后一个位置和我的不一样，请记得替换**
```bash

vi /etc/profile
增加
export PATH=/usr/local/mongodb/bin:$PATH
然后
source /etc/progile
```

## 启动数据库，首先我使用的不是他的默认地址，所以需要手工创建一个目录并且指定位置，如果下面语句执行没问题，就证明已经服务ok了
```bash
mongo --dbpath /data/mongodb/ &
```

**(这里请替换为你的数据库地址，你可以自定义)**

## 启动

```bash
mongo
```

**然后就会启动一个shell，到这里我们就可以开始操作我们数据库了**


## 如何创建用户管理员


**用户管理员是第一个要创建的用户。在没有创建任何用户之前，你可以随意创建用户；但数据库中一旦有了用户，那么未登录的客户端就没有权限做任何操作了，除非使用db.auth(username, password)方法登录。**

用户管理员的角色名叫 userAdminAnyDatabase，这个角色只能在 admin 数据库中创建。下面是一个例子：

```bash
use admin
switched to db admin
> db.createUser({user:"sierou",pwd:"sierou",roles:["userAdminAnyDatabase"]})
Successfully added user: { "user" : "sierou", "roles" : [ "userAdminAnyDatabase" ] }
```

这个例子创建了一个名为 root 的用户管理员。创建完了这个用户之后，我们应该马上以该用户的身份登录：

```bash
db.auth("sierou","sierou")
1
db.auth() 方法返回 1 表示登录成功。接下来我们为指定的数据库创建访问所需的账号。
```

---

## 如何创建数据库用户


首先保证你已经以用户管理员的身份登录 admin 数据库。然后用 use 命令切换到目标数据库，同样用 db.createUser() 命令来创建用户，其中角色名为 “readWrite”。

普通的数据库用户角色有两种，read 和 readWrite。顾名思义，前者只能读取数据不能修改，后者可以读取和修改。
下面是一个例子：

```bash
use test
switched to db test
> db.createUser({user:"test",pwd:"sierou",roles:["readWrite"]})
Successfully added user: { "user" : "test", "testoles" : [ "readWrite" ] }
> db.auth("test","sierou")
1

```
