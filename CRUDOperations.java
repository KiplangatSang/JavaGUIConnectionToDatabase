
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiplangatsang
 */

    import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class CRUDOperations extends JFrame {
    JLabel name,idno,databasename;
    JTextField nametf,idnotf,databasenametf;
    JButton Update,insert,drop,CreateTable;
    //use a constructor
    public CRUDOperations(){
        
      
     // creating a JMenu
    JMenuBar obj=new JMenuBar();
  setJMenuBar(obj);
    JMenu file=new JMenu("File");
    
    
    obj.add(file);
   
       JMenuItem home=new JMenuItem("Home ");
home.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Database().setVisible(true);
    }
});
file.add(home);
    
   
   JMenuItem save=new JMenuItem("Create a new table");
save.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new TableCreater().setVisible(true);
    }
});
file.add(save);
    
    
    
    
    //edit
    JMenu edit=new JMenu("Edit");
    
    obj.add(edit);
    JMenuItem copy=new JMenuItem("Drop Table");
    copy.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent b){
    setVisible(false);
    new DropingATable().setVisible(true);}
    
    });
    
    edit.add(copy);
    //inserting to table
    JMenuItem paste=new JMenuItem("Insert To Table");
    
    paste.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent b){
    setVisible(false);
    new InsertToTable().setVisible(true);}
    
    });
    edit.add(paste);
    JMenuItem update= new JMenuItem("Update Table");
     
    paste.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent b){
    setVisible(false);
    new UpdateTable().setVisible(true);}
    
    });
    edit.add(update);
    JMenuItem delete=new JMenuItem("Delete");
    edit.add(delete);
    //open
   /* JMenu open=new JMenu("Open");
    obj.add(open);
    JMenuItem open_Now=new JMenuItem("Open");
    open.add(open_Now);
    JMenuItem openwith=new JMenuItem("Open with"); 
   JMenuItem fullscreen=new JMenuItem("View Full Screen");
   open.add(fullscreen);
   //tools
    JMenu tools=new JMenu("Tools");
    obj.add(tools);*/
    setTitle("CRUD OPERATIONS");
    setVisible(true);
    setSize(500,500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  
         //create  a container
    Container pane=getContentPane();
    pane.setLayout(new GridLayout(4,2));
   /* //ADD content to jlabel
    name =new JLabel("Name");
    idno=new JLabel("ID Number");
    databasename=new JLabel("Enter Database Name");
    //add to jtextfield
    nametf=new JTextField();
    idnotf=new JTextField();
//    databasenametf=new JTextField()*/
    Update=new JButton("Update Table");
    insert=new JButton("Insert To Table");
    drop=new JButton("Drop Table");
    CreateTable=new JButton("Create Table");
    //add jlabel and jtextfieldto pane
   /* pane.add(name);
     pane.add(nametf);
  
    pane.add(databasename);
    pane.add(databasenametf);*/
   
    pane.add(CreateTable);
    pane.add(insert);
    pane.add(Update);
    pane.add(drop);
   
    drop.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new DropingATable().setVisible(true);
        
    }
});
       Update.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new UpdateTable().setVisible(true);
        
    }
});
          CreateTable.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new TableCreater().setVisible(true);
        
    }
});
              insert.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new InsertToTable().setVisible(true);
        
    }
});
    //adding actionlistener
  // submit sang= new submit();
  //  create.addActionListener(sang);
    
    
   
    }
    //creating class for create
  /*   class submit implements ActionListener{
         @Override
  public void actionPerformed(ActionEvent e){
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   String DB_URL = "jdbc:mysql://localhost/";
   //  Database credentials
   String USER = "root";
  String PASS = "";
   
        Connection conn = null;
   Statement stmt = null;
   try{
       String Database;
       Database=databasenametf.getText();
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      String querry="CREATE DATABASE "+""+ Database; 
      
      System.out.println(querry);
      String sql =querry ;
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }  catch (ClassNotFoundException ex) {
          Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      }
 
   
   finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}
     }

            */
public static void main(String []args){
Database data=new Database();
  
    
    
}}

    
    
    
    
    


