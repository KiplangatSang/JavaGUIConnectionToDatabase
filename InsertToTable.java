

    
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import javax.swing.*;

public class InsertToTable extends JFrame {
public JLabel database, table,tableinput,key;
                  
public JTextField databasetf,tabletf,tableinputtf,keytf;
public JButton cancel,create;
	public InsertToTable() {
		setTitle("Inserting Values To A Table");
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5,2));
                database=new JLabel("Enter Database name");
                databasetf=new JTextField();
		table = new JLabel("Enter Table Name");
                tabletf= new JTextField();
		tableinput = new JLabel("Enter Values");
                tableinputtf= new JTextField();
		key = new JLabel("Enter Primary Key");
                
		keytf = new JTextField();
		cancel = new JButton("Cancel");
		create= new JButton("Insert");
                pane.add(database);
                pane.add(databasetf);
		pane.add(table);
		pane.add(tabletf);
		pane.add(tableinput);
		pane.add(tableinputtf);
		//pane.add(key);
		//pane.add(keytf);
		pane.add(cancel);
		pane.add(create);
		Create ca  = new Create();
		Cancel aAXS  = new Cancel();
		create.addActionListener(ca);
		cancel.addActionListener(aAXS);
			create.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent b){
                setVisible(false);
                new CRUDOperations().setVisible(true);
                }
                
                });
            JMenuBar obj=new JMenuBar();
                //add jmenu bar to jframe
                setJMenuBar(obj);
                //create jmenus
                JMenu file= new JMenu("File");
               // add jmenus  to obj
                obj.add(file);
                //create jmenu items
                            JMenuItem home=new JMenuItem("Home");
home.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new CRUDOperations().setVisible(true);
    }
});
file.add(home);
                JMenuItem open=new JMenuItem("Open");
                //add jmenu item to jmenu
                file.add(open);
         JMenuItem save=new JMenuItem("Save");
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
		TableCreater j = new TableCreater();
	}
	class Create implements ActionListener{

		@Override
                
		public void actionPerformed(ActionEvent arg0) {
                    String databasev= databasetf.getText();
                    String tablename=tabletf.getText();
                    String values=tableinputtf.getText();
                   // String primarykey=keytf.getText();
			
			if(arg0.getActionCommand().equals("Cancel")) {
				tabletf.setText("");
				tableinputtf.setText("");
				keytf.setText("");}
		
		
                // create connection
                    String connect="jdbc:mysql://localhost:3306/"+databasev;
                    System.out.println(connect);
                    String username="root";
                    String password="";
                    //sql statement for insert
         String query = "INSERT INTO  "+ tablename +" "+
                   " VALUES (" +values+ ")";
        // String sql = "INSERT INTO Registration " +
         //          "VALUES (100, 'Zara', 'Ali', 18)";
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
  String b="successfully done";                  
System.out.println(b);
	}}
	class Cancel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
                        databasetf.setText("");
			tabletf.setText("");
			tableinputtf.setText("");
			keytf.setText("");
                }
	   
        }}



