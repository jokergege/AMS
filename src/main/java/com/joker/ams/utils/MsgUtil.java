package com.joker.ams.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class MsgUtil {
    public static String getCaptcha(){
        String captcha1 = "{\"code\":\"";
        int num=(int)(Math.random()*9000)+1000;
        String captcha2="\"}";
        String captcha=captcha1+num+captcha2;
        System.out.println(captcha);
        return captcha;
    }
    public static String SendSms(String phone){
        String captcha=getCaptcha();
        String accessKeyId="LTAI5tRHFvNd889WxH6FyCcd";//用户
        String secret="HsdIAOMoKkhoWQCMXqeK5I0L0G7GjZ";//密码
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setSignName("阿里云短信测试");
        request.setTemplateCode("SMS_154950909");
        request.setPhoneNumbers(phone);
        request.setTemplateParam(captcha);
        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return captcha;
    }

}
