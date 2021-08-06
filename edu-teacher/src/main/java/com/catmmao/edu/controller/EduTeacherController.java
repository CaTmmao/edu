package com.catmmao.edu.controller;


import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

import com.catmmao.edu.data.response.CommonResponse;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.service.EduTeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 讲师(EduTeacher)表控制层
 *
 * @author catmmao
 * @since 2021-07-28 21:26:20
 */
@RestController
@RequestMapping("/teacher")
public class EduTeacherController {
    @Resource
    private EduTeacherService eduTeacherService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<EduTeacher>>> getAllTeachers() {
        return ResponseEntity.of(Optional.of(CommonResponse.ok(eduTeacherService.list())));
    }

    /**
     * 删除老师
     *
     * @param id 老师ID
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> deleteTeacher(@PathVariable String id) {
        return ResponseEntity.of(Optional.of(CommonResponse.ok(eduTeacherService.removeById(id))));
    }
}
