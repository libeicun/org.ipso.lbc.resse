/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.resseorg.dao.DAOFactory;
import org.ipso.lbc.resseorg.dao.DAOFactoryLocal;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 信息：李倍存 创建于 2015/11/8 9:54。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class MyJdbcRealm extends JdbcRealm {
    protected static SuperDAO superDAO= DAOFactoryLocal.getInstance().getSuperDAO();
    public MyJdbcRealm() {

    }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        SimpleAuthenticationInfo info = null;
        try {
            String password = null;
            String salt = null;
            switch (saltStyle) {
                case NO_SALT:
                    password = getPasswordForUser(username)[0];
                    break;
                case CRYPT:
                    // TODO: separate password and hash from getPasswordForUser[0]
                    throw new ConfigurationException("Not implemented yet");
                    //break;
                case COLUMN:
                    String[] queryResults = getPasswordForUser(username);
                    password = queryResults[0];
                    salt = queryResults[1];
                    break;
                case EXTERNAL:
                    password = getPasswordForUser(username)[0];
                    salt = getSaltForUser(username);
            }

            if (password == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            }

            info = new SimpleAuthenticationInfo(username, password.toCharArray(), getName());

            if (salt != null) {
                info.setCredentialsSalt(ByteSource.Util.bytes(salt));
            }

        } catch (SQLException e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        }

        return info;
    }

    protected String[] getPasswordForUser(String username) throws SQLException {
        String[] result;
        boolean returningSeparatedSalt = false;
        switch (saltStyle) {
            case NO_SALT:
            case CRYPT:
            case EXTERNAL:
                result = new String[1];
                break;
            default:
                result = new String[2];
                returningSeparatedSalt = true;
        }
        List password = superDAO.excuteQuery(authenticationQuery, username);
        if (password.size() == 1){
            result[0] = (String)password.get(0);
            if (returningSeparatedSalt){
                throw new RuntimeException("当前Realm实现不支持Salt特性！");
            }
        } else if (password.size()>1){
            throw new AuthenticationException("More than one user row found for user [" + username + "]. Usernames must be unique.");
        }

        return result;
    }

    /**
     * This implementation of the interface expects the principals collection to return a String username keyed off of
     * this realm's {@link #getName() name}
     *
     * @see #getAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }


        String username = (String) getAvailablePrincipal(principals);

        Set<String> roleNames = null;
        Set<String> permissions = null;
        try {
            // Retrieve roles and permissions from database
            roleNames = getRoleNamesForUser(username);
            if (permissionsLookupEnabled) {
                permissions = getPermissions(username, roleNames);
            }

        } catch (SQLException e) {
            final String message = "There was a SQL error while authorizing user [" + username + "]";
            // Rethrow any SQL errors as an authorization exception
            throw new AuthorizationException(message, e);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;

    }

    protected Set<String> getRoleNamesForUser(String username) throws SQLException {
        Set<String> roleNames = new LinkedHashSet<String>();

        List roles = superDAO.excuteQuery(userRolesQuery, username);

        for (int i = 0; i < roles.size(); i++) {
            String roleName = roles.get(i).toString();
            if (roleName != null) {
                roleNames.add(roleName);
            }
        }

        return roleNames;
    }

    protected Set<String> getPermissions(String username, Collection<String> roleNames) throws SQLException {
        Set<String> permissions = new LinkedHashSet<String>();
        for (String roleName : roleNames) {
            List perms = superDAO.excuteQuery(permissionsQuery, roleName);
            for (int i = 0; i < perms.size(); i++) {
                permissions.add(perms.get(i).toString());
            }

        }

        return permissions;
    }

}
