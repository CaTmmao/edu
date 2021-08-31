package com.catmmao.edu.entity.vo;

import java.util.List;

public class CourseCompleteInfoVo {
    CourseAndDescriptionVo courseBaseInfo;
    List<ChapterVo> chapterList;

    public CourseAndDescriptionVo getCourseBaseInfo() {
        return courseBaseInfo;
    }

    public void setCourseBaseInfo(CourseAndDescriptionVo courseBaseInfo) {
        this.courseBaseInfo = courseBaseInfo;
    }

    public List<ChapterVo> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<ChapterVo> chapterList) {
        this.chapterList = chapterList;
    }
}
