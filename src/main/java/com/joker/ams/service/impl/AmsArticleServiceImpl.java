package com.joker.ams.service.impl;

import com.joker.ams.common.LoginUser;
import com.joker.ams.common.ResultVo;
import com.joker.ams.dao.AmsArticleDao;
import com.joker.ams.dao.AmsSortDao;
import com.joker.ams.entity.AmsArticle;
import com.joker.ams.entity.AmsUser;
import com.joker.ams.service.AmsArticleService;
import com.joker.ams.utils.RedisCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * (AmsArticle)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
@Service("amsArticleService")
public class AmsArticleServiceImpl implements AmsArticleService {
    @Resource
    private AmsArticleDao articleDao;
    @Resource
    private AmsSortDao sortDao;
    @Resource
    RedisCache redisCache;

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @param user_id
     * @return
     */
    @Override
    public ResultVo getArticleByCurrent(Integer page, Integer size, Integer user_id) {
        HashMap<String, Object> map = new HashMap<>();
        LoginUser loginUser = redisCache.getCacheObject("login:" + user_id);
        AmsUser amsUser = loginUser.getUser();
        // userType为2 是管理员
        // userType为1 是作者或者游客
        if (!amsUser.getUserType().equals("2")) {
            map.put("articles", articleDao.getArticleList(user_id, (page - 1) * size, size));
            map.put("totalCount", articleDao.getArticleCount(user_id));
        } else {
            map.put("articles", articleDao.getArticleList(null, (page - 1) * size, size));
            map.put("totalCount", articleDao.getArticleCount(null));
        }
        return new ResultVo(200, "success", map);

    }

    /**
     * 根据id查询单个文章
     * @param article_id
     * @return
     */
    @Override
    public ResultVo queryArticleById(Integer article_id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("article", articleDao.queryArticleById(article_id));
        map.put("sorts", sortDao.queryAllSort());
        return new ResultVo(200, "success", map);
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    @Override
    public ResultVo insertArticle(AmsArticle article) {
        HashMap<String, Object> map = new HashMap<>();
        article.setTime(new Date());
        Integer i= articleDao.insertArticle(article);
        map.put("articleId",article.getArticleId());
        if (i>0){
            return new ResultVo(200,"保存成功",map);
        }else {
            return new ResultVo(201,"保存失败");
        }
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @Override
    public ResultVo updateArticle(AmsArticle article) {
        Integer i= articleDao.updateArticle(article);
        if (i>0){
            return new ResultVo(200,"更新成功");
        }else {
            return new ResultVo(201,"更新失败");
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    @Override
    public ResultVo deleteById(Integer articleId) {
        Integer i=articleDao.deleteById(articleId);
        if (i>0){
            return new ResultVo(200,"删除成功");
        }else {
            return new ResultVo(201,"删除失败");
        }
    }
}
