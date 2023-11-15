/**   
 * @Title: UnsupportedFunctionException.java 
 * @Package com.github.framework.common.exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 *
 */
package com.github.framework.core.exception;

/** 
 * 未提供支持的功能
 *  
 */
public class UnsupportedFunctionException extends BaseException {


    private static final long serialVersionUID = -8167040012412519303L;


    public UnsupportedFunctionException(final String message) {
        super(message);
    }

}
