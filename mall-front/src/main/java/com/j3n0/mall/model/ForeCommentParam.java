package com.j3n0.mall.model;

import lombok.Data;

@Data
public class ForeCommentParam {

    private Long orderItemId;

    private Long pid;

    private String content;
}
