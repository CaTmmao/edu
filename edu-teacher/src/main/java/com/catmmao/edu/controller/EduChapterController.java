package com.catmmao.edu.controller;

import com.catmmao.edu.service.EduChapterService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 课程(EduChapter)表控制层
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@RestController
@CrossOrigin
@RequestMapping("")
public class EduChapterController {
    @Resource
    private EduChapterService eduChapterService;
}

