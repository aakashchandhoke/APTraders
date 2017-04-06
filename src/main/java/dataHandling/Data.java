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
import java.sql.*;
public class Data {

        public static void addData(String name,String mail,String message)
    {
        try
        {
            /*String sr="Mithu\\Aakash";        
            String db="cms";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
            Connection cn=DriverManager.getConnection("Jdbc:Odbc:Driver={sql server};server="+sr+";database="+db);*/
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            //Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aakash" , "root","aakash");
            Connection cn =DriverManager.getConnection("jdbc:mysql://localhost/aakash?" +
                                   "user=root&password=aakash");
            PreparedStatement pst;
            pst=cn.prepareStatement("insert into val values(?,?,?)");
            pst.setString(1, name);
            pst.setString(2,mail);
            pst.setString(3,message);
            int x=pst.executeUpdate();
            if(x==1)
                System.out.print("Success");
            else
                System.out.print("not success");
                
        }
        catch(Exception ee)
        {
            System.out.print(ee.getMessage());
        }
    }
    
}
