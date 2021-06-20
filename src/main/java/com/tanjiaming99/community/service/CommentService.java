package com.tanjiaming99.community.service;

import com.tanjiaming99.community.enums.CommentTypeEnum;
import com.tanjiaming99.community.exception.CustomizeErrorCode;
import com.tanjiaming99.community.exception.CustomizeException;
import com.tanjiaming99.community.mapper.CommentMapper;
import com.tanjiaming99.community.mapper.QuestionExtMapper;
import com.tanjiaming99.community.mapper.QuestionMapper;
import com.tanjiaming99.community.model.Comment;
import com.tanjiaming99.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/19 10:08
 **/
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;


    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARENT_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            // 回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            // 回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            // 这里没有事务操作
            // 插入评论
            commentMapper.insert(comment);
            // 增加回复数
            // 传进去的数就是加上的数……
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
