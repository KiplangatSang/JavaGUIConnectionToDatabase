

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class  DropDatabase extends JFrame {
    JLabel name,idno,databasename;
    JTextField nametf,idnotf,databasenametf;
    JButton create,cancel;
    //use a constructor
    public DropDatabase(){
        
      
     // creating a JMenu
    JMenuBar obj=new JMenuBar();
  setJMenuBar(obj);
    JMenu file=new JMenu("File");
    
    
    obj.add(file);
   
    
    
   
   JMenuItem save=new JMenuItem("Create a new table");
save.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new TableCreater().setVisible(true);
    }
});
file.add(save);
   
   JMenuItem home=new JMenuItem("Home");
home.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Database().setVisible(true);
    }
});
file.add(home);
    
    
    
    
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
   /* JMenuItem paste=new JMenuItem("paste");
    edit.add(paste);
    JMenuItem undo= new JMenuItem("undo");
    edit.add(undo);
    JMenuItem delete=new JMenuItem("Delete");
    edit.add(delete);*/
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
    setTitle("Drop A DATABASE");
    setVisible(true);
    setSize(500,500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  
         //create  a container
    Container pane=getContentPane();
    pane.setLayout(new GridLayout(4,2));
    //ADD content to jlabel
    name =new JLabel("Name");
    idno=new JLabel("ID Number");
    databasename=new JLabel("Enter Database Name");
    //add to jtextfield
    nametf=new JTextField();
    idnotf=new JTextField();
    databasenametf=new JTextField();
    create=new JButton("Drop Database");
    cancel=new JButton("Cancel");
    
    //add jlabel and jtextfieldto pane
    pane.add(name);
     pane.add(nametf);
  
    pane.add(databasename);
    pane.add(databasenametf);
    pane.add(cancel);
    pane.add(create);
    
    
    //adding actionlistener
   Dropper sang= new Dropper();
    create.addActionListener(sang);
    Cancel b=new Cancel();
    cancel.addActionListener(b);
    create.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed(ActionEvent c){
    setVisible(false);
    new Database().setVisible(true);
    }
    
    });
   
    }
    //creating class for create
     class Dropper implements ActionListener{
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
      System.out.println("dropping the database...");
      stmt = conn.createStatement();
      String querry="DROP DATABASE "+""+ Database; 
      
      System.out.println(querry);
      String sql =querry ;
      stmt.executeUpdate(sql);
      System.out.println("Database dropped successfully...");
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
   //System.out.println("Goodbye!");
}
     }

   class Cancel implements ActionListener{
   public void actionPerformed(ActionEvent a){
   nametf.setText("");
   databasenametf.setText("");
   
   }
   
   }          
    
    

public static void main(String []args){
Database data=new Database();
  
    
    
}}

    
    
    
    
    


