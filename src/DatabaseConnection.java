/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoshuaKuiros
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseConnection {
    public static Connection dbConn;
    
    public static void establishConnection() {
        // declare variables we need
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        dbConn=null;
        Statement stmt;
        ResultSet results;
        String sql;
        try {
            // start Derby engine
            Class.forName(driver).newInstance();
            
            // get a jdbc connection
            String protocol = "jdbc:derby:";
            String dbName = "FinalDB4";   // the default database name
            dbConn = DriverManager.getConnection(protocol+dbName+";create=true");
            stmt = dbConn.createStatement();

            // test to see if we need to run the initial sql script
            DatabaseMetaData dbMeta = dbConn.getMetaData();
            String[] tableTypes = {"TABLE"};
            results = dbMeta.getTables(null, null, "%", tableTypes );
            
            if ( !results.next() ) {
                // no table found, we need to execut the initial sql statements
                // first read the sql script
                System.out.println("No Table Found");
                InputStream is = DatabaseConnection.class.getResourceAsStream("createDB.sql");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    if (line.contains(";")) {
                        sql = sb.toString();
                        sb = new StringBuilder();
                        // executeQuery cannot process ; so remove it from sql
                        sql = sql.substring(0, sql.indexOf(';'));
                        // run sql here
                        if (sql.toUpperCase().contains("SELECT")) {
                            // SELECT statement
                            stmt.executeQuery(sql);
                        }
                        else {
                            // All ohter type of statements
                            stmt.execute(sql);
                        }
                    }
                    line = br.readLine();
                }
            // test
            sql = "SELECT * from question_bank";
            results = stmt.executeQuery(sql);
            while (results.next()) {
                System.out.println(results.getString("text"));
            }
            }
            System.out.println("Table Found");
            results.close();
            stmt.close();
        }
        // don't have much about exception handling yet
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // could not start Derby engine
            e.printStackTrace();
        }
        catch (SQLException e) {
            // could not connect to Derby
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }      
    }
    public static void closeConnection() {
        try {
            System.out.print("Connection Closed");
            dbConn.close();
        }
        catch(SQLException e) {
            System.out.print("Connection NOT Closed");
            e.printStackTrace();
        }
    }
//        public static void main(String[] args) {
//        // declare variables we need
//        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
//        dbConn=null;
//        Statement stmt;
//        ResultSet results;
//        String sql;
//        try {
//            // start Derby engine
//            Class.forName(driver).newInstance();
//            
//            // get a jdbc connection
//            String protocol = "jdbc:derby:";
//            String dbName = "PleaseWork1";   // the default database name
//            dbConn = DriverManager.getConnection(protocol+dbName+";create=true");
//            stmt = dbConn.createStatement();
//
//            // test to see if we need to run the initial sql script
//            DatabaseMetaData dbMeta = dbConn.getMetaData();
//            String[] tableTypes = {"TABLE"};
//            results = dbMeta.getTables(null, null, "%", tableTypes );
//            
//            if ( !results.next() ) {
//                // no table found, we need to execut the initial sql statements
//                // first read the sql script
//                InputStream is = DatabaseConnection.class.getResourceAsStream("initSQL.sql");
//                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader br = new BufferedReader(isr);
//                StringBuilder sb = new StringBuilder();
//                String line;
//                line = br.readLine();
//                while (line != null) {
//                    sb.append(line);
//                    if (line.contains(";")) {
//                        sql = sb.toString();
//                        sb = new StringBuilder();
//                        // executeQuery cannot process ; so remove it from sql
//                        sql = sql.substring(0, sql.indexOf(';'));
//                        // run sql here
//                        if (sql.toUpperCase().contains("SELECT")) {
//                            // SELECT statement
//                            stmt.executeQuery(sql);
//                        }
//                        else {
//                            // All ohter type of statements
//                            stmt.execute(sql);
//                        }
//                    }
//                    line = br.readLine();
//                }
//            }
//            
//            // test
//            sql = "SELECT * from question_bank";
//            results = stmt.executeQuery(sql);
//            while (results.next()) {
//                System.out.println(results.getString("text"));
//            }
//            results.close();
//            stmt.close();
//            dbConn.close();
//        }
//        // don't have much about exception handling yet
//        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            // could not start Derby engine
//            e.printStackTrace();
//        }
//        catch (SQLException e) {
//            // could not connect to Derby
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }      
//    }
}
