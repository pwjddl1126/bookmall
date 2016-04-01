package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.BookDao;
import com.estsoft.bookmall.dao.MemberDao;
import com.estsoft.bookmall.vo.BookVO;
import com.estsoft.bookmall.vo.MemberVO;

public class MemberDaoTest {

	public static void main(String[] args) {
		//1. insert test
		insertTest();
		
		//2. getList Test
//		getListTest();
	}

	public static void getListTest(){
		MemberDao memberDao = new MemberDao();
		List<MemberVO> list = memberDao.getList();
		
		for( MemberVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest(){
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

	
}
