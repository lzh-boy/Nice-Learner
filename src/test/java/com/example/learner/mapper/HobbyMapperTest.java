package com.example.learner.mapper;

import com.example.learner.bean.Category;
import com.example.learner.bean.Hobby;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HobbyMapperTest {

    private Logger logger= LoggerFactory.getLogger(HobbyMapperTest.class);

    @Resource
    private HobbyMapper hobbyMapper;

    @Test
    public void findCategorysByUserId(){
        List<Category> list=hobbyMapper.findCategorysByUserId(2);
        for(Category category:list){
            logger.info(String.valueOf(category.getCategory()));
        }
    }
    List<Hobby> list=null;
    @Test
    public void addCategory(){
        list=new ArrayList<>();
        list.add(new Hobby(2,10));
        list.add(new Hobby(2,11));
        list.add(new Hobby(2,12));

        hobbyMapper.addBatchCategory(list);
    }
}
