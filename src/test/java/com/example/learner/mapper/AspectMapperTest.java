package com.example.learner.mapper;

import com.example.learner.bean.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectMapperTest {

    private Logger logger= LoggerFactory.getLogger(AspectMapperTest.class);


    @Resource
    private AspectMapper aspectMapper;

    @Test
    public void findAll(){
        List<Aspect> list=aspectMapper.findAll();
        for (Aspect aspect:list){
            logger.info(aspect.getAspect());
        }
    }

    @Test
    public void add(){
        Aspect aspect=new Aspect();
        aspect.setAspect("test");
        aspectMapper.add(aspect);
    }

    @Test
    public void update(){
        aspectMapper.update(new Aspect(9,"testUpdate"));
    }

    @Test
    public void delete(){
        aspectMapper.delete(8);
    }

}
