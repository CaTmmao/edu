package com.catmmao.edu.controller;


import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.service.EduTeacherService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.data.response.PageResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping("/service/teacher")
@CrossOrigin
public class EduTeacherController {
    @Resource
    private EduTeacherService eduTeacherService;

    /**
     * 获取热门老师列表
     *
     * @return 热门老师列表
     */
    @GetMapping("/front/index/hot/list")
    public ResponseEntity<CommonResponse<List<EduTeacher>>> getHotTeacherList() {

        List<EduTeacher> data = eduTeacherService.getHotTeacherList();
        return ResponseEntity.ok(CommonResponse.ok(data));
    }

    /**
     * 获取讲师列表
     *
     * @return 所有讲师
     */
    @GetMapping("/all")
    public ResponseEntity<CommonResponse<List<EduTeacher>>> getTeacherList() {
        List<EduTeacher> data = eduTeacherService.list();
        return ResponseEntity.ok(CommonResponse.ok(data));
    }

    /**
     * 创建讲师
     *
     * @param eduTeacher 讲师信息
     * @return 是否创建成功
     */
    @PostMapping
    public ResponseEntity<CommonResponse<?>> createTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean isSuccess = eduTeacherService.save(eduTeacher);
        CommonResponse<?> responseBody = isSuccess ? CommonResponse.ok(null) : CommonResponse.error("创建失败");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponse<?>> updateTeacher(@PathVariable String id,
                                                           @RequestBody EduTeacher eduTeacher) {
        eduTeacher.setId(id);
        boolean isSuccess = eduTeacherService.updateById(eduTeacher);

        CommonResponse<?> responseBody = isSuccess ? CommonResponse.ok(null) : CommonResponse.error("更新失败");
        return ResponseEntity.ok(responseBody);
    }

    /**
     * 获取讲师
     *
     * @param id 讲师ID
     * @return 讲师信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<EduTeacher>> getTeacher(@PathVariable String id) {
        EduTeacher teacher = eduTeacherService.getById(id);
        CommonResponse<EduTeacher> responseBody = CommonResponse.ok(teacher);
        return ResponseEntity.ok(responseBody);
    }

    /**
     * 删除讲师
     *
     * @param id 讲师ID
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> deleteTeacher(@PathVariable String id) {
        return ResponseEntity.of(Optional.of(CommonResponse.ok(eduTeacherService.removeById(id))));
    }

    /**
     * 获取所有讲师(可筛选条件的分页查询)
     *
     * @param pageNum                当前第几页
     * @param pageSize               每页显示的数量
     * @param pageTeacherRequestBody 筛选条件
     * @return 讲师列表
     */
    @PostMapping("teachers/condition")
    public ResponseEntity<PageResponse<List<EduTeacher>>> pageTeacherCondition(@RequestParam Integer pageNum,
                                                                               @RequestParam Integer pageSize,
                                                                               @RequestBody(required = false)
                                                                                       PageTeacherConditionRequestBody pageTeacherRequestBody) {
        Page<EduTeacher> pageTeacher = new Page<>(pageNum, pageSize);

        if (pageTeacherRequestBody != null) {
            String name = pageTeacherRequestBody.getName();
            String begin = pageTeacherRequestBody.getBegin();
            String end = pageTeacherRequestBody.getEnd();
            Integer level = pageTeacherRequestBody.getLevel();

            QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
            if (!Strings.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!Strings.isEmpty(begin)) {
                wrapper.ge("create_time", begin);
            }
            if (!Strings.isEmpty(end)) {
                wrapper.le("create_time", end);
            }
            if (level != null) {
                wrapper.eq("level", level);
            }

            eduTeacherService.page(pageTeacher, wrapper);
        } else {
            eduTeacherService.page(pageTeacher);
        }

        pageSize = (int) pageTeacher.getSize();
        pageNum = (int) pageTeacher.getCurrent();
        Integer total = (int) pageTeacher.getTotal();
        Integer totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        PageResponse<List<EduTeacher>> responseBody =
                PageResponse.pageOk(pageSize, pageNum, total, totalPage, pageTeacher.getRecords());

        return ResponseEntity.ok(responseBody);
    }

    // 可筛选条件的分页查询接口的请求体对象
    static class PageTeacherConditionRequestBody {
        // 讲师被创建的开始时间
        private String begin;
        // 讲师被创建的结束时间
        private String end;
        // 讲师名字
        private String name;
        // 讲师头衔
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
