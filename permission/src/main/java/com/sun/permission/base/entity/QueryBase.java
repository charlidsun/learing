package com.sun.permission.base.entity;

import lombok.Data;

/**
 *  类描述：查询基础类
 * @author Administrator
 *
 */
@Data
public class QueryBase {
 
	// 要排序的字段名
    protected String sort;
    // 排序方式: desc \ asc 
    protected String order = "";
    // 获取一页行数
    protected int limit;
    // 获取的页码 
    protected int page;
    // 起始记录
    protected int offset;

 
    public int getOffset() {
        return (this.page-1)*limit;
    }
 

}
