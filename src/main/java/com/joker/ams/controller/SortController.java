package com.joker.ams.controller;

import com.joker.ams.common.ResultVo;
import com.joker.ams.service.AmsSortService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sort")
@CrossOrigin
public class SortController {
   @Resource
    AmsSortService sortService;

    @GetMapping("/getSorts")
    public ResultVo getSorts() {
        return sortService.getSorts();
    }
    @PreAuthorize("hasAnyAuthority('sort:list')")
    @GetMapping("/getSortsByCurrent")
    public ResultVo getSortsByCurrent(Integer page, Integer size) {
        return sortService.getSortsByCurrent(page,size);
    }

}
