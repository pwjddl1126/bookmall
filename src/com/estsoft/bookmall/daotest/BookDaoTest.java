package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.BookDao;
import com.estsoft.bookmall.vo.BookVO;



public class BookDaoTest {

	public static void main(String[] args) {
		//1. insert test
		insertTest();
		
		//2. getList Test
//		getListTest();
	}

	public static void getListTest(){
		BookDao bookDao = new BookDao();
		List<BookVO> list = bookDao.getList();
		
		for( BookVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest(){
		BookVO bookVO = new BookVO();
		
		BookDao bookDao = new BookDao();

		bookVO.setTitle( "나는 추리소설이다." );
		bookVO.setCategoryNo( 1L );
		bookVO.setPrice( 13000L );
		bookDao.insert( bookVO );
		
		bookVO.setTitle( "나는 에세이다." );
		bookVO.setCategoryNo( 2L );
		bookVO.setPrice( 14000L );
		bookDao.insert( bookVO );

		bookVO.setTitle( "나는 예술책이다." );
		bookVO.setCategoryNo( 3L );
		bookVO.setPrice( 15000L );
		bookDao.insert( bookVO );
		
		bookVO.setTitle( "나는 수필이다." );
		bookVO.setCategoryNo( 4L );		
		bookVO.setPrice( 16000L );
		bookDao.insert( bookVO );
		
	}

}
