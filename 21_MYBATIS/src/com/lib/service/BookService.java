package com.lib.service;

import org.apache.ibatis.session.SqlSession;

import com.lib.mapper.BookMapper;
import com.lib.util.MyBatisSessionUtil;
import com.lib.vo.BookVO;

public class BookService {
	public static void main(String[] args) {
		
		try (SqlSession session = MyBatisSessionUtil.openSession()) {
			
            BookMapper mapper = session.getMapper(BookMapper.class);
            /*
            List<BookVO> list = mapper.selectBookList();
            
            for(BookVO book:list) {
            	System.out.println(book);
            }
            */
            
            BookVO book = mapper.selectBook("B00104");
            System.out.println(book);
            
        }
	}
}
