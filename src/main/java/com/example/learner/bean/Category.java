package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 课程分类实体类
 * @author xyl
 *
 */
@Getter
@Setter
public class Category implements Serializable {

	private Integer id;//主键

	private Integer aspectId;//关联课程方向ID

	private String  category;//课程分类名

	
}
