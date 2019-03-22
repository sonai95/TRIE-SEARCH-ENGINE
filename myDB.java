package myproj3;
import java.sql.*;
import java.util.ArrayList;
public class myDB {
	private Connection cn;
	private Statement st;
	private ResultSet rs;
	private Statement st1;
	private ResultSet rs1;
	ArrayList<String> arr = new ArrayList<>();
	public myDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			st = cn.createStatement();
		}
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
	}
	public ArrayList<String> getData(){
		try{
			String query = "select * from tokens";
			rs = st.executeQuery(query);
			while(rs.next()){
				arr.add(rs.getString("s_token"));
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return arr;
	}
	public ArrayList<Integer> getClicks(){
		ArrayList<Integer> arr1 = new ArrayList<>();
		try{
			String query1 = "select * from tokens";
			rs = st.executeQuery(query1);
			while(rs.next()){
				arr1.add(rs.getInt("s_clicks"));
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return arr1;
	}
}
