package com.javaweb.entity.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 防止XSS攻击的输入转换类
 * 类描述.
 * 
 * @author 201604210106
 * @version 2016-05-27
 * @----------------------------------------------------------------------------------------
 * @updated 修改描述.
 * @updated by 201604210106
 * @updated at 2016-05-27
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getHeader(String name) {
		return StringEscapeUtils.escapeHtml4(super.getHeader(name));
	}

	@Override
	public String getQueryString() {
		return StringEscapeUtils.escapeHtml4(super.getQueryString());
	}

	@Override
	public String getParameter(String name) {
		return StringEscapeUtils.escapeHtml4(super.getParameter(name));
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values != null) {
			int length = values.length;
			String[] escapseValues = new String[length];
			for (int i = 0; i < length; i++) {
				escapseValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
			}
			return escapseValues;
		}
		return super.getParameterValues(name);
	}

}
