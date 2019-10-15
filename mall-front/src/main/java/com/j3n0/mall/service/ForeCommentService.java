package com.j3n0.mall.service;

import com.j3n0.mall.model.ForeCommentParam;

public interface ForeCommentService {

    int createComment(ForeCommentParam param, Long uid);
}
