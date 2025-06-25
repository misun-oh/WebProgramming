package com.lib.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSessionUtil {
	
    private static SqlSessionFactory sqlSessionFactory;
    
    // 클래스가 처음 로딩될 때 한 번 실행되는 "정적 초기화 블록
    static {
        try {
        	
            String resource = "com/lib/config/mybatis-config.xml";
            // mybatis 설정파일을 읽어 와서 세션팩토리를 생성
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("MyBatis 초기화 실패", e);
        }
    }

    // SqlSession 직접 반환 (수동 커밋)
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    // SqlSession 직접 반환 (자동 커밋 여부 지정)
    public static SqlSession openSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }
}