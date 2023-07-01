 
package bank.management.system1;
import java.sql.*;
 
public class Conn {
    Connection c;
    Statement s;
    public Conn(){  
        try{  
               
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Atpss@9935");
            
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}
