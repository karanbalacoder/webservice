package info.kblogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {

	public void insertEmployee(Employee employee) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karan", "bala");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into emp_tbl values(?,?,?)");
			preparedStatement.setInt(1, employee.getEno());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public ArrayList<Employee> getEmployees() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karan", "bala");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from emp_tbl");
		ArrayList<Employee> empList = new ArrayList<Employee>();

		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setEno(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setSalary(resultSet.getDouble(3));
			empList.add(employee);
		}

		return empList;
	}

	
	public void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karan", "bala");
		PreparedStatement preparedStatement = connection.prepareStatement("update  emp_tbl set name=?,salary=? where eno=?");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setDouble(2, employee.getSalary());
		preparedStatement.setDouble(3, employee.getEno());
		preparedStatement.executeUpdate();
		
	}

public void delete(Integer eno) throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "karan", "bala");
	PreparedStatement preparedStatement = connection.prepareStatement("delete from emp_tbl where eno=?");
	preparedStatement.setInt(1, eno);
	preparedStatement.executeUpdate();
}
}
