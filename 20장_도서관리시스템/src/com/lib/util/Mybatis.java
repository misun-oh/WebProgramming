package com.lib.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lib.mapper.BookMapper;
import com.lib.vo.BookVO;

public class Mybatis {
	public static void main(String[] args) {
		String resource = "com/lib/config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			System.out.println(inputStream);
			SqlSessionFactory sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession session = sqlSessionFactory.openSession();
			
			
			BookMapper mapper = session.getMapper(BookMapper.class);
			List<BookVO> list = mapper.selectBookList();
			BookVO book = mapper.selectBook("B00111");
			int cnt = mapper.selectBookCnt();
			System.out.println("list : " + list.size());
			System.out.println(cnt);
			System.out.println(book);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
