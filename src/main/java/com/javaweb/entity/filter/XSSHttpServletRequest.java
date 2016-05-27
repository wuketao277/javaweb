package com.javaweb.entity.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

public class XSSHttpServletRequest implements HttpServletRequest {
	private HttpServletRequest _request;
	/**
	 * Referer检查标志
	 */
	private boolean checkReferer = true;

	public XSSHttpServletRequest(HttpServletRequest request) {
		String uri = request.getRequestURL().toString();
		// 检测所有非初始页面的页面来源。如果页面来源不是当前网站，修改标志。
		if (!"http://localhost:8080/javaweb/".equals(uri) && !"http://localhost:8080/javaweb".equals(uri)
				&& !"http://localhost:8080/javaweb/login/login".equals(uri)) {
			String referer = request.getHeader("referer");
			if ((null == referer) || (referer.indexOf("http://localhost:8080/javaweb") != 0)) {
				checkReferer = false;
			}
		}

		this._request = request;
	}

	public boolean getCheckReferer() {
		return checkReferer;
	}

	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return _request.getAttribute(name);
	}

	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return _request.getAttributeNames();
	}

	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return _request.getCharacterEncoding();
	}

	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		_request.setCharacterEncoding(env);
	}

	public int getContentLength() {
		// TODO Auto-generated method stub
		return _request.getContentLength();
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return _request.getContentType();
	}

	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return _request.getInputStream();
	}

	public String getParameter(String name) {
		// TODO Auto-generated method stub
		return StringEscapeUtils.escapeHtml4(_request.getParameter(name));
	}

	public Enumeration getParameterNames() {
		// TODO Auto-generated method stub
		return _request.getParameterNames();
	}

	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return _request.getParameterValues(name);
	}

	public Map getParameterMap() {
		// TODO Auto-generated method stub
		return _request.getParameterMap();
	}

	public String getProtocol() {
		// TODO Auto-generated method stub
		return _request.getProtocol();
	}

	public String getScheme() {
		// TODO Auto-generated method stub
		return _request.getScheme();
	}

	public String getServerName() {
		// TODO Auto-generated method stub
		return _request.getServerName();
	}

	public int getServerPort() {
		// TODO Auto-generated method stub
		return _request.getServerPort();
	}

	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return _request.getReader();
	}

	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return _request.getRemoteAddr();
	}

	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return _request.getRemoteHost();
	}

	public void setAttribute(String name, Object o) {
		// TODO Auto-generated method stub
		_request.setAttribute(name, o);
	}

	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		_request.removeAttribute(name);
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return _request.getLocale();
	}

	public Enumeration getLocales() {
		// TODO Auto-generated method stub
		return _request.getLocales();
	}

	public boolean isSecure() {
		// TODO Auto-generated method stub
		return _request.isSecure();
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return _request.getRequestDispatcher(path);
	}

	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return _request.getRealPath(path);
	}

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return _request.getRemotePort();
	}

	public String getLocalName() {
		// TODO Auto-generated method stub
		return _request.getLocalName();
	}

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return _request.getLocalAddr();
	}

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return _request.getLocalPort();
	}

	public String getAuthType() {
		// TODO Auto-generated method stub
		return _request.getAuthType();
	}

	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return _request.getCookies();
	}

	public long getDateHeader(String name) {
		// TODO Auto-generated method stub
		return _request.getDateHeader(name);
	}

	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return _request.getHeader(name);
	}

	public Enumeration getHeaders(String name) {
		// TODO Auto-generated method stub
		return _request.getHeaders(name);
	}

	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return _request.getHeaderNames();
	}

	public int getIntHeader(String name) {
		// TODO Auto-generated method stub
		return _request.getIntHeader(name);
	}

	public String getMethod() {
		// TODO Auto-generated method stub
		return _request.getMethod();
	}

	public String getPathInfo() {
		// TODO Auto-generated method stub
		return _request.getPathInfo();
	}

	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return _request.getPathTranslated();
	}

	public String getContextPath() {
		// TODO Auto-generated method stub
		return _request.getContextPath();
	}

	public String getQueryString() {
		// TODO Auto-generated method stub
		return _request.getQueryString();
	}

	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return _request.getRemoteUser();
	}

	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return _request.isUserInRole(role);
	}

	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return _request.getUserPrincipal();
	}

	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return _request.getRequestedSessionId();
	}

	public String getRequestURI() {
		// TODO Auto-generated method stub
		return _request.getRequestURI();
	}

	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return _request.getRequestURL();
	}

	public String getServletPath() {
		// TODO Auto-generated method stub
		return _request.getServletPath();
	}

	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return _request.getSession(create);
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return _request.getSession();
	}

	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return _request.isRequestedSessionIdValid();
	}

	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return _request.isRequestedSessionIdFromCookie();
	}

	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return _request.isRequestedSessionIdFromURL();
	}

	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return _request.isRequestedSessionIdFromUrl();
	}

}
