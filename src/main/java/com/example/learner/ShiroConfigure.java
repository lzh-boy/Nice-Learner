package com.example.learner;



import com.example.learner.util.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by LiQian_Nice on 2018/3/21
 */
@Configuration
public class ShiroConfigure {

    private static final transient Logger log = LoggerFactory.getLogger(ShiroConfigure.class);
    /**
     * 配置拦截器
     *
     * 定义拦截URL权限，优先级从上到下
     * 1). anon  : 匿名访问，无需登录
     * 2). authc : 登录后才能访问
     * 3). logout: 登出
     * 4). roles : 角色过滤器
     *
     * URL 匹配风格
     * 1). ?：匹配一个字符，如 /admin? 将匹配 /admin1，但不匹配 /admin 或 /admin/；
     * 2). *：匹配零个或多个字符串，如 /admin* 将匹配 /admin 或/admin123，但不匹配 /admin/1；
     * 2). **：匹配路径中的零个或多个路径，如 /admin/** 将匹配 /admin/a 或 /admin/a/b
     *
     * 配置身份验证成功，失败的跳转路径
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        log.info("^^^^^^^^^^^^^^^^^^^^  配置Shiro拦截工厂");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/static/**", "anon"); // 静态资源匿名访问
        filterChainDefinitionMap.put("/css/**", "anon"); // 静态资源匿名访问
        filterChainDefinitionMap.put("/images/**", "anon"); // 静态资源匿名访问
        filterChainDefinitionMap.put("/semantic-ui/**", "anon"); // 静态资源匿名访问
        filterChainDefinitionMap.put("/users/logout", "logout");  // 用户退出，只需配置logout即可实现该功能
        filterChainDefinitionMap.put("/users/", "anon");  // 用户登陆
        filterChainDefinitionMap.put("/", "anon");  // 不需要登陆的首页
        //开放swagger资源 start
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        //开放swagger资源 end
        filterChainDefinitionMap.put("/users/register","anon");
        filterChainDefinitionMap.put("/users/forgotPassword","anon");
        filterChainDefinitionMap.put("/users/findPassword","anon");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("/users/login");       // 登录的路径
        shiroFilterFactoryBean.setSuccessUrl("/"); // 登录成功后跳转的路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");  // 验证失败后跳转的路径
        return shiroFilterFactoryBean;
    }
    /**
     * 配置Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 自动创建代理类，若不添加，Shiro的注解可能不会生效。
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启Shiro的注解
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 配置加密匹配，使用MD5的方式，进行1024次加密
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 自定义Realm，可以多个
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * SecurityManager 安全管理器；Shiro的核心
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

}
