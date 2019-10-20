package com.keepzzz.film.controller.admin;

import com.keepzzz.film.base.ApiResponse;
import com.keepzzz.film.enums.Status;
import com.keepzzz.film.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/api/v1/comment")
public class CommentAdminController {


    @Autowired
    private CommentService commentService;

    /**
     * 删除单条评论
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse deleteComment(@PathVariable("id") long id){
        boolean flag = commentService.deleteComments(id);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }

    /**
     * 批量删除评论
     * @param ids
     * @return
     */
    @DeleteMapping("/delAll")
    public ApiResponse deleteComments(@RequestBody Long[] ids){
        boolean flag = commentService.deleteBatchComment(ids);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }
}
