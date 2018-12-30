
package info.kblogics;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOperationsImpl implements DBOperations {
	
	@Override
	public List<Employee> getEmp() {
		ArrayList<Employee> arrayList = new ArrayList<Employee>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karan", "bala");
		Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp_tbl");
			
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setEno(resultSet.getInt("eno"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				arrayList.add(employee);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayList;

	
	}

	@Override
	public void saveEmp() {
		
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karan", "bala");
			PreparedStatement prepareStatement = connection.prepareStatement("insert into emp_tbl values(1123,'birju',10000.5)");
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
