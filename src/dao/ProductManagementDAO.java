package dao;
import java.sql.*;
import pojo.*;

import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;

public class ProductManagementDAO {
	public static List<Product> getAllProducts(){
		List<Product> productList = new ArrayList<Product>();
			try {
				Connection con = DBUtil.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");
				while(rs.next()) {
					Product product = new Product(rs.getString("PROD_ID"),rs.getString("PROD_NAME"),rs.getString("PROD_CATEGORY"),rs.getInt("PROD_PRICE"));
					productList.add(product);
				}
				
				DBUtil.closeConnection(con);
			}catch (Exception e) {
				e.printStackTrace();
			}
		return productList;
	}
	
	public static int addProduct(Product product) {
		int status = 0;
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Product getProductByID(String productID) {
		Product product = null;
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PROD_ID = ?");
			ps.setString(1, productID);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				product = new Product(rs.getString("prod_id"),rs.getString("prod_name"),rs.getString("prod_category"),rs.getInt("prod_price"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public static int updateProduct(Product product) {
		int status =0;
		try {
			Connection con =DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE PRODUCT SET PROD_NAME =?, PROD_CATEGORY =?, PROD_PRICE=? WHERE PROD_ID = ?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(status);
		return status;
	}
	
	public static int deleteProduct(String productID) {
		int status =0;
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCT WHERE PROD_ID = ?");
			ps.setString(1, productID);
			status = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
