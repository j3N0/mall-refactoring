package com.j3n0.mall.service.impl;

import com.j3n0.mall.model.*;
import com.j3n0.mall.repository.CommentRepository;
import com.j3n0.mall.repository.OrderItemRepository;
import com.j3n0.mall.service.ForeCommentService;
import com.j3n0.mall.service.ForeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ForeCommentServiceImpl implements ForeCommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ForeProductService foreProductService;

    @Override
    public int createComment(ForeCommentParam param, Long uid) {
        int count;
        // Todo 异常处理
        OrderItem orderItem = orderItemRepository.findById(param.getOrderItemId())
                .orElseThrow(RuntimeException::new);
        Product product = orderItem.getProduct();
        // 新建评论
        Comment comment = new Comment();
        comment.setContent(param.getContent());
        comment.setPid(product.getId());
        comment.setUid(uid);
        comment.setCreateDate(new Date());
        // comment 存入数据库
        commentRepository.save(comment);
        // 0 -> 未评价, 1 -> 已评价
        orderItem.setCommentStatus(1);
        orderItemRepository.save(orderItem);
        // 更新 产品评论数 Todo 并发问题
        int commentNum = product.getCommentsNum();
        product.setCommentsNum(commentNum + 1);
        foreProductService.update(product.getId(), product);
        count = 1;
        return count;
    }
}
