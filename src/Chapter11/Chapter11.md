##Chapter11 持有对象

1. 如果一个程序只包含固定数量的且生命周期都是已知对象，那么这是一个非常简单的程序

####11.1 范性和类型安全的容器
1. ArrayList 可以人做为可以自动扩充自身尺寸的数组
2. @SuppressWarnings注解及其参数表示只有有关"不受检查的异常"的警告信息应该被抑制
3. ArrayList<Apple>中是定义用来保存Apple对象的ArrayList，其中尖括号括起来的是类型参数，指定了这个容器实例可以保存的类型
4. 此时可以阻止将其他的类型放置到apples中
5. 遍历ArrayList中的元素时，程序输出的是从Object默认的toString()方法产生的，该方法将打印类名，后面跟随该对象的散列码的无符号十六进制(这个散列码是通过hashcode()方法产生的)， 类似于 `Gala@11b86e7`

####11.2 基本概念
1. Java容器类类库的用途是“保存对象”，并将其划分为两个不同的概念。
2. Collection：一个独立元素的序列，这些元素都服从一条或多条规则，List必须按照插入顺序保存元素，Set不能有重复元素，Queue按照排队规则来确定对象产生的顺序(通常与他们被插入的顺序相同)
3. Map：一组成对的“键值对”对象，允许您使用键值来查找值，ArrayList允许你使用数字来查找值。
4. 向上转型的过程中应当注意，当使用对应的List、Map的接口中的方法的时候不需要考虑向上转型的情况，但是若使用了ArrayList、LinkedList、TreeMap等中的自带方法的话，就应该避免向上转型

```
// 向上转型
List<Apple> apples = new ArrayList<>();
// 使用了LinkedList
LinkedList<Apple> apples = new LinkedList <>();
```

5. Collection 接口概括了序列的概念————是一种存放一组对象的方式

```
// 使用了Integer对象填充了一个Collection
Collection<Integer> c = new ArrayList<Integer>();
```

1. Collection 支持forEach遍历

####11.3 添加一组元素
1. Arrays.List()方法接受一个数组或者是一个用逗号分隔的元素列表(使用可变参数)，并将其转换为一个List对象。
2. Collections.addAll()方法接受一个Collection对象，以及一个数组或者是一个用逗号分割的列表，将所有的元素添加到Collection中。

```
List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
list.set(1, 99);
// list.add(21); 错误，因为该list不能delete或者add，因为上面转化为的是一个数组，add或者delete改变的数组的长度。
```

####11.4 容器的打印
1. Arrays.toString(); 方法可以产生数组的打印表示，但是打印容器无需任何帮助。可以直接打印。
2. Collection中的特性
	1. List：每个槽中只能保存一个元素，按照特性的顺序保存一组元素，代表有ArrayList、LinkedList
	2. Set：元素不能重复，HashSet(最快的)、TreeSet(按照升序的方式)、LinkedHashSet(按照被减价的顺序)
	3. Queue：只允许容器的一“端”插入对象，并且冲另一“端”移除对象
	4. Map：在每个槽内保存了两个对象，即键值对，代表的有：HashMap、TreeMap、LinkedHashMap

####11.5 List
1. List可以将元素维护在特定的序列中。List接口在Collection的基础上添加了大量的方法，是的List的中间插入和移除元素
2. ArrayList：常用于随机访问元素，但是在List中间插入和移除元素比较慢
3. LinkedList：通过代价较低的在List中间进行插入和删除操作，提供了优化的顺序访问，本质上是list，所以随机访问相对比较慢，但是特性集较ArrayList更大
4. List的使用：
	1. add(); 
	2. get();
	2. remove(); 
	3. contains(); 
	4. indexof();	位置编号
	5. 不能直接比对equals()两个链表的引用
	6. subList(); 允许你很容易的从较大的列表中创建出一个片段，将这个结果传递给这个较大的列表containsAll()方法时，会得到true
	7. retainAll(); 是一种有效的“交集”操作，所产生的行为依赖于equals()方法
	8. removeAll();
	9. set( , );
	10. addAll();
	11. isEmpty();
	12. clear();
	13. toArray();
	
####11.6 迭代器
1. 迭代器时一个对象，它的工作是遍历并选择序列中的对象，而客户端程序猿不必知道或关心该序列底层的结构。
2. 迭代器通常被称为轻量级对象，创建代价小，但是只能单向移动
3. 使用iterator()要求返回一个Iterator。Iterator将准备好返回序列的第一个元素
	4. 使用next()获得序列的下一个元素
	5. 使用hasNext()检查序列中国是否还有元素
	6. 使用remove()将迭代器新近返回的元素删除
7. 这样不必关心元素中的数量，可以有hasNext()和next()关心
8. 相比forEach更加简洁
9. 调用remove()之前请先调用next();
10. 遍历序列的操作与序列底层的结构分离，迭代器统一了对容器的访问方式。

#####11.6.1 ListIterator
1. 为Iterator的子类
2. 仅限于使用各种List的访问
3. 可以向前访问，可以向后访问，指定位置访问，调用set方法替换指定位置向前的所有列表元素对象

####11.7 LinkedList
1. LinkedList 和ArrayList都实现了List的接口，在添加和移除新元素的时候更加方便，随机访问性能较差
2. LinkedList添加了可以使用栈、队列、双端队列中的方法
3. LinkedList的使用方法
	1. getFirst() 和 Queue中的element()一样，第一个元素
	2. peek()：第一个元素
	2. removeFirst()，remove() ，删除第一个元素
	3. poll()，删除第一个元素
	3. addFirst()，添加到第一个元素
	4. add()，offer()，addLast()，添加到最后
	4. removeLast()  ， 删除第一个元素	

####11.8 Stack
1. “栈”通常是指“后进先出(LIFO)”的容器，也可以称为叠加栈，最后压入栈的第一个弹出栈
2. Stack是用LinkedList实现的
3. push() 添加到栈顶
4. peek() 提供栈顶元素，但是不删除
5. pop() 移除并返回栈顶元素

####11.9 Set
1. Set不保存重复元素
2. **Set会阻止重复的相同对象的多个实例**
3. HashSet专门对快速查找进行了优化
4. Set实际上就是Collection，只是行为不同，Set是基于对象的值来确定属性的
5. TreeSet将元素存储在红-黑数数据结构中，而使用HashSet使用的是散列函数
6. LinkedHashSet因查询速度的原因也使用了散列，但是看起来是使用的链表来维护元素的插入顺序
7. Set可以使用contains来测试Set的归属性

####11.10 Map
1. Map或者其他的容器是不能使用基本的类型的
2. 可以通过containsKey()和containsValue()来测试一个Map，来查看是否包含某个键或者某个值
3. Map和数组与其他的Collection一样，可以很容易的扩展到多维，我们只需将其设置为Map，可已通过容器组合起来从而快速地生成强大的数据结构。例如每个人拥有的宠物`Map<Person. List<Pet>>`
4. Map可以返回它的键的Set，它的值的Collection，或者它的键值对的Set，keySet()方法产生了由petPeople中的所有键组成的Set，然后在forEach中遍历了Map

####11.11 Queue
1. Queue是一个典型的先进先出(FIFO)的容器
2. offer()方法是与Queue相关的方法之一，在允许的情况下，将一个元素插入到队尾，或者返回false
3. peek()和element()方法都将在不移除的情况下返回队头，但是peek()方法在队列为空的时候返回null，element()会抛出NoSuchElementException异常。
4. poll()和remove()方法将移除并返回队头，但是poll()在队列为空的时候返回null，而remove()会抛出NoSuchElementException异常
5. 自动刨床机制会自动将nextInt()方法的int结果转换为queue所需的Integer对象，将char c转换为qc所需的Character对象
6. Queue接口窄化了LinkedList的方法访问权限

#####11.11.1 PriorityQueue
1. 优先级队列队列声明下一个弹出的元素是最需要的元素
2. 当offer()方法来插入一个对象时，这个对象会在队列中排序，默认的排序将使用对象在队列中自然排序，但是可以通过提供自己的Comparator来修改这个顺序。

####11.12 Collection 和Iterator
1. Collection时描述的所有序列容器的共性的根接口
2. Collection换句话说容器之间的所有共性都是通过迭代器达成的。

####11.13 ForEach与迭代器
1. forEach语法主要用于数组，但也可以应用于任何Collection对象

####11.14 总结
1. 数组将数字与对象联系起来，它保存类型明确的对象，查询对象时，不需要对结果做类型转换，可以是多维的，可以保存基本类型的数据。但是，数据一旦生成，其容量就不能改变
2. **容器不能持有基本类型**，但是自动包装机制会仔细的执行基本类型到容器中，所持有的包装器类型之间的双向转换
3. List也建立数字索引与对象的关联，数组和List都是排好序的容器，List能够自动扩充容量
4. Queue和Stack的行为，是由LinkedList提供支持，并窄化接口。
5. Map是键值对之间的关联的设计，HashMap设计用快速访问、TreeMap始终保持“键”排序状态，LinkedHashMap保持元素插入的顺序，但是也通过散列提供了快速访问的能力
6. Set不接受重复的元素，HashSet提供了最快的查询速度，而TreeSet保持元素处于排序状态、LinkedHashSet以插入顺序保存元素。
7. 新程序不能使用过时的Vector、HashTable、Stack

















