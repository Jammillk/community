package com.tanjiaming99.community.service;

import com.tanjiaming99.community.dto.QuestionDTO;
import com.tanjiaming99.community.mapper.QuestionMapper;
import com.tanjiaming99.community.mapper.UserMapper;
import com.tanjiaming99.community.model.Question;
import com.tanjiaming99.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/13 15:44
 * 它是可以组装QuestionMapper和UserMapper的数据
 * 一个中间层的概念，而不是无用地添加一层
 * 想要把数据放到首页，但是QuestionMapper没有头像信息，头像信息在UserMapper中
 * 这种外键查询，组合数据的情况就在此完成
 **/
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            User user = userMapper.findById(question.getCreator());
            System.out.println(user);
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            System.out.println(questionDTO);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
