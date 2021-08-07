package com.catmmao.edu.controller;


import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catmmao.edu.data.response.CommonResponse;
import com.catmmao.edu.data.response.PageResponse;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.service.EduTeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 获取所有老师(可筛选条件的分页查询)
     *
     * @param pageNum                当前第几页
     * @param pageSize               每页显示的数量
     * @param pageTeacherRequestBody 筛选条件
     * @return 老师列表
     */
    @PostMapping("teachers/condition")
    public ResponseEntity<PageResponse<List<EduTeacher>>> pageTeacherCondition(@RequestParam Integer pageNum,
                                                                               @RequestParam Integer pageSize,
                                                                               @RequestBody
                                                                                   PageTeacherConditionRequestBody pageTeacherRequestBody) {
        String name = pageTeacherRequestBody.getName();
        String begin = pageTeacherRequestBody.getBegin();
        String end = pageTeacherRequestBody.getEnd();
        Integer level = pageTeacherRequestBody.getLevel();

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (name != null) {
            wrapper.like("name", name);
        }
        if (begin != null) {
            wrapper.ge("create_time", begin);
        }
        if (end != null) {
            wrapper.le("create_time", end);
        }
        if (level != null) {
            wrapper.eq("level", level);
        }

        Page<EduTeacher> pageTeacher = new Page<>(pageNum, pageSize);
        eduTeacherService.page(pageTeacher, wrapper);
        pageSize = (int) pageTeacher.getSize();
        pageNum = (int) pageTeacher.getCurrent();
        Integer total = (int) pageTeacher.getTotal();
        Integer totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        PageResponse<List<EduTeacher>> responseBody =
            PageResponse.pageOk(pageSize, pageNum, totalPage, pageTeacher.getRecords());

        return ResponseEntity.ok(responseBody);
    }

    // 可筛选条件的分页查询接口的请求体对象
    static class PageTeacherConditionRequestBody {
        private String begin;
        private String end;
        private String name;
        private Integer level;

        public String getBegin() {
            return begin;
        }

        public void setBegin(String begin) {
            this.begin = begin;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }
    }
}
