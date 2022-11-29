//program to insert image in mysql table
Connection con = null;
 Statement stmt = null;
 FileInputStream fs=null;
 PreparedStatement ps=null;
 
    
 try 
 {
     
		   String driverName = "com.mysql.jdbc.Driver";
		    Class.forName(driverName);
String url ="jdbc:mysql://127.0.0.1:3306/images";
     //Step 1 : Connecting to server and database
     con = DriverManager.getConnection(url,"root", "");    
     	    
     File f=new File("c:\\temp\\abcd.jpg");
     fs=new FileInputStream(f);
     
     ps= con.prepareStatement("INSERT INTO image VALUES(?)");
     
     ps.setBinaryStream(1,fs,(int)f.length());
     ps.executeUpdate();
     System.out.println("Image Stored Successfully");
   
 } 
 
 catch (Exception e) 
 {
     System.err.println("Cannot connect ! ");
     e.printStackTrace();
 }


      