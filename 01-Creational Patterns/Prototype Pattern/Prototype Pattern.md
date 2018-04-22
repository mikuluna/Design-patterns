# 原型模式（Prototype Pattern）
终于到了创建型模式Creational Patterns的最后一个！其实原型模式很简单，只用记住一句话：**实现Cloneable接口，重写clone方法**  
但是这一节我们除了讲原型模式的基础，还会讲**深拷贝与浅拷贝**
## 代码讲解
我们以之前的汉堡套餐为例子来讲解。**实现Cloneable接口，重写clone方法**
### 汉堡套餐类：实现Cloneable接口，重写clone方法（浅拷贝）
```
/**
 * 汉堡套餐
 */
public class HamburgerMeal implements Cloneable {
    private String drink;//饮料
    private String hamburger;//汉堡
    private String snack;//小吃
    private ArrayList<String> seasoningPackets;//调料包
    private Customer customer;//消费者

    public HamburgerMeal(){}
    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     */
    public HamburgerMeal(String drink, String hamburger, String snack) {
        this.drink = drink;
        this.hamburger = hamburger;
        this.snack = snack;
    }

    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     * @param seasoningPackets
     */
    public HamburgerMeal(String drink, String hamburger, String snack, ArrayList<String> seasoningPackets) {
        this.drink = drink;
        this.hamburger = hamburger;
        this.snack = snack;
        this.seasoningPackets = seasoningPackets;
    }

    /**
     * 重写clone()方法
     */
    @Override
    public HamburgerMeal clone() throws CloneNotSupportedException {
        return (HamburgerMeal)super.clone();
    }

    /**
     * 重写toString方法，方便展示
     * @return
     */
    @Override
    public String toString() {
        return "汉堡套餐包括："+this.drink+","+this.hamburger+","+this.snack+
                this.seasoningPackets.toString()+this.customer.toString();
    }

    //将所有的getter和setter方法写好
    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getHamburger() {
        return hamburger;
    }

    public void setHamburger(String hamburger) {
        this.hamburger = hamburger;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }
    public ArrayList<String> getSeasoningPackets() {
        return seasoningPackets;
    }

    public void setSeasoningPackets(ArrayList<String> seasoningPackets) {
        this.seasoningPackets = seasoningPackets;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
```
#### 汉堡套餐中的Customer类
```
/**
 * 消费者类（作用是研究深拷贝和浅拷贝）
 */
public class Customer {
    private String name;//名字
    private String age;//年龄


    public Customer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{name:"+name+",age:"+age+"}";
    }

    //将所有的getter和setter方法写好
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
```
### TestShallowCopy类
```
public class TestShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.一个HamburgerMeal对象我们称为Luna的汉堡套餐
        HamburgerMeal hamburgerMealForLuna = new HamburgerMeal("cola","beef burger","chips");
        ArrayList<String> seasoningPackets = new ArrayList<String>();
        seasoningPackets.add("辣椒包");
        seasoningPackets.add("宫保酱");
        seasoningPackets.add("川味酱");
        hamburgerMealForLuna.setSeasoningPackets(seasoningPackets);
        Customer customerLuna = new Customer("luna","20");
        hamburgerMealForLuna.setCustomer(customerLuna);
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("===========================================");
        //2.克隆一下，称为Miku的汉堡套餐,并且直接修改name
        System.out.println("！！！克隆并直接改变Customer对象里面的name！！！！");
        HamburgerMeal hamburgerMealForMiku = hamburgerMealForLuna.clone();
        hamburgerMealForMiku.getCustomer().setName("miku");//浅拷贝的弊端
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("Miku:"+hamburgerMealForMiku.toString());
        //问题来了！！！name全部变成了miku!!!!!!!!(！！！这就是浅拷贝！！！)
        System.out.println("***************************************");
        //2.extend我们new一个对象呢？
        System.out.println("！！！克隆并new一个Customer对象放进去！！！！");
        Customer customerMiku = new Customer("miku","10");
        hamburgerMealForMiku.setCustomer(customerMiku);
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("Miku:"+hamburgerMealForMiku.toString());
        //miku变成了我们需要的，为什么？因为对象的引用！！！（是不是想起了equals和==的区别）
        System.out.println("===========================================");
        //3.这个时候如果改变miku的汉堡套餐其他的东西会怎么样呢？
        //3.1修改一个String类型呢：
        System.out.println("！！！修改克隆的String类型！！！！");
        hamburgerMealForMiku.setDrink("milk");
        System.out.println("Luna(change Miku drink):"+hamburgerMealForLuna.toString());
        System.out.println("Miku(change Miku drink):"+hamburgerMealForMiku.toString());
        System.out.println("===========================================");
        //这里变化了，说明String并不在影响范围
        //3.2修改一个ArrayList对象呢。
        //3.2.1直接对原来的ArrayList进行增删改
        System.out.println("！！！直接修改ArrayList，即去掉index:0！！！！");
        hamburgerMealForMiku.getSeasoningPackets().remove(0);
        System.out.println("Luna(change Miku drink):"+hamburgerMealForLuna.toString());
        System.out.println("Miku(change Miku drink):"+hamburgerMealForMiku.toString());
        System.out.println("===========================================");
        //3.2.2新建一个调料包对象
        System.out.println("！！！new一个ArrayList，放入克隆的对象里面！！！！");
        ArrayList<String> seasoningPacketsNew = new ArrayList<String>();
        seasoningPacketsNew.add("酸甜酱");
        seasoningPacketsNew.add("宫保酱");
        hamburgerMealForMiku.setSeasoningPackets(seasoningPacketsNew);
        System.out.println("Luna(change Miku SeasoningPackets):"+hamburgerMealForLuna.toString());
        System.out.println("Miku(change Miku SeasoningPackets):"+hamburgerMealForMiku.toString());
    }
}
```
我们可以看到的是：当我们直接修改Clone对象里面的Object属性的时候，原有的对象也会跟着变化，这就是一个浅拷贝。但是我们的预期是
不管怎么修改，都与原对象无关的话，该怎么办呢？那就请看下面对于深拷贝的实现吧。
## 不得不说的深拷贝
深拷贝，也就是要让克隆的对象和原来的对象互不干扰，改变对象里面的Object不会产生其他的问题。
### 实现1：类里引用的Object都要实现Cloneable接口，重写clone方法
这个的话，在引用的那个类里面的clone方法，把所有的Object都clone一遍，直到里面的引用是非Object。  
首先修改一下Customer类实现Cloneable接口，重写clone方法
```
/**
 * 消费者类（作用是研究深拷贝和浅拷贝）
 */
public class Customer implements Cloneable{
    private String name;//名字
    private String age;//年龄
    
    public Customer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Customer{name:"+name+",age:"+age+"}";
    }

    //将所有的getter和setter方法写好
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
```
HamburgerMeal类的clone方法稍微改一下
```
    /**
     * 重写clone()方法
     */
    @Override
    public HamburgerMeal clone() throws CloneNotSupportedException {
//        return (HamburgerMeal)super.clone();
        HamburgerMeal hamburgerMeal = (HamburgerMeal)super.clone();
        hamburgerMeal.customer = (Customer)customer.clone();
        hamburgerMeal.seasoningPackets = (ArrayList<String>)seasoningPackets.clone();
        return hamburgerMeal;
    }
```
这样我们的新的对象和以前的对象就互不干扰了。
### 实现2：运用序列化实现深拷贝（与原型模式无关）
这个也是说到深拷贝的时候顺带说道的。可以用序列化的形式来实现深拷贝。
- 让Customer类和HamburgerMeal实现Serializable接口
```
public class HamburgerMeal implements Cloneable,Serializable
public class Customer implements Cloneable,Serializable
```
- 写deepCopy方法
```
    public static Object deepCopy(Object from) {
        Object obj = null;
        try {
            // 将对象写成 Byte Array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(from);
            out.flush();
            out.close();

            // 从流中读出 byte array，调用readObject函数反序列化出对象
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = in.readObject();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        return obj;
    }
```
- 写测试方法
```
public static void main(String[] args) {
        //1.一个HamburgerMeal对象我们称为Luna的汉堡套餐
        HamburgerMeal hamburgerMealForLuna = new HamburgerMeal("cola","beef burger","chips");
        ArrayList<String> seasoningPackets = new ArrayList<String>();
        seasoningPackets.add("辣椒包");
        seasoningPackets.add("宫保酱");
        seasoningPackets.add("川味酱");
        hamburgerMealForLuna.setSeasoningPackets(seasoningPackets);
        Customer customerLuna = new Customer("luna","20");
        hamburgerMealForLuna.setCustomer(customerLuna);
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("===========================================");
        //2.用写好的序列化的方法进行复制
        HamburgerMeal hamburgerMealForMiku = (HamburgerMeal) deepCopy(hamburgerMealForLuna);
        hamburgerMealForMiku.getCustomer().setName("miku");
        System.out.println("Luna:"+hamburgerMealForLuna.toString());
        System.out.println("Miku:"+hamburgerMealForMiku.toString());
}
```
可以看出不管使用Clone方法将所有引用的Object都克隆一遍或者运用序列化的方法都可以实现deepCopy的效果！
但是对于很大的一个对象，序列化操作比较慢，其实序列化和反序列化两个操作是比较耗时的。  
看到其他对于deepCopy而言的话，推荐一些成熟的第三方库例如：[Dozer](https://github.com/DozerMapper/dozer)，[Kryo](https://github.com/EsotericSoftware/kryo)，[cloning](https://github.com/kostaskougios/cloning)

## 总结
原型模式，据说是最简单的设计模式，也就是实现Cloneable接口，重写clone方法，但是需要研究的不仅仅只是表面，还需要扩展很多知识才行，就类似于浅拷贝和深拷贝，这个对于工作的我们是非常重要的。（作者刚开始工作的时候就吃过浅拷贝和深拷贝的亏了2333虽然是JavaScript的）