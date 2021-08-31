package com.catmmao.edu.controller;

import java.util.List;
import javax.annotation.Resource;

import com.catmmao.edu.data.response.CommonResponse;
import com.catmmao.edu.data.response.PageResponse;
import com.catmmao.edu.entity.EduCourse;
import com.catmmao.edu.entity.vo.CourseCompleteInfoVo;
import com.catmmao.edu.entity.vo.PageCourseRequestBody;
import com.catmmao.edu.service.EduCourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程(EduCourse)表控制层
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@RestController
@CrossOrigin
@RequestMapping("/service/course")
public class EduCourseController {
    @Resource
    private EduCourseService eduCourseService;

    @PostMapping
    public ResponseEntity<CommonResponse<Boolean>> addCourse(@RequestBody CourseCompleteInfoVo data) {
        eduCourseService.addCourse(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(true));
    }

    /**
     * 获取所有课程(可筛选条件的分页查询)
     *
     * @param pageNum   当前第几页
     * @param pageSize  每页显示的数量
     * @param condition 筛选条件
     * @return 课程列表
     */
    @PostMapping("list/condition")
    public ResponseEntity<PageResponse<List<EduCourse>>> pageCourseCondition(@RequestParam Integer pageNum,
                                                                             @RequestParam Integer pageSize,
                                                                             @RequestBody(required = false)
                                                                                     PageCourseRequestBody condition) {
        PageResponse<List<EduCourse>> responseBody = eduCourseService.pageCourseCondition(pageNum, pageSize, condition);
        return ResponseEntity.ok(responseBody);
    }
}

