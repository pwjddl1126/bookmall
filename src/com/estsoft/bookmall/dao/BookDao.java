package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.BookVO;

public class BookDao {

	// 커넥션 얻기
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");

			// 2. Connection 얻기
			String url = "jdbc:mysql://localhost/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버를 찾을 수 없습니다:" + ex);
		}

		return conn;
	}
	
	
	
	public List<BookVO> getList() {
		
		List<BookVO> list = new ArrayList<BookVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "select book_No, title, category_No, price from book";
			rs = stmt.executeQuery( sql );
			
			// 5. 데이터 받아오기 
			while( rs.next() ) {
				Long bookNo = rs.getLong( 1 );
				String title = rs.getString( 2 );
				Long categoryNo = rs.getLong( 3 );
				Long price = rs.getLong( 4 );
				
				BookVO bookVO = new BookVO();
				bookVO.setBookNo(bookNo);
				bookVO.setTitle(title);
				bookVO.setCategoryNo(categoryNo);
				bookVO.setPrice(price);
				
				list.add( bookVO );
			}
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		return list;
	}
	
	
	public void insert( BookVO bookVO ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//3. Statement 준비
			String sql = "insert into book values(  null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			pstmt.setString( 1, bookVO.getTitle() );
			pstmt.setLong( 2, bookVO.getCategoryNo() );
			pstmt.setLong( 3, bookVO.getPrice());
			
			//5. SQL 실행
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			//6. 자원정리(clean-up)
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}		
	}

}
