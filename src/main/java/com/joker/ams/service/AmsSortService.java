package com.joker.ams.service;

import com.joker.ams.common.ResultVo;

/**
 * (AmsSort)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsSortService {


    ResultVo getSorts();

    ResultVo getSortsByCurrent(Integer page, Integer size);

















    boolean deleteById(Integer sortId);


}
