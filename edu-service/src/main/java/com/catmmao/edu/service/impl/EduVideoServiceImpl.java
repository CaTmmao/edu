package com.catmmao.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catmmao.edu.dao.mapper.EduVideoMapper;
import com.catmmao.edu.entity.EduVideo;
import com.catmmao.edu.service.EduVideoService;
import org.springframework.stereotype.Service;

/**
 * 课程视频(EduVideo)表服务实现类
 *
 * @author catmmao
 * @since 2021-08-18 19:21:45
 */
@Service("eduVideoService")
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

}

