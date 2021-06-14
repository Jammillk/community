package com.tanjiaming99.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/13 19:33
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginationDTO {

    private List<QuestionDTO> questions;
    /**
     * 是否有前页
     */
    private boolean showPrevious;
    /**
     * 展示最前页按钮
     */
    private boolean showFirstPage;
    /**
     * 展示下一页按钮
     */
    private boolean showNext;
    /**
     * 展示最后页面
     */
    private boolean showEndPage;
    /**
     * 当前页
     */
    private Integer currentPage;

    private List<Integer> pages = new ArrayList<>();

    private Integer totalPage;

    /**
     * 业务逻辑在此判断
     *
     * @param totalCount
     * @param page
     * @param size
     */
    public void setPagination(Integer totalCount, Integer page, Integer size) {

        // 总页数
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        this.currentPage = page;

        pages.add(page);
        for (int i = 1; i < 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 在第一页的时候就没有第一个，否则就可以到第一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        // 是否展示下一页
        if (totalPage.equals(page)) {
            showNext = false;
        } else {
            showNext = true;
        }
        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
