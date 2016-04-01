package com.estsoft.bookmall.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.dao.BookDao;
import com.estsoft.bookmall.dao.CartDao;
import com.estsoft.bookmall.dao.CategoryDao;
import com.estsoft.bookmall.dao.MemberDao;
import com.estsoft.bookmall.dao.OrderDao;
import com.estsoft.bookmall.vo.BookVO;
import com.estsoft.bookmall.vo.CartVO;
import com.estsoft.bookmall.vo.CategoryVO;
import com.estsoft.bookmall.vo.MemberVO;
import com.estsoft.bookmall.vo.OrderVO;
import com.estsoft.bookmall.vo.OrderedBookVO;

public class BookMall {

	public static void main(String[] args) {

		// 1. MemberDao의  회원 생성
		MemberinsertTest();
		// 2. MemberDao의  회원 리스트
		MembergetListTest();
		
		
		// 3. CategoryDao의 카테고리 생성
		CategoryinsertTest();
		// 4. CategoryDao의 카테고리 리스트
		CategorygetListTest();

		// 5. BookDao의 서적(상품) 생성
		BookinsertTest();
		// 6. BookDao의  서적(상품) 리스트
		BookgetListTest();

		// 7. CartDao의 장바구니 정보 생성
		CartinsertTest();
		// 8. CartDao의  장바구니 내용 리스트
		CartgetListTest();

		// 9. OrderDao의 주문 생성
		OrderinsertTest();
		//10. OrderDao의  주문 리스트
		//11. OrderDao의 주문 서적 리스트  
		OrdergetListTest();
		
		
	}

	public static void MemberinsertTest(){
		MemberVO memberVO = new MemberVO();
		
		MemberDao memberDao = new MemberDao();

		memberVO.setEmail( "pwjddl1126@naver.com" );
		memberVO.setPassword( (long)1234 );
		memberVO.setName("박정이");
		memberDao.insert( memberVO );
		
		memberVO.setEmail( "hjinu@pedaling.me" );
		memberVO.setPassword( (long)5678 );
		memberVO.setName("홍진우");
		memberDao.insert( memberVO );
	}
	
	public static void MembergetListTest(){
		MemberDao memberDao = new MemberDao();
		List<MemberVO> list = memberDao.getList();
		
		for( MemberVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void CategoryinsertTest(){
		CategoryVO categoryVO = new CategoryVO();
		
		CategoryDao categoryDao = new CategoryDao();

		categoryVO.setCategoryName( "추리소설" );
		categoryDao.insert( categoryVO );
		
		categoryVO.setCategoryName( "에세이" );
		categoryDao.insert( categoryVO );
		
		categoryVO.setCategoryName( "예술" );
		categoryDao.insert( categoryVO );
		
		categoryVO.setCategoryName( "수필" );
		categoryDao.insert( categoryVO );

		
	}
	
	public static void CategorygetListTest(){
		CategoryDao categoryDao = new CategoryDao();
		List<CategoryVO> list = categoryDao.getList();
		
		for( CategoryVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void BookinsertTest(){
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
	
	public static void BookgetListTest(){
		BookDao bookDao = new BookDao();
		List<BookVO> list = bookDao.getList();
		
		for( BookVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void CartinsertTest(){
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
	
	public static void CartgetListTest(){
		CartDao cartDao = new CartDao();
		List<CartVO> list = cartDao.getList();
		
		for( CartVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void OrderinsertTest(){
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
	
	public static void OrdergetListTest(){
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
}
