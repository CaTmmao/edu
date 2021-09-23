package com.catmmao.edu.controller;


import java.util.List;
import javax.annotation.Resource;

import com.catmmao.edu.entity.EduTeacher;
import com.catmmao.edu.entity.vo.PageTeacherConditionVo;
import com.catmmao.edu.service.EduTeacherService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.data.response.PageResponse;
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

        eduTeacherService.createTeacher(eduTeacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(true));
    }

    /**
     * 更新讲师
     *
     * @param id         讲师ID
     * @param eduTeacher 讲师信息
     * @return 是否更新成功
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> updateTeacher(@PathVariable String id,
                                                                 @RequestBody EduTeacher eduTeacher) {

        eduTeacher.setId(id);
        eduTeacherService.updateTeacher(eduTeacher);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }

    /**
     * 获取讲师
     *
     * @param id 讲师ID
     * @return 讲师信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<EduTeacher>> getTeacher(@PathVariable String id) {

        EduTeacher data = eduTeacherService.getTeacherById(id);
        return ResponseEntity.ok(CommonResponse.ok(data));
    }

    /**
     * 删除讲师
     *
     * @param id 讲师ID
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> deleteTeacher(@PathVariable String id) {

        eduTeacherService.deleteTeacherById(id);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }

    /**
     * 获取所有讲师(可筛选条件的分页查询)
     *
     * @param pageNum   当前第几页
     * @param pageSize  每页显示的数量
     * @param condition 筛选条件
     * @return 讲师列表
     */
    @PostMapping("teachers/condition")
    public ResponseEntity<PageResponse<List<EduTeacher>>> pageTeacherCondition(@RequestParam Integer pageNum,
                                                                               @RequestParam Integer pageSize,
                                                                               @RequestBody(required = false)
                                                                                       PageTeacherConditionVo condition) {
        PageResponse<List<EduTeacher>> responseBody =
                eduTeacherService.pageTeacherCondition(pageNum, pageSize, condition);
        return ResponseEntity.ok(responseBody);
    }
}
