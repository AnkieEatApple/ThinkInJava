##Chapter17 容器的深入研究

###1. 完整的容器分类法
![FB288F08-9DC2-4140-AFA0-28E7C7260C2E.png](https://i.loli.net/2018/12/29/5c27114f2f5c6.png)

###2. 填充容器
1. Collections类的接口fill()
2. 对List对象有用的接口addAll()

####2.1 一种Generator解决方案
1. 思想是将Collection的字类型都有一个接受另一个Collection对象的构造器，用所接受的Collection对象中的元素来填充新的容器。也称之为适配器模式

####2.2 Map生成器
1. Map适配器现在可以使用不同的Generator、Iterator和常量值的组合来填充Map初始化对象

####2.3 使用Abstract类
1. 每个Java的java.util容器中都有自己的Abstract类，它们提供了该容器的部分实现，因此所必须做的事是去实现那些产生想要的容器的所必须的方法
2. Map常用的设计模式：**享元**
3. 