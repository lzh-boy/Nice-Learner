package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 课程章节实体类
 * @author xyl
 *
 */
@Getter
@Setter
public class Chapter implements Serializable {

	private Integer id;//主键

	private Integer courseId;//关联课程ID

	private String title;//章节名

	private String video;//上传视频路径

	
}
