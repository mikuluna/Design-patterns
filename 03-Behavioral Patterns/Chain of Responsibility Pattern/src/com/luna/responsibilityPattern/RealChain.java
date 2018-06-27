package com.luna.responsibilityPattern;

import com.luna.responsibilityPattern.mode.Request;

import java.util.List;

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
