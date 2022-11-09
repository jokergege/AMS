package com.joker.ams.service;

import com.joker.ams.common.ResultVo;
import com.joker.ams.entity.AmsArticle;

/**
 * (AmsArticle)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public interface AmsArticleService {

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @param user_id
     * @return
     */
    ResultVo getArticleByCurrent(Integer page, Integer size, Integer user_id);

    ResultVo queryArticleById(Integer article_id);

    ResultVo insertArticle(AmsArticle article);

    ResultVo updateArticle(AmsArticle article);


    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    ResultVo deleteById(Integer articleId);


}
