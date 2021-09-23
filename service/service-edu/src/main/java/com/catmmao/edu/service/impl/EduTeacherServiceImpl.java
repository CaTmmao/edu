package com.catmmao.edu.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduTeacherMapper;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.entity.vo.PageTeacherConditionVo;
import com.catmmao.edu.service.EduTeacherService;
import com.catmmao.utils.data.response.PageResponse;
import com.catmmao.utils.exception.HttpException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 讲师(EduTeacher)表服务实现类
 *
 * @author catmmao
 * @since 2021-07-28 21:26:20
 */
@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Cacheable(key = "'getHotTeacherList'", value = "teacher")
    @Override
    public List<EduTeacher> getHotTeacherList() {

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        wrapper.last("limit 4");
        return list(wrapper);
    }

    @Override
    public void createTeacher(EduTeacher eduTeacher) {

        if (!save(eduTeacher)) {
            throw HttpException.databaseError("创建失败");
        }
    }

    @Override
    public void updateTeacher(EduTeacher eduTeacher) {

        if (!updateById(eduTeacher)) {
            throw HttpException.databaseError("更新失败");
        }
    }

    @Override
    public EduTeacher getTeacherById(String id) {

        EduTeacher result = getById(id);
        if (result == null) {
            throw HttpException.resourceNotFound("找不到该讲师");
        }

        return result;
    }

    @Override
    public void deleteTeacherById(String id) {

        if (!removeById(id)) {
            throw HttpException.databaseError("删除失败");
        }
    }

    @Override
    public PageResponse<List<EduTeacher>> pageTeacherCondition(Integer pageNum, Integer pageSize,
                                                               PageTeacherConditionVo condition) {


        Page<EduTeacher> pageTeacher = new Page<>(pageNum, pageSize);

        if (condition != null) {
            String name = condition.getName();
            String begin = condition.getBegin();
            String end = condition.getEnd();
            Integer level = condition.getLevel();

            QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
            if (!Strings.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!Strings.isEmpty(begin)) {
                wrapper.ge("create_time", begin);
            }
            if (!Strings.isEmpty(end)) {
                wrapper.le("create_time", end);
            }
            if (level != null) {
                wrapper.eq("level", level);
            }

            page(pageTeacher, wrapper);
        } else {
            page(pageTeacher);
        }

        pageSize = (int) pageTeacher.getSize();
        pageNum = (int) pageTeacher.getCurrent();
        Integer total = (int) pageTeacher.getTotal();
        Integer totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        return PageResponse.pageOk(pageSize, pageNum, total, totalPage, pageTeacher.getRecords());
    }
}

