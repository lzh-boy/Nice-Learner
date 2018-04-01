package com.example.learner.bean;



import java.io.Serializable;

/**
 * 用户收藏和历史记录实体类
 * @author xyl
 *
 */

public class Collect implements Serializable{

	private Integer id;//主键

	private Integer courseId;//关联课程ID

	private String lastTime;//最近观看时间

	private Integer userId;//关联用户ID

	private Boolean ishistory;//是否为历史记录

	private Boolean iscollect;//是否收藏

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIshistory() {
		return ishistory;
	}

	public void setIshistory(Boolean ishistory) {
		this.ishistory = ishistory;
	}

	public Boolean getIscollect() {
		return iscollect;
	}

	public void setIscollect(Boolean iscollect) {
		this.iscollect = iscollect;
	}
}
