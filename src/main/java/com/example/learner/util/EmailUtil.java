package com.example.learner.util;


import io.github.isliqian.AnnNiceConfig;
import io.github.isliqian.NiceEmail;
import org.junit.jupiter.api.Test;


/**
 * Created by LiQian_Nice on 2018/3/24
 */
@AnnNiceConfig(type = "SMTP_QQ",username = "51103942@qq.com",password = "jtmoybnwknrnbjha")
public class EmailUtil {
    /**
     * 发送邮件的方法
     */
    @Test
    public static void sendMail(String to) throws Exception {
        NiceEmail.inUse(EmailUtil.class)
                .subject("测试")
                .from("LqNice")
                .to(to)
                .text("测试")
                .send();
    }
}
