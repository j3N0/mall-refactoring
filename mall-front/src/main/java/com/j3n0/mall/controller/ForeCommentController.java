package com.j3n0.mall.controller;

import com.j3n0.mall.model.ForeCommentParam;
import com.j3n0.mall.service.ForeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForeCommentController {

    @Autowired
    ForeCommentService foreCommentService;

    @PostMapping("/fore/users/{uid}/comments")
    public String createComment(@RequestBody ForeCommentParam param, @PathVariable Long uid) {
        int count = foreCommentService.createComment(param, uid);
        if (count > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
