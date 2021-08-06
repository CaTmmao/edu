package com.catmmao.edu.controller;


import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catmmao.edu.data.response.CommonResponse;
import com.catmmao.edu.data.response.PageResponse;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.service.EduTeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 获取所有老师
     *
     * @param pageNum  当前第几页
     * @param pageSize 每页显示的数量
     * @return 老师列表
     */
    @GetMapping("/teachers")
    public ResponseEntity<PageResponse<List<EduTeacher>>> pageTeacher(@RequestParam Integer pageNum,
                                                                      @RequestParam Integer pageSize) {
        Page<EduTeacher> pageTeacher = new Page<>(pageNum, pageSize);
        eduTeacherService.page(pageTeacher);
        pageSize = (int) pageTeacher.getSize();
        pageNum = (int) pageTeacher.getCurrent();
        Integer total = (int) pageTeacher.getTotal();
        Integer totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        PageResponse<List<EduTeacher>> responseBody =
            PageResponse.pageOk(pageSize, pageNum, totalPage, pageTeacher.getRecords());

        return ResponseEntity.ok(responseBody);
    }
}
