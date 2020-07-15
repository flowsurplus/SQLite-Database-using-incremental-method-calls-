//Michael Jay Marajas
//COP 2805C
import java.sql.*;

public class HighScoreDatabase {
	//Method to create the database 
  public void createDatabase() {
      Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
  
//Method to create the table
  public void createTable() {
	  Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE RECORDS " +
                        "(Name CHAR(15) PRIMARY KEY     NOT NULL," +
                        " Score            INT)";
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
  }
  
//Method to insert values to table RECORDS
  public void insertToTable() {
	  Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO RECORDS (NAME,SCORE) " +
                        "VALUES ('Michael Jay', 3);"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO RECORDS (NAME,SCORE) " +
                  "VALUES ('Professor', 2);"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.commit();
         c.close();
         
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
  
//Method to delete all entries to table RECORDS
  public void deleteRecords() {
	  Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "DELETE FROM RECORDS;";
         stmt.executeUpdate(sql);
         c.commit();
         stmt.close();
         c.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
         }
         System.out.println("Operation done successfully");
      }
  
  
//Method to retrieve all values to table RECORDS
  public void showValues() {
	  Connection c = null;
	   Statement stmt = null;
	   try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM RECORDS;" );
	      
	      while ( rs.next() ) {
	         String  name = rs.getString("name");
	         int score  = rs.getInt("score");
	         
	         System.out.println( "NAME = " + name );
	         System.out.println( "SCORE = " + score );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	   } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	   }
	   System.out.println("Operation done successfully");
	  }
	
  }
  
  
