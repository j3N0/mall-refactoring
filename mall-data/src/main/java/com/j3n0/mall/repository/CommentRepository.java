package com.j3n0.mall.repository;

import com.j3n0.mall.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPid(Long pid);
}
