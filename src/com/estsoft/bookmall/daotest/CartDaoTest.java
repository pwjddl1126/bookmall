package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.BookDao;
import com.estsoft.bookmall.dao.CartDao;
import com.estsoft.bookmall.vo.BookVO;
import com.estsoft.bookmall.vo.CartVO;

public class CartDaoTest {

	public static void main(String[] args) {
		//1. insert test
		insertTest();
		
		//2. getList Test
//		getListTest();
	}

	public static void getListTest(){
		CartDao cartDao = new CartDao();
		List<CartVO> list = cartDao.getList();
		
		for( CartVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest(){
		CartVO cartVO = new CartVO();
		
		CartDao cartDao = new CartDao();

		cartVO.setMemberNo( 1L );
		cartVO.setBookNo( 1L );
		cartVO.setQuantity( 1L );
		cartDao.insert( cartVO );
		
		cartVO.setMemberNo( 1L );
		cartVO.setBookNo( 2L );
		cartVO.setQuantity( 1L );
		cartDao.insert( cartVO );
		
		cartVO.setMemberNo( 2L );
		cartVO.setBookNo( 3L );
		cartVO.setQuantity( 1L );
		cartDao.insert( cartVO );
		
		cartVO.setMemberNo( 2L );
		cartVO.setBookNo( 4L );
		cartVO.setQuantity( 1L );
		cartDao.insert( cartVO );

		
	}


}
