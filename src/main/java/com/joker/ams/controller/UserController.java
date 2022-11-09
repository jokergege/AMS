package com.joker.ams.controller;

import com.joker.ams.common.ResultVo;
import com.joker.ams.entity.AmsUser;
import com.joker.ams.service.AmsUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    AmsUserService amsUserService;

    @PostMapping("/login")
    public ResultVo userLogin(@RequestBody AmsUser user) {
        return amsUserService.userLogin(user);
    }

    @GetMapping("/logout")
    public ResultVo userLogout() {
        return amsUserService.userLogout();
    }

    @GetMapping("/tokenLogin")
    public ResultVo tokenLogin(@RequestParam("token") String token) {
        return amsUserService.tokenLogin(token);
    }

    @PostMapping("/register")
    public ResultVo record(@RequestBody AmsUser user) {
        return amsUserService.insertUser(user);
    }

    @GetMapping("/doGetCaptcha")
    public ResultVo doGetCaptcha(@RequestParam("phone") String phoneNumber) {
        return amsUserService.doGetCaptcha(phoneNumber);
    }

    @PostMapping("/doSendCaptcha")
    public ResultVo doSendCaptcha(@RequestParam("captcha") String captcha) {
        return amsUserService.doSendCaptcha(captcha);
    }

    @PutMapping("/doUpdatePassword")
    public ResultVo doUpdate(@RequestBody AmsUser user) {
        return amsUserService.doUpdatePassword(user);
    }
    @GetMapping("/getUserById")
    public ResultVo getUserById(int id){return amsUserService.queryById(id);}



    @PreAuthorize("hasAnyAuthority('user:list')")
    @GetMapping("/getUsersByCurrent")
    public ResultVo getUsersByCurrent(@Param("page") Integer page, @Param("size") Integer size) {
        return amsUserService.getUserList(page, size);
    }


}
