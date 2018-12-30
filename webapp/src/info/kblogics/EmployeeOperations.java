package info.kblogics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/emp")
public class EmployeeOperations {
	
	@POST
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public javax.ws.rs.core.Response insertRecords(Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.insertEmployee(employee);
		return javax.ws.rs.core.Response.accepted().build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public List<Employee> getEmp() throws ClassNotFoundException, SQLException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList<Employee> empList = employeeDAO.getEmployees();
	return empList;	
	}
	
	@PUT
	public javax.ws.rs.core.Response update(Employee employee) throws ClassNotFoundException, SQLException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.updateEmployee(employee);
		return javax.ws.rs.core.Response.status(209).build();
	}

	@DELETE
	@Path("{eno}")
public javax.ws.rs.core.Response delete(@PathParam( "eno") Integer  eno) throws Exception{
	EmployeeDAO employeeDAO = new EmployeeDAO();
	employeeDAO.delete(eno);
	
	return javax.ws.rs.core.Response.ok().build();
}

}
