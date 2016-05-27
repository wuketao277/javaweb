package com.javaweb.entity.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		String currentUsername = (String)super.getAvailablePrincipal(arg0); 
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
        //实际中可能会像上面注释的那样从数据库取得  
        if(null!=currentUsername && "admin".equals(currentUsername)){  
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色    
            simpleAuthorInfo.addRole("admin");  
            //添加权限  
            simpleAuthorInfo.addStringPermission("city/list");   
            return simpleAuthorInfo;  
        }
      
        //实际中可能会像上面注释的那样从数据库取得  
        if(null!=currentUsername && "su".equals(currentUsername)){  
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色    
            simpleAuthorInfo.addRole("su");  
            //添加权限  
            simpleAuthorInfo.addStringPermission("city/list");   
            return simpleAuthorInfo;  
        }
        

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//用户名
        String username = (String) authcToken.getPrincipal();
        //密码
        String password = new String((char[])authcToken.getCredentials());
        //从数据库获取用户名密码进行匹配，这里为了方面，省略数据库操作
        if(!"admin".equals(username) && !"su".equals(username)){
            throw new UnknownAccountException();
        }
        if("admin".equals(password) && !"111".equals(password)){
            throw new IncorrectCredentialsException();
        }
        if("su".equals(username) && !"111".equals(password))
        {
        	throw new IncorrectCredentialsException();
        }
        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
	}
	
	 /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  


}
