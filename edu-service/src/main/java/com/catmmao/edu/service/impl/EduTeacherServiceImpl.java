package com.catmmao.edu.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduTeacherMapper;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.service.EduTeacherService;
import org.springframework.stereotype.Service;

/**
 * 讲师(EduTeacher)表服务实现类
 *
 * @author catmmao
 * @since 2021-07-28 21:26:20
 */
@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public List<EduTeacher> getHotTeacherList() {

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        wrapper.last("limit 4");
        return list(wrapper);
    }
}

