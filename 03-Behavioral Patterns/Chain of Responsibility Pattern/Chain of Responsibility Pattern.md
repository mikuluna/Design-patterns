# 责任链模式（Chain of Responsibility Pattern)
## 定义
在责任链模式里，很多对象由每一个对象对其下家的引用而连接起来形成一条链。请求在这个链上传递，直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，这使得系统可以在不影响客户端的情况下动态地重新组织链和分配责任。
### 需要考虑问题
- 抽象处理者 Handler
 - 定义一个请求的处理方法， HandleMessage, 对外开放的方法；
 - 定义链的编排方法 setNext, 设置下一个处理者；
 - 定义具体的请求者必须实现的两个方法：自己能够处理的级别 getHandleLevel 和具体的处理任务 echo;
- 具体处理者 ConcreteHandler
 - 定义自己的处理逻辑；
 - 设置自己的处理级别；
- 在场景类或高层模块中对链进行组装，并传递请求，并返回结果
## 代码
业务场景的话，比如请假，我们请假天数不同，需要上级签字也就不同;或者是个采购物品。
那我就以最常见的请假为例（网上看到最好的,作者lzy），给大家讲讲责任链模式的实现(包括其中的扩展)。
- 请假3天以下，需要跟TeamLeader申请批准。
- 请假3-5天，需要跟Manager申请批准（批准顺序：TeamLeader->Manager）
- 请假5天以上，需要跟DepartmentHeader申请批准（批准顺序：TeamLeader->Manager->DepartmentHeader）
### Request提出申请人
```
/**
 * 请假对象
 *
 */
public class Request {
    //姓名
    private String name;
    //请假理由
    private String reason;
    //请假天数
    private int days;
    //组长意见
    private String teamLeaderInfo;
    //经理意见
    private String managerInfo;
    //部门领导意见
    private String departmentHeaderInfo;
    //备注
    private String customInfo;

    public Request(Builder builder) {
        super();
        this.name = builder.name;
        this.reason = builder.reason;
        this.days = builder.days;
        this.teamLeaderInfo = builder.groupLeaderInfo;
        this.managerInfo = builder.managerInfo;
        this.departmentHeaderInfo = builder.departmentHeaderInfo;
        this.customInfo = builder.customInfo;
    }

    /**
     * 通过建造者模式构建请假对象
     */
    public static class Builder {
        public String name;
        public String reason;
        public int days;
        public String groupLeaderInfo;
        public String managerInfo;
        public String departmentHeaderInfo;
        public String customInfo;

        public Builder() {
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }
        public Builder setDays(int days) {
            this.days = days;
            return this;
        }
        public Builder setGroupLeaderInfo(String groupLeaderInfo) {
            this.groupLeaderInfo = groupLeaderInfo;
            return this;
        }
        public Builder setManagerInfo(String managerInfo) {
            this.managerInfo = managerInfo;
            return this;
        }
        public Builder setDepartmentHeaderInfo(String departmentHeaderInfo) {
            this.departmentHeaderInfo = departmentHeaderInfo;
            return this;
        }
        public Builder setCustomInfo(String customInfo) {
            this.customInfo = customInfo;
            return this;
        }
        public Builder newRequest(Request request) {
            this.name = request.name;
            this.days = request.days;
            this.reason = request.reason;
            if (request.teamLeaderInfo != null
                    && !request.teamLeaderInfo.equals("")) {
                this.groupLeaderInfo = request.teamLeaderInfo;
            }
            if (request.managerInfo != null && !request.managerInfo.equals("")) {
                this.managerInfo = request.managerInfo;
            }
            if (request.departmentHeaderInfo != null
                    && !request.departmentHeaderInfo.equals("")) {
                this.departmentHeaderInfo = request.departmentHeaderInfo;
            }
            if (request.customInfo != null && !request.customInfo.equals("")) {
                this.customInfo = request.customInfo;
            }
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
    public String name() {
        return name;
    }
    public String reason() {
        return reason;
    }
    public int days() {
        return days;
    }
    public String groupLeaderInfo() {
        return teamLeaderInfo;
    }
    public String managerInfo() {
        return managerInfo;
    }
    public String departmentHeaderInfo() {
        return departmentHeaderInfo;
    }
    public String customInfo() {
        return customInfo;
    }
    @Override
    public String toString() {
        return "Request [name=" + name + ", reason=" + reason + ", days="
                + days + ",customInfo=" + customInfo + ", groupLeaderInfo="
                + teamLeaderInfo + ", managerInfo=" + managerInfo
                + ", departmentHeaderInfo=" + departmentHeaderInfo + "]";
    }
}
```
### Result结果对象
```
/**
 * 结果对象
 */
public class Result {
    //是否批假
    public boolean isRatify;
    //备注
    public String info;
    public Result() {
    }
    public Result(boolean isRatify, String info) {
        super();
        this.isRatify = isRatify;
        this.info = info;
    }
    public boolean isRatify() {
        return isRatify;
    }
    public void setRatify(boolean isRatify) {
        this.isRatify = isRatify;
    }
    public String getReason() {
        return info;
    }
    public void setReason(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "Result [isRatify=" + isRatify + ", info=" + info + "]";
    }
}
```
### Ratify处理请求接口
```
/**
 * 处理请求
 */
public interface Ratify {
     // 处理请求
     public Result deal(Chain chain);

     /**
      * 对request和Result封装，用来转发
      */
     interface Chain {
          // 获取当前request
          Request request();

          // 转发request
          Result proceed(Request request);
     }
}
```
### RealChain(Ratify里的Chain接口的具体实现)
```
/**
 * 实现Chain的真正的包装Request和转发功能
 *
 */
public class RealChain implements Ratify.Chain {
     public Request request;
     public List<Ratify> ratifyList;
     public int index;

     /**
      * 构造方法
      *
      * @param ratifyList
      *            Ratify接口的实现类集合
      * @param request
      *            具体的请求Request实例
      * @param index
      *            已经处理过该request的责任人数量
      */
     public RealChain(List<Ratify> ratifyList, Request request, int index) {
          this.ratifyList = ratifyList;
          this.request = request;
          this.index = index;
     }
     /**
      * 方法描述：具体转发功能
      */
     @Override
     public Result proceed(Request request) {
          Result proceed = null;
          if (ratifyList.size() > index) {
              RealChain realChain = new RealChain(ratifyList, request, index + 1);
              Ratify ratify = ratifyList.get(index);
              proceed = ratify.deal(realChain);
          }
          return proceed;
     }
     /**
      * 方法描述：返回当前Request对象或者返回当前进行包装后的Request对象
      */
     @Override
     public Request request() {
          return request;
     }
}
```
## 总结
- 优点
 - 降低耦合度
 - 该模式使得一个对象无需知道是其他哪一个对象一个指向其后继者的引用，而不需保持它所有的后选者的引用；
 - 责任链可简化对象的相互连接。它们仅需保持一个指向其后继者的引用，而不需保持它所有的候选接受者的引用。
 - 增强了给对象指派职责（Responsibility）的灵活性
可以通过在运行时刻对该链进行动态的增加或修改来增加改变处理一个请求的那些职责。

- 缺点
 - 不能保证被接受
 - 请求没有明确的接收者，该请求可能一直到链的末端都得不到处理；也可能因该链没有被正确配置而得不到处理。