import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

public class DropingATable extends JFrame {
 
public JLabel table,database;
public JTextField databasetf, tabletf;
public JButton drop;
	public DropingATable() {
		setTitle("Drop A TABLE");
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4,2));
		database=new JLabel("Enter Database Name");
                databasetf=new JTextField();
		table = new JLabel("Enter Table Name");

		tabletf = new JTextField();
		

		drop = new JButton("drop");
                pane.add(database);
		pane.add(databasetf);
		pane.add(table);
		pane.add(tabletf);
		pane.add(drop);
		drop.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b){
                setVisible(false);
                new CRUDOperations().setVisible(true);
                }
                
                });
		Drop ca  = new Drop();
		
		drop.addActionListener(ca);
			
            JMenuBar obj=new JMenuBar();
                //add jmenu bar to jframe
                setJMenuBar(obj);
                //create jmenus
                JMenu file= new JMenu("File");
               // add jmenus  to obj
                obj.add(file);
                //create jmenu items
                //JMenuItem open=new JMenuItem("Open");
                //add jmenu item to jmenu
               // file.add(open);
         JMenuItem save=new JMenuItem("Save");
            JMenuItem home=new JMenuItem("Home");
home.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new CRUDOperations().setVisible(true);
    }
});
file.add(home);
                //add jmenu item to jmenu
                file.add(save);
                 JMenuItem exit=new JMenuItem("Exit");
                //add jmenu item to jmenu
                file.add(exit);
                JMenu edit= new JMenu("Edit");
                obj.add(edit);
                JMenuItem paste =new JMenuItem("Paste");
                edit.add(paste);
                JMenuItem cut =new JMenuItem("Cut");
                edit.add(cut);
                JMenuItem copy =new JMenuItem("copy");
                edit.add(copy);
                JMenu help=new JMenu("Help");
                obj.add(help);
                JMenuItem contactUs=new JMenuItem("ContactUs");
                help.add(contactUs);
	}
       
	public static void main(String[] args) {
		DropingATable j = new DropingATable();
	}
	class Drop implements ActionListener{

		@Override
                
		public void actionPerformed(ActionEvent arg0) {
                    String tablename=tabletf.getText();
                     String databasename=databasetf.getText();
                // create connection
                    String connect="jdbc:mysql://localhost:3306/"+databasename;
                    String username="root";
                    String password="";
                   
                    //sql statement for insert
                    String query="DROP TABLE "+""+tablename;
                        System.out.println(query);
                           
                    try{
                    //getconnection
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=(Connection) DriverManager.getConnection(connect,username,password);
                    Statement s=(Statement) con.prepareStatement(query);
                    s.execute(query);
                    
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    
                    }
		
                }}}

	   
       



