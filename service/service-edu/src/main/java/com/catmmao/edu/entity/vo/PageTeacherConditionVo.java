package com.catmmao.edu.entity.vo;

/**
 * @author catmmao
 * @since 2021/9/23 下午8:25
 */
public class PageTeacherConditionVo {
    // 讲师被创建的开始时间
    private String begin;
    // 讲师被创建的结束时间
    private String end;
    // 讲师名字
    private String name;
    // 讲师头衔
    private Integer level;

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
