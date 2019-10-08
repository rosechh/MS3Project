package MS3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.sqlite.util.StringUtils;

public class csv {
    //Connects to the database
    private static String JDBC_CONNECTION_URL = 
			"jdbc:sqlite:test.db";
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String csvFile = "/Users/Rojaleen/Downloads/ms3Interview.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        boolean HeadRowExists = true;
	        int AcceptedNumberofColumns = 10;
	        int IncorrectRecords = 0;
                String[] studentO = null;
                 
	      //Creates List for holding Student objects
              List<studentO> studentList = new ArrayList<studentO>();
	        
	        try {
				br = new BufferedReader(new FileReader(csvFile));
				
				           
	            if(HeadRowExists) {
	            	String HeadRow = br.readLine();
	         
	            	if(HeadRow==null || HeadRow.isEmpty()) {
	            		throw new FileNotFoundException(
	        					"No columns defined in given CSV file." +
	        					"Please check the CSV file format.");
	            	}
	            }
	            
				 while ((line = br.readLine()) != null) {

		                // use comma as separator
					 studentO = line.split(cvsSplitBy);
		                
		                if(studentO.length > 0 && studentO.length == AcceptedNumberofColumns)
		                {
		                    
		                	studentO emp = new studentO(studentO[1],studentO[2],studentO[3],studentO[4],studentO[5],studentO[6],Float.parseFloat(studentO[7]),Boolean.parseBoolean(studentO[8]),Boolean.parseBoolean(studentO[9]),studentO[10]);
		                    studentList.add(emp);
		                }
		                else {
		                	
		                	IncorrectRecords++;
		                }   
				 }
	                
	                LoadCSVintoDatabase(studentList);
			} catch (FileNotFoundException e) {
				//catch block
				e.printStackTrace();
			} catch (IOException e) {
				//catch block
				e.printStackTrace();
			}
	        
	        
	        
	        System.out.println("Following are the statistics :\n#"+
	        		studentO.length+" of records received.\n#"+
	        		studentList.size()+" of records processed.\n#"+
	        		IncorrectRecords+" of records failed.");
	}

	private static void LoadCSVintoDatabase(List<studentO> studentList, Iterable<studentO> studentList) {
		Connection connection = null;
		boolean tableExists = true;
		boolean truncateTable = true;
		
		try {
			//Class.forName("org.sqlite.JDBC");
			
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL);
			
			if(tableExists != true) {
				connection.createStatement().execute("create table details(firstname, lastname, email, gender, imgcode, cardtype, tax, c1, c2, country)");
			}
			
			if(truncateTable == true) {
				connection.createStatement().execute("delete from details");
			}
				
			
			PreparedStatement stmt =
					connection.prepareStatement("insert into details (firstname, lastname, email, gender, imgcode, cardtype, tax, c1, c2, country) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			for(studentO e : studentList)
            {
				
				stmt.setString(1, e.getFirstname());
				stmt.setString(2, e.getLastname());
				stmt.setString(3, e.getemail());
				stmt.setString(4, e.getgender());
				stmt.setString(5, e.getimgcode());
				stmt.setString(6, e.getcardtype());
				stmt.setFloat(7, e.gettax());
				stmt.setBoolean(8, e.getc1());
				stmt.setBoolean(9, e.getc2());
				stmt.setString(10, e.getCountry());
				
				stmt.executeUpdate();
            }
			
			System.out.println("Result of SELECT\n");
			
			ResultSet rs = connection.createStatement().executeQuery("select * from studentO");
			
			while(rs.next()) {
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String email = rs.getString(3);
				String gender = rs.getString(3);
				String imgcode = rs.getString(3);
				String cardtype = rs.getString(4);
				float tax = rs.getFloat(3);
				boolean c1 = rs.getBoolean(4);
				boolean c2 = rs.getBoolean(5);
				String country = rs.getString(8);
				
				System.out.println(firstname+"\t"+lastname+"\t"+email+"\t"+gender+"\t"+imgcode+"\t"
				+cardtype+"\t"+tax+"\t"+c1+"\t"+c2+"\t"+country);
			}
			
		} catch (SQLException e) {
			//catch block
			e.printStackTrace();
                }
	}
}