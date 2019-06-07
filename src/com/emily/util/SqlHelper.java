package com.emily.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
 

/**
 * 
 * @author Emily
 *This is a tool class for operating the database.
 */
public class SqlHelper {
	//Define the needed variables.
		private static Connection ct=null;
		//Use PreparedStatement instead of Statement to prevent sql injection.
		
		private static PreparedStatement ps=null;
		private static ResultSet rs=null;
		private static CallableStatement cs=null;
		
		 
		//Load driver only once by using static.
		 
			//get connection
			public static Connection getConnection(){
				
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 String user= System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
					 String password=System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
					 //String url= System.getenv("OPENSHIFT_MYSQL_DB_URL");
					 String host=System.getenv("OPENSHIFT_MYSQL_DB_HOST");
					 String port=System.getenv("OPENSHIFT_MYSQL_DB_PORT");
					 String dbname= "servletjsp";
					 String url = "jdbc:mysql://"+host+":"+port+"/"+dbname;
					 ct = DriverManager.getConnection(url, user, password);
				} catch(Exception e){
					e.printStackTrace();
				}
				return ct;
			}
	
 
	
	
	 
	//Make the pagination.
	/*public static ResultSet executeQuery2(){
		return null;
	}
	*/
	//invoke saved procedure
	//sql call(?,?,?)
	public static CallableStatement callPro2
	(String sql, String [] inparameters, Integer [] outparameters){

		try{
			ct=getConnection();
			cs=ct.prepareCall(sql);
			if(inparameters!=null){
				for(int i=0;i<inparameters.length;i++){
					cs.setObject(i+1, inparameters[i]);
				}
			}
		
			//give outparameter values
			if(outparameters!=null){
				for(int i=0;i<outparameters.length;i++){
					cs.registerOutParameter(inparameters.length+1+i, outparameters[i]);
				}	
			}
		
			cs.execute();

		} catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());

		}finally{
				//no need of close
				close(rs,cs,ct);
		}
		return cs;
	}
	
	//invoke the saved procedure
	//sql {call (?,?,?)}
	public static void callPro1(String sql, String [] parameters){
		
		try{
			ct=getConnection();
			cs=ct.prepareCall(sql);
			
			//give ? value
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					cs.setObject(i+1, parameters[i]);
				}
			}
			cs.execute();
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());

		}finally{
		
			close(rs,cs,ct);
		}
	}

	//the unified select
	//ResultSet -> ArrayList
	public static ResultSet executeQuery(String sql, String [] parameters){
		
		try{

			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null){
				
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			rs=ps.executeQuery();

		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());

		}finally{
			//close (rs,ps,ct);
		}

		return rs;

	}
	
	//If there are multiple update/ delete / insert
	public static void executeUpdate2(String sql[], String [][]parameters){
		
		try{

			//1. get connection
			ct=getConnection();
			
			//Users might submit multiple sqls

			ct.setAutoCommit(false);
			//..
			for(int i=0;i<sql.length;i++){
				if(parameters[i]!=null){
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;j++){

						ps.setString(j+1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
	 

			ct.commit();

		
		} catch(Exception e){
			e.printStackTrace();
	
			//rollback
				try{
				ct.rollback();
				} catch (SQLException el){

					el.printStackTrace();
				}

				throw new RuntimeException(e.getMessage());
				
		}finally{
			close(rs,ps,ct);
		}

	}

	//Write a update/delete/insert first.
	//sql format: update table name set field name=? where field name =?
	//parameters is ("abc","123");
	
	public static void executeUpdate(String sql, String [] parameters){
		//1. create a ps
		try{
			

			ct =getConnection();
			ps=ct.prepareStatement(sql);
			//give ? value
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			
			//execute
			ps.executeUpdate();

		}
		catch(Exception e){
			e.printStackTrace();
			
			throw new RuntimeException(e.getMessage());
			
		}finally{
			close(rs, ps, ct);
		}
		
	}
	
	//Close the resource methods.
	public static void close(ResultSet rs, Statement ps, Connection ct){
		if(rs!=null){
			try{
				rs.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			rs=null;
		}
		
		if(ps!=null){
			try{
				ps.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			ps=null;
		}
		
		if(ct!=null){
			try{
				ct.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			ct=null;
		}
	}
	
	public static Connection getCt(){
		return ct;
	}
	
	public static PreparedStatement getPs(){
		return ps;
	}
	
	public static ResultSet getRs(){
		return rs;
	}
	
	public static CallableStatement getCs(){
		return cs;
	}
	
}

