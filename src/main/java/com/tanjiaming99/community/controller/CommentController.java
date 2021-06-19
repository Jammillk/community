package com.tanjiaming99.community.controller;

import com.tanjiaming99.community.dto.CommentDTO;
import com.tanjiaming99.community.dto.ResultDTO;
import com.tanjiaming99.community.exception.CustomizeErrorCode;
import com.tanjiaming99.community.mapper.CommentMapper;
import com.tanjiaming99.community.model.Comment;
import com.tanjiaming99.community.model.User;
import com.tanjiaming99.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 20:26
 **/
@Controller
public class CommentController {



    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,// 自动反序列化传入的JSON字符串
                       HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
