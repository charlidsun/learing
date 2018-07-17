package com.sun.nettyLearning.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.nettyLearning.user.entity.UserInfo;
import com.sun.nettyLearning.user.service.UserInfoService;


/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午5:23:28
 */
public class AuthRealm extends AuthorizingRealm{

	@Autowired 
	UserInfoService userInfoService;

	/**
	 * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
	 * 如果需要动态权限,但是又不想每次去数据库校验,可以存在ehcache中.自行完善
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		Session session = SecurityUtils.getSubject().getSession();
		UserInfo user = (UserInfo) session.getAttribute("USER_SESSION");
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 用户的角色集合
		//Set<String> roles = new HashSet<>();
		//roles.add(user.getUserRole().toString());
		//info.setRoles(roles);
		// 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面可以不要
		// 只有角色并没有颗粒度到每一个按钮 或 是操作选项 PERMISSIONS 是可选项
		//final Map<String, Collection<String>> permissionsCache = DBCache.PERMISSON_CACHE;
		//final Collection<String> permissions = permissionsCache.get(user
		//		.getName());
		//info.addStringPermissions(permissions);
//		for(SysRole role:user.getUserRole()){  
//			info.addRole(role.getRole());  
//	        for(SysPermission p:role.getUserPermission()){  
//	        	info.addStringPermission(p.getPermission());  
//	        }  
//	    }  
		return info;
	}

	/**
	 * 认证回调函数,登录时调用
	 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
	 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
	 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
	 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
	 * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
	 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
	 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		// 获取用户名
		String userName = (String) token.getPrincipal();
		// 从map里获取用户名Optional->JDK8新特性
		//UserInfo userInfo = Optional.ofNullable(
		//		DBCache.USER_CACHE.get(userName)).orElseThrow(
		//		UnknownAccountException::new);
		UserInfo userInfo = userInfoService.getUserInfo(userName);
		// 有效还是无效的用户
		if (userInfo.getLock() == 0) {
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				userName, userInfo.getLoginPwd(), getName());
		// 存放session
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("USER_SESSION", userInfo);
		return authenticationInfo;

	}
}
