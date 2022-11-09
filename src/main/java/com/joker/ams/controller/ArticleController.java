package com.joker.ams.controller;

import com.joker.ams.common.ResultVo;
import com.joker.ams.entity.AmsArticle;
import com.joker.ams.service.AmsArticleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("article")
public class ArticleController {
    @Resource
    AmsArticleService articleService;
    @PreAuthorize("hasAnyAuthority('article:list')")
    @GetMapping("/getArticleByCurrent")
    public ResultVo getArticleByCurrent(Integer page, Integer size, Integer user_id) {
        return articleService.getArticleByCurrent(page, size, user_id);
    }

    @GetMapping("/queryArticleById")
    public ResultVo getArticleById(Integer articleId) {
        return articleService.queryArticleById(articleId);
    }


    @PreAuthorize("hasAnyAuthority('article:insert')")
    @PostMapping("/insertArticle")
    public ResultVo addArticle(@RequestBody AmsArticle article) {
        return articleService.insertArticle(article);
    }

    @PreAuthorize("hasAnyAuthority('article:update')")
    @PutMapping("/updateArticle")
    public ResultVo updateArticle(@RequestBody AmsArticle article) {
        return articleService.updateArticle(article);
    }


    @PreAuthorize("hasAnyAuthority('article:delete')")
    @DeleteMapping("/delete")
    public ResultVo deleteArticle(Integer articleId) {
        return articleService.deleteById(articleId);
    }



}
