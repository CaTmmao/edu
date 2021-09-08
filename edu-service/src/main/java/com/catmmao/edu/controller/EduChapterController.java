package com.catmmao.edu.controller;

import java.util.List;
import javax.annotation.Resource;

import com.catmmao.edu.entity.EduChapter;
import com.catmmao.edu.entity.vo.ChapterVo;
import com.catmmao.edu.service.EduChapterService;
import com.catmmao.utils.data.response.CommonResponse;
import com.catmmao.utils.exception.HttpException;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程章节(EduChapter)表控制层
 *
 * @author catmmao
 * @since 2021-08-18 19:17:47
 */
@RestController
@CrossOrigin
@RequestMapping("/service/chapter")
public class EduChapterController {

    @Resource
    private EduChapterService eduChapterService;

    /**
     * 获取包含视频列表的章节列表
     *
     * @param courseId 课程ID
     * @return 包含视频列表的章节列表
     */
    @GetMapping("/list/{courseId}")
    public ResponseEntity<CommonResponse<List<ChapterVo>>> getChapterListWithVideoListByCourseId(
            @PathVariable String courseId) {

        List<ChapterVo> data = eduChapterService.getChapterListWithVideoListByCourseId(courseId);
        return ResponseEntity.ok(CommonResponse.ok(data));
    }

    /**
     * 删除章节
     *
     * @param id 章节ID
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> deleteChapterById(@PathVariable String id) {

        eduChapterService.deleteChapterById(id);
        return ResponseEntity.ok(CommonResponse.ok(true));
    }

    /**
     * 添加章节
     *
     * @param chapter 章节信息
     * @return 是否成功
     */
    @PostMapping
    public ResponseEntity<CommonResponse<Boolean>> addChapter(@RequestBody EduChapter chapter) {
        if (chapter.getCourseId() == null) {
            throw HttpException.badRequest("未传入 courseId");
        }
        eduChapterService.addChapter(chapter);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(true));
    }

    /**
     * 更新章节
     *
     * @param id      章节ID
     * @param chapter 章节信息
     * @return 是否更新成功
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponse<Boolean>> updateChapterById(@PathVariable String id,
                                                                     @RequestBody EduChapter chapter) {

        eduChapterService.updateChapterById(id, chapter);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(true));
    }
}
