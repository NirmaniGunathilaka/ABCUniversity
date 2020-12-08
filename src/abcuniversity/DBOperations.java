
package abcuniversity;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class DBOperations {
   String url = "jdbc:mysql://localhost:3306/abcuniversity";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    
    boolean addStudent(Student stu){
         try{
        System.out.println("Add Student 1");
        con=DriverManager.getConnection(url, username, password);//get the connection
        String query="INSERT INTO studentdetails VALUES(?,?,?,?,?,?,?,?,?)";
        pst=(PreparedStatement)con.prepareStatement(query);
        System.out.println("Add Student 2");
        pst.setInt(1, stu.getRegID());//add values to the sql query
        pst.setString(2, stu.getFirstName());//add values to the sql query
        pst.setString(3, stu.getLastName());//add values to the sql query
        pst.setInt(4, stu.getAge());//add values to the sql query
        pst.setString(5, stu.getAddress());//add values to the sql query
        pst.setString(6, stu.getGender());//add values to the sql query
        pst.setString(7, stu.getFaculty());//add values to the sql query
        pst.setString(8, stu.getDepartment());//add values to the sql query
        pst.setInt(9, stu.getYearOfReg());//add values to the sql query
        System.out.println("Add Student 3");
        pst. executeUpdate();//execute the sql query and insert the values to the db table
        System.out.println("Add Student 4");
        return true;
    }catch(Exception e){
       System.out.println(e);
       return false;
    }finally{
       try{
           if(pst!=null){
               pst.close();
           }
       
           if(con!=null){
              con.close();
           }
        }catch(Exception e){}
           
    }  
    } 
    
    ArrayList<Student> getStudent(){
        try{
            ArrayList<Student> list=new ArrayList<Student>();
        System.out.println("Get Student 1");
        con=DriverManager.getConnection(url, username, password);//get the connection
        String query="SELECT *FROM studentdetails";
        pst=(PreparedStatement)con.prepareStatement(query);
        System.out.println("Get Student 2");
       rs= pst. executeQuery ();
       
       while(rs.next()){
          Student s=new Student();
          s.setRegID(rs.getInt(1));
          s.setFirstName(rs.getString(2));
          s.setLastName(rs.getString(3));
          s.setAge(rs.getInt(4));
          s.setAddress(rs.getString(5));
          s.setGender(rs.getString(6));
          s.setFaculty(rs.getString(7));
          s.setDepartment(rs.getString(8));
          s.setYearOfReg(rs.getInt(9));
          list.add(s);
       }
       return list;
        }catch(Exception e){
       System.out.println(e);
       return null;
    }finally{
       try{
           if(pst!=null){
               pst.close();
           }
       
           if(con!=null){
              con.close();
           }
        }catch(Exception e){}
           
    }  
    }
    
    public boolean updateStudent(Student em){
       try{
          System.out.println("Update Student 1");
          con=DriverManager.getConnection(url, username, password);//get the connection
          String query="UPDATE studentdetails SET firstname='"+em.getFirstName()+"',lastname='"+em.getLastName()+"',age="+em.getAge()+",address='"+em.getAddress()+"',gender='"+em.getGender()+"',faculty='"+em.getFaculty()+"',department='"+em.getDepartment()+"',yearofreg="+em.getYearOfReg()+" WHERE regid="+em.getRegID()+"";
          pst=(PreparedStatement)con.prepareStatement(query);
          System.out.println("Update Student 2");
          pst. executeUpdate();
           System.out.println("Update Student 3");

          return true;
         }catch(Exception e){
       System.out.println(e);
       return false;
    }finally{
       try{
           if(pst!=null){
               pst.close();
           }
       
           if(con!=null){
              con.close();
           }
        }catch(Exception e){}
           
    }    
    }
    
    public boolean deleteStudent(Student em){
        try{
          System.out.println("Delete Student 1");
          con=DriverManager.getConnection(url, username, password);//get the connection
          String query="DELETE FROM studentdetails WHERE regid="+em.getRegID();
          pst=(PreparedStatement)con.prepareStatement(query);
          System.out.println("Delete Student 2");
          pst. executeUpdate();
           System.out.println("Delete Student 3");

          return true;
         }catch(Exception e){
       System.out.println(e);
       return false;
    }finally{
       try{
           if(pst!=null){
               pst.close();
           }
       
           if(con!=null){
              con.close();
           }
        }catch(Exception e){}
           
    }    
    
    }
    
 
}
