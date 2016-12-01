package com.sun.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by Sun on 16/11/17.
 */
// 忽略不需要的属性
@JsonIgnoreProperties(ignoreUnknown = true)
// 为空的值不返回
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel implements Serializable {

	private Page page;
	private String keywords;
	private String orderByClause;
	private String orderByCustom;

	private Long id;
	private String token;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByCustom() {
		return orderByCustom;
	}

	public void setOrderByCustom(String orderByCustom) {
		this.orderByCustom = orderByCustom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
