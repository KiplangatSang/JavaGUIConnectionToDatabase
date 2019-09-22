

    

    
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import static javafx.scene.paint.Color.color;
import javax.swing.*;

public class UpdateTable extends JFrame {
public JLabel database, table,tableinput,key,item,itemvalue;
                  
public JTextField databasetf,tabletf,tableinputtf,keytf,itemtf,itemvaluetf;
public JButton cancel,create;
	public UpdateTable() {
		setTitle("Update A Table");
               
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(7,2));
                database=new JLabel("Enter Database name");
                databasetf=new JTextField();
		table = new JLabel("Enter Table Name");
                tabletf= new JTextField();
		tableinput = new JLabel("Update");
                tableinputtf= new JTextField();
		key = new JLabel("is");
		keytf = new JTextField();
                item=new JLabel("where");
                itemtf=new JTextField();
                itemvalue=new JLabel("is");
                itemvaluetf=new JTextField();
		cancel = new JButton("Cancel");
		create= new JButton("update");
                pane.add(database);
                pane.add(databasetf);
		pane.add(table);
		pane.add(tabletf);
		pane.add(tableinput);
		pane.add(tableinputtf);
		pane.add(key);
		pane.add(keytf);
                pane.add(item);
                pane.add(itemtf);
                pane.add(itemvalue);
                pane.add(itemvaluetf);
		pane.add(cancel);
		pane.add(create);
                pane.setForeground(Color.blue);
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
        new CRUDOperations().setVisible(true);
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
	}
       
	public static void main(String[] args) {
		UpdateTable j = new UpdateTable();
	}
	class Create implements ActionListener{

		@Override
                
		public void actionPerformed(ActionEvent arg0) {
                    String databasev= databasetf.getText();
                    String tablename=tabletf.getText();
                    String values=tableinputtf.getText();
                    String newItemValue=keytf.getText();
                    String referenceItem=itemtf.getText();
                    String referenceItemValue=itemvaluetf.getText();
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
         String query = "UPDATE   "+ tablename +" "+
                   " SET  "+" "+ values+" "+" =  " + newItemValue+ "  "+" WHERE " 
                 +referenceItem+" "+"= ("+
                 referenceItemValue +")";
         String sql = "UPDATE Registration " +
                   "SET age = 30 WHERE id in (100, 101)";
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
			tabletf.setText("");
			tableinputtf.setText("");
			keytf.setText("");
                        databasetf.setText("");
                        itemtf.setText("");
                        itemvaluetf.setText("");
                }
	   
        }}





