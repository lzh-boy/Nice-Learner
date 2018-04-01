package com.example.learner.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.learner.bean.Degree;

/**
 * 数据持久层测试类
 * @author xyl
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DegreeMapperTest {

	private Logger logger= LoggerFactory.getLogger(DegreeMapperTest.class);
	
	@Resource
    private DegreeMapper degreeMapper;

    @Test
    public void findAll(){
        List<Degree> list=degreeMapper.findAll();
        for (Degree degree:list){
            logger.info(degree.getDegree());
        }
    }

    @Test
    public void add(){
    	degreeMapper.add("test123");
    }

    @Test
    public void update(){
    	degreeMapper.update(new Degree(5,"testUpdate"));
    }

    @Test
    public void delete(){
    	degreeMapper.delete(8);
    }
}
