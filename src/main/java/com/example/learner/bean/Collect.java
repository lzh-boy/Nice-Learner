package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收藏和历史记录实体类
 * @author xyl
 *
 */
@Getter
@Setter
public class Collect implements Serializable{

	private Integer id;//主键

	private Integer courseId;//关联课程ID

	private String lastTime;//最近观看时间

	private Integer userId;//关联用户ID

	private Boolean ishistory;//是否为历史记录

	private Boolean iscollect;//是否收藏

	
}
