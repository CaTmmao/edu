package com.catmmao.edu.data.response;

import java.util.Collections;
import java.util.List;

// 分页响应数据
public class PageResponse<T> extends CommonResponse<T> {
    // 每页显示的数量（默认是 10）
    private Integer pageSize;

    // 当前第几页，从 1 开始（默认是 1）
    private Integer pageNum;

    // 共有多少页
    private Integer totalPage;

    public static <T> PageResponse<T> pageOk(Integer pageSize, Integer pageNum,
                                         Integer totalPage, T data) {
        PageResponse<T> result = new PageResponse<>();
        result.setPageSize(pageSize);
        result.setPageNum(pageNum);
        result.setTotalPage(totalPage);
        result.setData(data);
        return result;
    }

    public static PageResponse<List<?>> pageError(String code, String message) {
        PageResponse<List<?>> result = new PageResponse<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(Collections.emptyList());
        return result;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
