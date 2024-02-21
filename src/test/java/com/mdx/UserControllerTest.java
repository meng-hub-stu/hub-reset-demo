package com.mdx;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.mdx.pojo.Log;
import com.mdx.pojo.User;
import com.mdx.service.ILogService;
import com.mdx.service.IUserService;
import com.mdx.util.PagedGridResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Mengdl
 * @date 2024/01/12
 */
@SpringBootTest(classes = ApiApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class UserControllerTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private ILogService logService;

    @Test
    public void saveTest() {
        for (int i = 100; i < 120; i++) {
            User user = User.builder().name("shigen-" + i).age(RandomUtil.randomInt(5, 100)).build();
            userService.saveOrUpdate(user);
        }
    }

    @Test
    public void queryUserList() {
        List<User> list = userService.list(Wrappers.<User>lambdaQuery().eq(User::getAge, 20));
        log.info("查询的数据->{}", JSON.toJSONString(list));
    }

    @Test
    public void queryUserById() {
        User user = userService.getById(10102);
        log.info("查询的数据->{}", JSON.toJSONString(user));
    }

    @Test
    public void queryUserPage() {
        Page<User> result = userService.page(new Page<User>(1, 10).addOrder(OrderItem.desc("age")), null);
        log.info("查询的数据->{}", JSON.toJSONString(result.getRecords()));
    }


    @Test
    public void saveLogTest() {
        for (int i = 100; i < 120; i++) {
            Log log = Log.builder().content("测试-" + i).build();
            logService.saveOrUpdate(log);
        }
    }

    @Test
    public void queryLog() {
        Log logs = logService.getById(2);
        log.info("查询的数据->{}", JSON.toJSONString(logs));
    }

    @Test
    public void queryLogPage() {
        Page<Log> result = logService.page(new Page<>(2, 5));
        log.info("查询的数据->{}", JSON.toJSONString(result.getRecords()));
    }

    @Test
    public void queryLogPage01() {
        PageHelper.startPage(1, 10);
        PagedGridResult result = PagedGridResult.setterPagedGridResult(1, logService.list());
        log.info("查询的数据->{}", JSON.toJSONString(result.getRows()));
    }

}