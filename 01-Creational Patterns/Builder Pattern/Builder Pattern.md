# 建造者模式（Builder Pattern）
## 定义
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示  
Builder表示一个过程的分解，比如你去银行取钱：1.先要去拿好，2.然后去柜台办理手续，3.最后拿到钱。我们把这三个步骤分别作为方法放在Builder里面，这样是不是就比较好理解了呢？
## 代码解析
我们就之前作者去麦肯基吃饭的故事的延续的例子。  
- 在作者吃肯打鸡的汉堡套餐的点餐过程中（背景），点餐（Client）之后
- 点餐员(Director)会通知配餐员去配餐（Builder）[“你要准备可乐牛肉汉堡还有炸土豆这三样东西”]
- 配餐过程包括**先**可乐**然后**牛肉汉堡**最后**炸土豆的准备（ConcreteBuilder）
- 最后作者获得了汉堡套餐（Product）
### 汉堡套餐实体类
```
/**
 * 汉堡套餐
 */
public class HamburgerMeal {
    String drink;//饮料
    String Hamburger;//汉堡
    String snack;//小吃

    /**
     * 构造器方便之后定套餐里面的东西
     * @param drink
     * @param hamburger
     * @param snack
     */
    public HamburgerMeal(String drink, String hamburger, String snack) {
        this.drink = drink;
        Hamburger = hamburger;
        this.snack = snack;
    }

    //将所有的getter和setter方法写好
    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getHamburger() {
        return Hamburger;
    }

    public void setHamburger(String hamburger) {
        Hamburger = hamburger;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }
}
```
