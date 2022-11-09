package com.joker.ams.service.impl;

import com.joker.ams.common.ResultVo;
import com.joker.ams.dao.AmsArticleDao;
import com.joker.ams.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    private AmsArticleDao articleDao;
    @Override
    public ResultVo getIndexMessage() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("article",articleDao.getMaxStarArticle());
        map.put("articles",articleDao.getMoreStarArticles());
        return new ResultVo(200,"success",map);
    }
}
