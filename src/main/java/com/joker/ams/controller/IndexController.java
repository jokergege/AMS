package com.joker.ams.controller;

import com.joker.ams.common.ResultVo;
import com.joker.ams.service.IndexService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("index")
public class IndexController {
    @Resource
    IndexService indexService;

    @GetMapping("/getIndexMessage")
    public ResultVo getIndexMessage() {
        return indexService.getIndexMessage();
    }


}
