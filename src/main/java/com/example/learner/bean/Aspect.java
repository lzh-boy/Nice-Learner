package com.example.learner.bean;




import java.io.Serializable;

/**
 * 课程方向实体类
 * @author xyl
 *
 */


public class Aspect implements Serializable {

	private Integer id;//主键

	private String aspect;//课程方向名

	public Aspect(Integer id,String aspect){
		this.id=id;
		this.aspect=aspect;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}
}
