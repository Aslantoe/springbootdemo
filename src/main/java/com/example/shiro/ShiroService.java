package com.example.shiro;

import com.example.entity.Permission;
import com.example.service.PermissionService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import tk.mybatis.mapper.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author jack
 * @date 2018/4/20 0020 16:05
 */
@Service
public class ShiroService {
    @Autowired
    private ShiroFilterFactoryBean shiroFilterFactoryBean;
    @Autowired
    private PermissionService permissionService;

    /**
     * 初始化权限
     */
    public Map<String,String> loadFilterChainDefinitions(){
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/font-awesome/**","anon");

        List<Permission> permissionList = permissionService.queryAll();
        for (Permission permission : permissionList) {
            if(StringUtil.isNotEmpty(permission.getPermsResUrl())){
                String perms = "perms["+permission.getPermsResUrl()+"]";
                filterChainDefinitionMap.put(permission.getPermsResUrl(),perms);
            }
        }
        filterChainDefinitionMap.put("/**","authc");
        return filterChainDefinitionMap;
    }

    /**
     * 重新加载权限
     */
    public void updatePermission(){
        synchronized (shiroFilterFactoryBean){
            AbstractShiroFilter shiroFilter = null;
            try{
                shiroFilter = (AbstractShiroFilter)shiroFilterFactoryBean.getObject();
            }catch (Exception e){
                throw new RuntimeException(
                        "get ShiroFilter from shiroFilterFactoryBean error!");
            }
            PathMatchingFilterChainResolver filterChainResolver =
                    (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager =
                    (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
            //清空老的权限设置
            manager.getFilterChains().clear();
            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
            //重新构建生成
            Map<String,String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ","");
                manager.createChain(url, chainDefinition);
            }
            System.out.println("更新权限成功!!");
        }
    }

}
