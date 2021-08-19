package com.catmmao.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduChapterMapper;
import com.catmmao.edu.entity.EduChapter;
import com.catmmao.edu.service.EduChapterService;
import org.springframework.stereotype.Service;

/**
 * 课程(EduChapter)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:44
 */
@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

}

