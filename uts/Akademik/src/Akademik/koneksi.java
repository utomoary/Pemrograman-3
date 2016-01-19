package Akademik;
import java.sql.*;

public class koneksi {
Connection Conn = null;
public koneksi() {
}
public Connection getCon() {
   try{
    Class.forName("com.mysql.jdbc.Driver");
    Conn = DriverManager.getConnection("jdbc:mysql://localhost/akademik","root","");
    System.out.println("Berhasil Koneksi");
    }
    catch(ClassNotFoundException | SQLException e){
        System.out.println("Gagal Koneksi");
    }
return Conn;
}
}
