package com.example.learner.bean;


import java.io.Serializable;

/**
 * 课程章节实体类
 * @author xyl
 *
 */

public class Chapter implements Serializable {

	private Integer id;//主键

	private Integer courseId;//关联课程ID

	private String title;//章节名

	private String video;//上传视频路径

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}
