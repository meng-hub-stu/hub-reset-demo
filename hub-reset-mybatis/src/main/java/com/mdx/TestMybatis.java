package com.mdx;

import com.mdx.mapper.UserMapper;
import com.mdx.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author Administrator
 * @Date 2024/3/14 10:01
 **/
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //获得核心配置文件
        InputStream resourceAsFile = Resources.getResourceAsStream("sqlmapconfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsFile);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行操作 参数：namespace+id
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

}
