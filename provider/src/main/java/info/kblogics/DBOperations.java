package info.kblogics;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface DBOperations {

	@WebMethod
	@WebResult(name="empDetails")
	public List<Employee> getEmp();
		
	@WebMethod
	public void saveEmp();
}
