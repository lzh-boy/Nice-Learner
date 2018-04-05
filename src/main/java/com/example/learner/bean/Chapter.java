package com.example.learner.bean;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 课程章节实体类
 * @author xyl
 *
 */

public class Chapter implements Serializable {

	private Integer id;//主键

	@NotNull(message="课程ID不能为空")
	private Integer courseId;//关联课程ID

	@NotEmpty(message="章节名不能为空")
	private String title;//章节名

	@NotEmpty(message="上传视频路径不能为空")
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
