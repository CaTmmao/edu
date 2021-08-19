package com.catmmao.edu.controller;

import javax.annotation.Resource;

import com.catmmao.edu.entity.data.CourseCompleteInfo;
import com.catmmao.edu.data.response.CommonResponse;
import com.catmmao.edu.service.EduCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程(EduCourse)表控制层
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@RestController
@CrossOrigin
@RequestMapping("/course")
public class EduCourseController {
    @Resource
    private EduCourseService eduCourseService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> addCourse(@RequestBody CourseCompleteInfo data) {
        boolean result = eduCourseService.addCourse(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(result));
    }
}

