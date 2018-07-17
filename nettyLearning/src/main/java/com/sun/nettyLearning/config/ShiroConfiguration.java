package com.sun.nettyLearning.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午5:22:54
 */
@Configuration
public class ShiroConfiguration {

	@Bean(name="lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	
    @Bean  
    public HashedCredentialsMatcher hashedCredentialsMatcher(){  
       HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();  
       hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;  
       hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));  
       return hashedCredentialsMatcher;  
    }  
	
	@Bean
	public DefaultAdvisorAutoProxyCreator getAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator c = new DefaultAdvisorAutoProxyCreator();
		c.setProxyTargetClass(true);
		return c;
	}
	
	@Bean(name="authRealm")
	public AuthRealm authRealm(){
		AuthRealm authRealm = new AuthRealm();
		return authRealm;
	}
	
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(AuthRealm authRealm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
		return securityManager;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
	
	 /**
     * ShiroFilter
     * 注意这里参数中的 StudentService 和 IScoreDao 只是一个例子，因为我们在这里可以用这样的方式获取到相关访问数据库的对象，
     * 然后读取数据库相关配置，配置到 shiroFilterFactoryBean 的访问规则中。实际项目中，请使用自己的Service来处理业务逻辑。
     *
     * @param securityManager 安全管理器
     * @return ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/denied");
        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }

    /**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        //过滤顺序一定要根据自己需要排序
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/favicon.ico", "anon");//匿名访问静态资源
        filterChainDefinitionMap.put("/css/*", "anon");//匿名访问静态资源
        filterChainDefinitionMap.put("/js/*", "anon");//匿名访问静态资源
        filterChainDefinitionMap.put("/test3", "anon");//匿名访问静态资源
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }
}
