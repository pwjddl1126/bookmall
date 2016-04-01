package com.estsoft.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookmall.vo.OrderVO;
import com.estsoft.bookmall.vo.OrderedBookVO;

public class OrderDao {

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
	
	
	
	public List<OrderVO> getList() {
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "select a.orders_no, a.member_no, a.orders_price, a.address, b.name, b.email "
					+ "from orders a, member b WHERE a.member_no = b.member_no";
			rs = stmt.executeQuery( sql );
			
			// 5. 데이터 받아오기 
			while( rs.next() ) {
				Long orderNo = rs.getLong( 1 );
				Long memberNo = rs.getLong( 2 );
				Long price = rs.getLong( 3 );
				String address = rs.getString( 4 );
				String name = rs.getString( 5 );
				String email = rs.getString( 6 );
				
				OrderVO orderVO = new OrderVO();
				orderVO.setOrderNo(orderNo);
				orderVO.setMemberNo(memberNo);
				orderVO.setOrderedPrice(price);
				orderVO.setAddress(address);
				orderVO.setMemberName(name);
				orderVO.setMemberEmail(email);


				list.add( orderVO );
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
	
	
	public List<OrderedBookVO> getListOrderedBook() {
		
		List<OrderedBookVO> list = new ArrayList<OrderedBookVO>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "select quantity, book_no, orders_no from orderedBook ";
			rs = stmt.executeQuery( sql );
			
			// 5. 데이터 받아오기 
			while( rs.next() ) {
				Long quantity = rs.getLong( 1 );
				Long bookNo = rs.getLong( 2 );
				Long ordersNo = rs.getLong( 3 );
				
				OrderedBookVO orderedBookVO = new OrderedBookVO();
				orderedBookVO.setQuantity(quantity);
				orderedBookVO.setBooksNo(bookNo);
				orderedBookVO.setOrdersNo(ordersNo);


				list.add( orderedBookVO );
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
	
	
	
	public void insert( OrderVO orderVO ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//3. Statement 준비
			String sql = "insert into orders values(  null, ?, ?, ?)"; //배송지 결제금액 고객번호
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			pstmt.setString( 1, orderVO.getAddress() );
			pstmt.setLong( 2, orderVO.getOrderedPrice());
			pstmt.setLong( 3, orderVO.getMemberNo() );
			
			//5. SQL 실행
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			ex.printStackTrace();
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
	
	
	public void insertOrderedBook( OrderedBookVO orderedBookVO ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//3. Statement 준비
			String sql = "insert into orderedBook (quantity, book_no, orders_no)"+
						" select a.quantity,a.book_no,b.orders_no from cart a, orders b where a.member_no = b.member_no"; //수량 서적번호 주문번호
			pstmt = conn.prepareStatement(sql);
//			
//			//4. bind
//			pstmt.setLong(1,orderedBookVO.getQuantity());
//			pstmt.setLong(2,orderedBookVO.getBooksNo());
//			pstmt.setLong(3,orderedBookVO.getOrdersNo());
//			
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
