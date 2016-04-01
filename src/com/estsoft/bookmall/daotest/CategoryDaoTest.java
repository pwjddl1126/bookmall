package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.CategoryDao;
import com.estsoft.bookmall.vo.CategoryVO;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//1. insert test
		insertTest();
		
		//2. getList Test
//		getListTest();
	}

	public static void getListTest(){
		CategoryDao categoryDao = new CategoryDao();
		List<CategoryVO> list = categoryDao.getList();
		
		for( CategoryVO vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest(){
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
}
