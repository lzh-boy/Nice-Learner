package com.example.learner.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 课程方向实体类
 * @author xyl
 *
 */
@Getter
@Setter
public class Aspect implements Serializable {

	private Integer id;//主键


	private String aspect;//课程方向名

	
}
