# 过滤器模式（Filter/Criteria Pattern）
## 定义
过滤器模式（Filter）也叫标准模式（Criteria），这种模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来
## 代码
我们以游戏里面的车为例。车有颜色，轮胎数量，以及名字
### 车类
里面有车名，车颜色，轮胎数量
```
/**
 * 车类
 */
public class Car {
    //车名
    private String name;
    //车颜色
    private String color;
    //车轮胎数量
    private String tyreNum;

    public Car(String name, String color, String tyreNum) {
        this.name = name;
        this.color = color;
        this.tyreNum = tyreNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTyreNum() {
        return tyreNum;
    }

    public void setTyreNum(String tyreNum) {
        this.tyreNum = tyreNum;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", tyreNum='" + tyreNum + '\'' +
                '}';
    }
}
```
### Filter接口
```
/**
 * Filter接口
 */
public interface Filter {
    /**
     * 过滤器方法，过滤一些我们自己定的条件
     * @param cars
     * @return
     */
    public List<Car> filter(List<Car> cars);
}
```
### Filter实现
#### 过滤筛选红色车辆
```
/**
 * 过滤筛选出红色车辆
 */
public class RedCarFilter implements Filter {
    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> redCars = new ArrayList<Car>();
        for(Car car:cars){
            if(car.getColor().equals("red")){
                redCars.add(car);
            }
        }
        return redCars;
    }
}
```
#### 过滤筛选出四轮车
```
/**
 * 过滤筛选出四轮车
 */
public class FourWheelerFilter implements Filter{
    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> fourWheelterCars  = new ArrayList<Car>();
        for(Car car :cars){
            if(car.getTyreNum().equals("4")){
                fourWheelterCars.add(car);
            }
        }
        return fourWheelterCars;
    }
}
```
###Filter的组合之FilterAnd和FilterOr
#### FilterAnd
```
/**
 * 两个条件都需要满足
 */
public class FilterAnd implements Filter{
    private Filter filter;
    private Filter otherFilter;

    public FilterAnd(Filter filter, Filter otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> tempList = filter.filter(cars);
        return otherFilter.filter(tempList);
    }
}
```
#### FilterOr
```
/**
 * 只要满足一个条件即可
 */
public class FilterOr implements Filter{
    private Filter filter;
    private Filter otherFilter;

    public FilterOr(Filter filter, Filter otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> temList = filter.filter(cars);
        List<Car> otherTemList = otherFilter.filter(cars);
        for(Car car:temList){
            if(!otherTemList.contains(car)){
                otherTemList.add(car);
            }
        }
        return otherTemList;
    }
}
```
### Test
```
public class TestFilter {
    public static void main(String[] args) {
        //1.先把要筛选的车辆构造好
        Car uaz = new Car("uaz","green","4");
        Car buggy = new Car("buggy","red","2");
        Car garcia = new Car("garcia","red","4");
        Car bike = new Car("bike","yellow","2");
        List<Car> carList = new ArrayList<Car>();
        carList.add(uaz);
        carList.add(buggy);
        carList.add(garcia);
        carList.add(bike);
        System.out.println("原本的carList:");
        printCars(carList);

        //2.选出红色Car
        Filter redCarFilter = new RedCarFilter();
        System.out.println("红色车辆:");
        printCars(redCarFilter.filter(carList));

        //3.筛选出4轮车
        Filter num4Filter = new FourWheelerFilter();
        System.out.println("4轮车:");
        printCars(num4Filter.filter(carList));

        //4.筛选出红色或者4轮
        Filter redOrNum4Filter = new FilterOr(redCarFilter,num4Filter);
        System.out.println("红色或者4轮:");
        printCars(redOrNum4Filter.filter(carList));

        //5.筛选出红色并且4轮
        Filter redAndNum4Filter = new FilterAnd(redCarFilter,num4Filter);
        System.out.println("红色并且4轮:");
        printCars(redAndNum4Filter.filter(carList));
    }
    public static void printCars(List<Car> cars){
        for(Car car:cars){
            System.out.println(car.toString()+" ");
        }
        System.out.println("========================");

    }
```

输出：  
```
原本的carList:
Car{name='uaz', color='green', tyreNum='4'} 
Car{name='buggy', color='red', tyreNum='2'} 
Car{name='garcia', color='red', tyreNum='4'} 
Car{name='bike', color='yellow', tyreNum='2'} 
========================
红色车辆:
Car{name='buggy', color='red', tyreNum='2'} 
Car{name='garcia', color='red', tyreNum='4'} 
========================
4轮车:
Car{name='uaz', color='green', tyreNum='4'} 
Car{name='garcia', color='red', tyreNum='4'} 
========================
红色或者4轮:
Car{name='uaz', color='green', tyreNum='4'} 
Car{name='garcia', color='red', tyreNum='4'} 
Car{name='buggy', color='red', tyreNum='2'} 
========================
红色并且4轮:
Car{name='garcia', color='red', tyreNum='4'} 
========================
```
## 总结
过滤器通过filter方法得到我们所需要的List。我们可以指定多个Filter,也可以多个Filter各个逻辑相结合组成一个新的Filter。
