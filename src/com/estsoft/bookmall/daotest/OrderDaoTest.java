package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.OrderDao;
import com.estsoft.bookmall.vo.OrderVO;
import com.estsoft.bookmall.vo.OrderedBookVO;

public class OrderDaoTest {

	public static void main(String[] args) {
		//1. insert test
//		insertTest();
		
		//2. getList Test
		getListTest();
	}

	public static void getListTest(){
		OrderDao orderDao = new OrderDao();
		List<OrderVO> list = orderDao.getList();
		List<OrderedBookVO> list2 = orderDao.getListOrderedBook();
		
		for( OrderVO vo : list ) {
			System.out.println( vo );
		}
		
		for( OrderedBookVO vo1 : list2 ){
			System.out.println( vo1 );
		}
	}
	
	public static void insertTest(){
		OrderVO orderVO = new OrderVO();
		OrderedBookVO orderedBookVO = new OrderedBookVO();
		OrderDao orderDao = new OrderDao();

		orderVO.setMemberNo(1L);
		orderVO.setOrderedPrice(27000L);
		orderVO.setAddress("서울시 역삼동");
		orderDao.insert( orderVO );
//		orderDao.insertOrderedBook(orderedBookVO);

		
		orderVO.setMemberNo(2L);
		orderVO.setOrderedPrice(31000L);
		orderVO.setAddress("울산시 울주군");
		orderDao.insert( orderVO );
		orderDao.insertOrderedBook(orderedBookVO);



	}
	
	

}
