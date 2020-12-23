package org.myProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http响应json数据，前后端统一约定的json格式
 * 响应码都为200，进入Ajax的success使用
 * 成功：(success:true.data,xxx)
 * 错误：(success:false.data,xxx)
 */
@Getter
@Setter
@ToString

public class JSONResponse {
    //业务操作是否成功
    private boolean success;
    //业务操作的消息码，出现错误时的错误码才有意义，给开发人员定位问题使用
    private String code;
    //业务操作的错误信息，给客户看
    private String message;
    //业务数据，成功时，给前端Ajax success使用，响应json数据,渲染网页内容
    private Object data;
}
