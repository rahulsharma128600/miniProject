package project.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;

public class DAO {

	public Connection myGetConnection()
	{
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jdbc";
		String uname="root";
		String pwd="root";
		
		 con = DriverManager.getConnection(url,uname,pwd);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("the connection could not be made "+e);
		}
		return con;
	}
	public void showResultset(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				int pId=rs.getInt("id");
				String pName= rs.getString("name");
				int cost = rs.getInt(3);
				System.out.println("row : "+pId+","+pName+","+cost );
			}
		}
		catch(SQLException e)
		{
			System.out.println("problem showing resultset "+e);
		}
	}
	
	
	public ResultSet SignIn(String sql)
	{
		Connection con=myGetConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt= con.createStatement();
			 rs= stmt.executeQuery(sql);
		}
		catch(SQLException e){
			e.printStackTrace();

		}
		return rs;
	}

		
		
	public ResultSet getRows(String sql)
	{
		Connection con=myGetConnection();
		ResultSet rs=null;
		Statement stmt;
		try {
			stmt= con.createStatement();
			 rs= stmt.executeQuery(sql);
		}
		catch(SQLException e){
			e.printStackTrace();

		}
		return rs;
	}

		
		public boolean SignIn(String username, String password)
		{
			HashMap<String,String> hm= new HashMap<String,String>();
			DAO dao= new DAO();
			
			ResultSet rs=dao.getRows("select username,password from user_info ");
			String uname=null;
			String pwd=null;
			
			try {
				while(rs.next())
				{
					 uname=rs.getString(1);
					 pwd=rs.getString(2);
					
					hm.put(uname, pwd);
				}
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(hm.containsKey(username) )
			{
				if(hm.get(username).equals(password))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		
	
	
	public void SignUp(String name, String gender,String contact, String username, String password)
	{
		// get a connection 
		Connection con = myGetConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into user_info values(?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, contact);
			pstmt.setString(4, username);
			pstmt.setString(5,password );
			pstmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
	
	
	
}
