package com.example.learner.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by LiQian_Nice on 2018/3/24
 */
public class EmailUtil {
    /**
     * 发送邮件的方法
     * @param to 给谁发邮件
     */
    public static void sendMail(String to) throws Exception {

        String from = "51103942@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)
        //1.创建连接对象，连接到邮箱服务器
        Properties props=new Properties();
        props.setProperty("mail.smtp.host", host);// 设置邮件服务器
        props.setProperty("mail.smtp.auth", "true");// 打开认证
        //QQ邮箱需要下面这段代码，163邮箱不需要
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        // 1.获取默认session对象
        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("51103942@qq.com", "jtmoybnwknrnbjha"); // 发件人邮箱账号、授权码
            }
        });

        //2.创建邮件对象
        Message message=new MimeMessage(session);
        //2.1设置发件人
        message.setFrom(new InternetAddress(from));
        //2.2设置收件人
        message.addRecipient(RecipientType.TO, new InternetAddress(to));
        //2.3设置邮件的主题
        message.setSubject("找回密码");
        //2.4设置邮件的正文
        message.setContent("<h1>hello，找回密码请点击以下连接</h1><h3><a href='http://localhost:8080/JavaMail/ActiveServlet?code="+"'>http://localhost:8080/JavaMail/ActiveServlet?code="+"</a></h3>", "text/html;charset=UTF-8");
        //3发送一封激活邮件
        Transport.send(message);
        System.out.println("邮件成功发送!");
    }
}
