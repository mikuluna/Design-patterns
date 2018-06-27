package com.luna.responsibilityPattern;

import com.luna.responsibilityPattern.mode.Request;

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
