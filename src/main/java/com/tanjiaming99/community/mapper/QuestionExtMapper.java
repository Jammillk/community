package com.tanjiaming99.community.mapper;

import com.tanjiaming99.community.model.Question;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 18:54
 **/

public interface QuestionExtMapper {
    int incView(Question recode);
    int incCommentCount(Question recode);
}
