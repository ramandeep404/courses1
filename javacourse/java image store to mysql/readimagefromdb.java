//program to read image from mysql table
FileOutputStream fs=null;
 try 
 {
     String driverName = "com.mysql.jdbc.Driver";
		    Class.forName(driverName);
String url ="jdbc:mysql://127.0.0.1:3306/images";
Statement stmt;
		int rs;
		Connection con =DriverManager.getConnection(url,"root", "");
     //Step 1 : Connecting to server and database
    
      PreparedStatement ps= con.prepareStatement("SELECT * FROM image");
     ResultSet rset=ps.executeQuery();
     	    
     byte b[];
     Blob blob;
     int i=1;
     while(rset.next())
     {
      
      
      File f=new File("c:\\temp\\abcde.jpg");
     fs=new FileOutputStream(f);
      blob=rset.getBlob("img");
      b=blob.getBytes(1, (int)blob.length());
      fs.write(b);
     }
     System.out.println("Image Read");
 }
 
 catch (Exception e) 
 {
     System.err.println("Cannot connect ! ");
     e.printStackTrace();
 }
 