/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataHandling;

/**
 *
 * @author Aakash
 */
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
public class Data 
{
    /*private static Connection getConnection() throws URISyntaxException, SQLException 
    {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost()+ ':' + dbUri.getPort() + dbUri.getPath();
        return DriverManager.getConnection(dbUrl, username, password);
    }*/
    public static int addData(String name,String mail,String message)
    {
        try
        {
            /*String sr="Mithu\\Aakash";        
            String db="cms";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
            Connection cn=DriverManager.getConnection("Jdbc:Odbc:Driver={sql server};server="+sr+";database="+db);*/
            Class.forName("com.mysql.jdbc.Driver");//for mysql
            // Setup the connection with the DB
            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aakash" , "root","aakash");
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/aakash?" +
                                                            "user=root&password=aakash");
            //Class.forName("org.postgresql.Driver");//for postGressql
            //Connection cn=getConnection();
            //Connection cn=DriverManager.getConnection("jdbc:postgresql://ec2-54-235-119-27.compute-1.amazonaws.com:5432/d1rgsqflof81q3?"+"user=fvizbfisxdefdk&password=8c4c8875ede77750fc911b99f4146350d79be4cc8943ebd4ccd6e0d29e17f54");
            PreparedStatement pst;
            pst=cn.prepareStatement("insert into val values(?,?,?)");
            pst.setString(1, name);
            pst.setString(2,mail);
            pst.setString(3,message);
            int x=pst.executeUpdate();
            if(x==1)
                return 1;
            else
                return 0;
                
        }
        catch(Exception ee)
        {
            System.out.print(ee.getMessage());
            ee.printStackTrace();
            return 0;
           
        }
    }
    
}
