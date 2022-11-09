package com.joker.ams.service.impl;

import com.joker.ams.common.ResultVo;
import com.joker.ams.dao.AmsSortDao;
import com.joker.ams.service.AmsSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * (AmsSort)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
@Service("amsSortService")
public class AmsSortServiceImpl implements AmsSortService {
    @Resource
    private AmsSortDao sortDao;

    @Override
    public ResultVo getSorts() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("sorts",sortDao.queryAllSort());
        return new ResultVo(200,"success",map);
    }

    @Override
    public ResultVo getSortsByCurrent(Integer page, Integer size) {
        HashMap<String, Object> map = new HashMap<>();
            map.put("sorts", sortDao.getSortListByCurrent((page - 1) * size, size));
            map.put("totalCount", sortDao.getSortCount());
            return new ResultVo(200, "success", map);

    }


    /**
     * 通过主键删除数据
     *
     * @param sortId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sortId) {
        return this.sortDao.deleteById(sortId) > 0;
    }
}
