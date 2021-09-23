package com.catmmao.edu.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.entity.vo.PageTeacherConditionVo;
import com.catmmao.utils.data.response.PageResponse;
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

    /**
     * 更新讲师
     *
     * @param eduTeacher 讲师信息
     */
    void updateTeacher(EduTeacher eduTeacher);

    /**
     * 获取讲师
     *
     * @param id 讲师ID
     * @return 讲师信息
     */
    EduTeacher getTeacherById(String id);

    /**
     * 删除讲师
     *
     * @param id 讲师ID
     */
    void deleteTeacherById(String id);

    /**
     * 获取所有讲师(可筛选条件的分页查询)
     *
     * @param pageNum   当前第几页
     * @param pageSize  每页显示的数量
     * @param condition 筛选条件
     * @return 讲师列表
     */
    PageResponse<List<EduTeacher>> pageTeacherCondition(Integer pageNum, Integer pageSize,
                                                        PageTeacherConditionVo condition);
}

