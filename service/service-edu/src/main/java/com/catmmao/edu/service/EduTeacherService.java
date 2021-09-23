package com.catmmao.edu.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduTeacher;
import org.springframework.stereotype.Service;

/**
 * 讲师(EduTeacher)表服务接口
 *
 * @author catmmao
 * @since 2021-07-28 21:26:20
 */
@Service
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 获取热门老师列表
     *
     * @return 热门老师列表
     */
    List<EduTeacher> getHotTeacherList();

    /**
     * 创建讲师
     *
     * @param eduTeacher 讲师信息
     */
    void createTeacher(EduTeacher eduTeacher);
}

