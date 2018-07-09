package com.sun.shiroLearning.config;

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

import com.sun.shiroLearning.auth.entity.SysPermission;
import com.sun.shiroLearning.auth.entity.SysRole;
import com.sun.shiroLearning.auth.entity.UserInfo;
import com.sun.shiroLearning.auth.service.UserInfoService;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月6日 下午1:13:36
 */
public class AuthRealm extends AuthorizingRealm {
	
	@Autowired 
	UserInfoService userInfoService;

	/**
	 * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
	 * 如果需要动态权限,但是又不想每次去数据库校验,可以存在ehcache中.自行完善
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		System.out.println("开始授权");
		Session session = SecurityUtils.getSubject().getSession();
		UserInfo user = (UserInfo) session.getAttribute("USER_SESSION");
		System.out.println(user.toString());
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
		for(SysRole role:user.getUserRole()){  
			info.addRole(role.getRole());  
	        for(SysPermission p:role.getUserPermission()){  
	        	info.addStringPermission(p.getPermission());  
	        }  
	    }  
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
		System.out.println("页面传递过来的用户名" + userName);
		// 从map里获取用户名Optional->JDK8新特性
		//UserInfo userInfo = Optional.ofNullable(
		//		DBCache.USER_CACHE.get(userName)).orElseThrow(
		//		UnknownAccountException::new);
		UserInfo userInfo = userInfoService.queryUserInfoByName(userName);
		System.err.println(userInfo.toString());
		// 有效还是无效的用户
		if (userInfo.getState() == 1) {
			throw new LockedAccountException();
		}
		// 将查处来的结果认证
		// 从数据库查询出来的账号名和密码,与用户输入的账号和密码对比
		// 当用户执行登录时,在方法处理上要实现 user.login(token)
		// 然后会自动进入这个类进行认证
		// 交给 AuthenticatingRealm 使用 CredentialsMatcher 进行密码匹配，如果觉得人家的不好可以自定义实现
		// 如果使用 HashedCredentialsMatcher 这里认证方式就要改一下 SimpleAuthenticationInfo
		//SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),
		//ByteSource.Util.bytes(userInfo.getCredentialsSalt()), getName());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				userName, userInfo.getPassword(), getName());
		// 存放session
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("USER_SESSION", userInfo);
		return authenticationInfo;

	}

}
