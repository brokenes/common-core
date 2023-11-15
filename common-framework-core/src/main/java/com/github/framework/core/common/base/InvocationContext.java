
package com.github.framework.core.common.base;

import com.github.framework.core.lang.CustomStringUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName InvocationContext
 * @Description 调用的上下文信息，只是用于隐式传当前用户信息，并在DAO使用拦截器进行create_user,update_user的设置，
 *              注：在业务代码不能使用此类
 *
 */
public class InvocationContext {

    private static InheritableThreadLocal<InvocationContext> currentThreadLocal = new InheritableThreadLocal<>();

    public static final String DEFAULT_USER     = "system";
    public static final String DEFAULT_USER_ORG = "system";
    public static final String DEFAULT_IP       = "unknow";

    private Map<String,Object > attributes = new HashMap<>();

    private String requestId;

    private String user;

    private String ip;

    @Setter
    @Getter
    private String userOrg;

    private static InvocationContext defaultContext() {
        InvocationContext context = new InvocationContext();
        context.requestId = CustomStringUtils.uuid();
        context.user      = DEFAULT_USER;
        context.ip        = DEFAULT_IP;
        context.userOrg   = DEFAULT_USER_ORG;
        return context;
    }

    public static InvocationContext getOrNew() {
        InvocationContext invocationContext = currentThreadLocal.get();
        if (invocationContext == null) {
            invocationContext = defaultContext();
            currentThreadLocal.set(invocationContext);
        }
        return invocationContext;
    }

    public static void remove() {
        currentThreadLocal.remove();
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public InvocationContext attribute(String key, Object object) {
        if (object != null) {
            this.attributes.put(key, object);
        }
        return this;
    }

    public InvocationContext attributes(Map<String,Object> attributes) {
        if (attributes != null && !attributes.isEmpty()) {
            this.attributes.putAll(attributes);
        }
        return this;
    }

    public String getRequestId() {
        return requestId;
    }

    public InvocationContext requestId(String requestId) {
        if (CustomStringUtils.isNotBlank(requestId)) {
            this.requestId = requestId;
        }
        return this;
    }

    public String getUser() {
        return user;
    }

    public InvocationContext user(String username) {
        if (CustomStringUtils.isNotBlank(username)) {
            this.user = username;
        }
        return this;
    }

    public String getIp() {
        return ip;
    }

    public InvocationContext ip(String ip) {
        this.ip = ip;
        return this;
    }

    public InvocationContext save() {
        currentThreadLocal.set(this);
        return this;
    }


}