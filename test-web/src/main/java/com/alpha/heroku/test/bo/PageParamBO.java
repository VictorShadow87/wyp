package com.alpha.heroku.test.bo;

import lombok.Data;

/**
 * 分页查询参数
 * @date 2018年4月24日
 */
@Data
public class PageParamBO {
  public static transient final Integer DEFAULT_PAGE_SIZE = 10;
  private Integer pageIndex = 1;
  private Integer pageSize = 10;

  public int getOffset() {
    return getPageIndex() * getPageSize();
  }

  public void setPageIndex(int page) {
    if(page < 0) {
      this.pageIndex = 0;
    }else{
      this.pageIndex = page;
    }
  }
  public void setPageSize(int pageSize) {
    if(pageSize < 0) {
      this.pageSize = DEFAULT_PAGE_SIZE;
    }else{
      this.pageSize = pageSize;
    }
  }

  public int getPageIndex() {
    if(pageIndex < 1) {
      pageIndex = 1;
    }
    return pageIndex;
  }

  public int getPageSize() {
    if(pageSize <= 0) {
      pageSize = DEFAULT_PAGE_SIZE;
    }
    return pageSize;
  }
}