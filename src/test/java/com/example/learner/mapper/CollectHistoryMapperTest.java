package com.example.learner.mapper;

import com.example.learner.bean.Aspect;
import com.example.learner.bean.CollectHistory;
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
 *
 * 方向数据库操作测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectHistoryMapperTest {

    private Logger logger= LoggerFactory.getLogger(CollectHistoryMapperTest.class);


    @Resource
    private CollectHistoryMapper collectHistoryMapper;

    @Test
    public void findAll(){
        List<CollectHistory> list=collectHistoryMapper.findAll();
        for (CollectHistory collectHistory:list){
            logger.info(collectHistory.getLastTime());
        }
    }

    @Test
    public void add(){
        CollectHistory collectHistory=new CollectHistory();
        collectHistory.setCourseId(1);
        collectHistory.setIscollect(false);
        collectHistory.setIshistory(true);
        collectHistory.setLastTime("2018-03-01 20:35:47");
        collectHistory.setUserId(5);
        collectHistoryMapper.add(collectHistory);
    }

    @Test
    public void update(){
        collectHistoryMapper.update(
                new CollectHistory(1,1,"2018-03-01 20:35:47"
                        ,4,true,true));
    }

    @Test
    public void delete(){
        collectHistoryMapper.delete(4);
    }

}
