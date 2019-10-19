package com.gy.pj.sys.service.realm;



import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gy.pj.sys.dao.SysUserDao;
import com.gy.pj.sys.entity.SysUser;


@Service
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private SysUserDao sysUserDao;
	

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		// 构建凭证匹配对象
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		// 设置加密算法
		cMatcher.setHashAlgorithmName("MD5");
		// 设置加密次数
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 1.获取登录用户信息，例如用户id
		//SysUser user = (SysUser) principals.getPrimaryPrincipal();
		//Integer userId = user.getId();
		// 2.基于用户id获取用户拥有的角色(sys_user_roles)
		/**List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
		if (roleIds == null || roleIds.size() == 0)
			throw new AuthorizationException();
		// 3.基于角色id获取菜单id(sys_role_menus)
		Integer[] array = {};
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(array));
		if (menuIds == null || menuIds.size() == 0)
			throw new AuthorizationException();
		// 4.基于菜单id获取权限标识(sys_menus)
		List<String> permissions = sysMenuDao.findPermissions(menuIds.toArray(array));
		// 5.对权限标识信息进行封装并返回
		Set<String> set = new HashSet<>();
		for (String per : permissions) {
			if (!StringUtils.isEmpty(per)) {
				set.add(per);
			}
		}*/
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//info.setStringPermissions(set);
		return info;// 返回给授权管理器
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		SysUser user = sysUserDao.findUserByUserName(username);
		if (user == null)
			throw new UnknownAccountException();
		if (user.getValid() == 0)
			throw new LockedAccountException();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt,
				getName());
		return info;
	}

}
