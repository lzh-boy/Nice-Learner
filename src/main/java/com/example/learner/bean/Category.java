package com.example.learner.bean;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 课程分类实体类
 * @author xyl
 *
 */

public class Category implements Serializable {

	private Integer id;//主键

	@NotNull(message="课程方向ID不能为空")
	private Integer aspectId;//关联课程方向ID

	@NotEmpty(message="课程分类名不能为空")
	private String  category;//课程分类名



    public Category(String category, Integer aspectId) {
    	this.category=category;
    	this.aspectId=aspectId;
    }

	public Category(Integer id, String category, Integer aspectId) {
    	this.id=id;
    	this.category=category;
    	this.aspectId=aspectId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAspectId() {
		return aspectId;
	}

	public void setAspectId(Integer aspectId) {
		this.aspectId = aspectId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
