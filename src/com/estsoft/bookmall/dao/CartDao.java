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
import com.estsoft.bookmall.vo.CartVO;

public class CartDao {

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
	
	
	
	public List<CartVO> getList() {
		
		List<CartVO> list = new ArrayList<CartVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "select member_no, book_no, quantity from cart";
			rs = stmt.executeQuery( sql );
			
			// 5. 데이터 받아오기 
			while( rs.next() ) {
				Long memberNo = rs.getLong( 1 );
				Long bookNo = rs.getLong( 2 );
				Long quantity = rs.getLong( 3 );
				
				CartVO cartVO = new CartVO();
				cartVO.setMemberNo(memberNo);
				cartVO.setBookNo(bookNo);
				cartVO.setQuantity(quantity);
				
				list.add( cartVO );
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
	
	public void insert( CartVO cartVO ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//3. Statement 준비
			String sql = "insert into cart values( ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			pstmt.setLong( 1, cartVO.getMemberNo() );
			pstmt.setLong( 2, cartVO.getBookNo() );
			pstmt.setLong( 3, cartVO.getQuantity() );
			
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
