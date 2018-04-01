package com.example.learner.mapper;

import com.example.learner.bean.Aspect;
import com.example.learner.bean.Category;
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
public class CategoryMapperTest {

    private Logger logger= LoggerFactory.getLogger(CategoryMapperTest.class);

    @Resource
    private CategoryMapper categoryMapper;

    @Test
    public void findAll(){
        List<Category> list=categoryMapper.findAll();

        for (Category category:list){
            logger.info(category.getCategory());
        }
    }

    @Test
    public void findCateforysByAspectId(){
        List<Category> list=categoryMapper.findCateforysByAspectId(1);
        for (Category category:list){
            logger.info(category.getCategory());
        }
    }

    @Test
    public void add(){
        categoryMapper.add(new Category("测试",8));
    }

    @Test
    public void update(){
        categoryMapper.update(new Category(42,"测试update",7));
    }
    @Test
    public void delete(){
        categoryMapper.delete(41);
    }
}
