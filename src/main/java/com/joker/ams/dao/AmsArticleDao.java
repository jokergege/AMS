package com.joker.ams.dao;

import com.joker.ams.entity.AmsArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AmsArticle)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:35
 */

public interface AmsArticleDao {

    AmsArticle getMaxStarArticle();

    List<AmsArticle> getMoreStarArticles();

    List<AmsArticle> getArticleList(@Param("user_id") Integer user_id, @Param("start") int start, @Param("size") Integer size);

    int getArticleCount(@Param("user_id") Integer user_id);

    AmsArticle queryArticleById(Integer article_id);

    Integer insertArticle(AmsArticle article);

    Integer updateArticle(AmsArticle article);

    Integer deleteById(Integer articleId);
}

