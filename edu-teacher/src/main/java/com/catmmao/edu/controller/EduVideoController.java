package com.catmmao.edu.controller;

import com.catmmao.edu.service.EduVideoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 课程视频(EduVideo)表控制层
 *
 * @author catmmao
 * @since 2021-08-18 19:21:11
 */
@RestController
@CrossOrigin
@RequestMapping("")
public class EduVideoController {
    @Resource
    private EduVideoService eduVideoService;
}

