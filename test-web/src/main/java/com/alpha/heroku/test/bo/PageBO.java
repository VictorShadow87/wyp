package com.alpha.heroku.test.bo;

import com.alpha.heroku.test.utils.convert.AutoMapper;
import com.github.pagehelper.Page;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PageBO<T> {

    @SuppressWarnings({"rawtypes", "unchecked"})
    static PageBO EMPTY = new PageBO(1, 0, 0, Collections.emptyList());

    /**
     * 页码，从1开始
     */
    private int pageIndex = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 总数
     */
    private long total;

    private Integer totalPage;

    /**
     * 列表数据
     */
    private List<T> items;

    public PageBO() {
    }

    public PageBO(int pageIndex, int pageSize, long total, List<T> items) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.items = items;
    }

    public PageBO(Page page, Class<T> classz) {
        this.totalPage = page.getPages();
        this.pageIndex = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.items = AutoMapper.mapList(page, classz);
    }
}