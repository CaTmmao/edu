package com.catmmao.edu.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 课程视频(EduVideo)实体类
 *
 * @author catmmao
 * @since 2021-08-27 21:27:32
 */
public class EduVideo extends Model<EduVideo> implements Serializable {
    private static final long serialVersionUID = -56686980500724622L;

    // 更新时间    
    private Date updateTime;

    // 创建时间    
    private Date createTime;

    // 乐观锁    
    private Long version;

    // 视频源文件大小（字节）    
    private Long size;

    // empty未上传 transcoding转码中  normal正常    
    private String status;

    // 视频时长（秒）    
    private Object duration;

    // 是否可以试听：0收费 1免费    
    private Boolean isFree;

    // 播放次数    
    private Long playCount;

    // 排序字段    
    private Integer sort;

    // 原始文件名称    
    private String videoOriginalName;

    // 云端视频资源    
    private String vodId;

    // 视频名称    
    private String title;

    // 章节id    
    private String chapterId;

    // 课程id    
    private String courseId;

    // 视频id    
    private String id;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDuration() {
        return duration;
    }

    public void setDuration(Object duration) {
        this.duration = duration;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getVideoOriginalName() {
        return videoOriginalName;
    }

    public void setVideoOriginalName(String videoOriginalName) {
        this.videoOriginalName = videoOriginalName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVodId() {
        return vodId;
    }

    public void setVodId(String vodId) {
        this.vodId = vodId;
    }
}
