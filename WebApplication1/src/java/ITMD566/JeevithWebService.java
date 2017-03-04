/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITMD566;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author makan
 */
@WebService(serviceName = "NewWebService_ITMD566")
public class JeevithWebService {

    /**
    * Creates a new instance of a Conneciton class to the SQL Database.
    */
    private Connection getConnection(){
        Class.forName("oracle.jdbc.OracleDriver");


        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
        return connection;
    }

    /**
     * Returns Truck details by name
     */
    @WebMethod(operationName = "getTruckByVinName")
    public String getTruckByVinName(@WebParam(name = "name") String txt) {
        ArrayList truck  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Connection myConnection = this.getConnection();
                Statement statement = myConnection.createStatement();
                int i=0;
                String query =string.format("select * from truck where vin= '%s'", txt);
                ResultSet rs = statement.executeQuery(query);
                while(rs.next()){
                String truckId = rs.getString("TruckID");
                String make = rs.getString("Make");
                String year= rs.getString("Year");
                System.out.println("JeevithWebService.truckList" + truckId+ make+ year);
                truck.add(truckId);
                truck.add(make); 
                truck.add(year);
                }
                System.out.println("test.Test.main()"+ truck.toString());

                statement.close();
                myConnection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
        return truck.toString();
    }
    
    @WebMethod(operationName = "findFromtoTobyCustId")
    public String findFromtoTobyCustId(@WebParam(name = "name") String txt) {
        ArrayList loc  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from pricing where customerid='"+txt+"'";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("LocationNameFrom");
                String a2= rs.getString("LocationNameTo");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2);
                loc.add(a1);
                loc.add(a2); 
                }
                System.out.println("test.Test.main()"+ loc.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return loc.toString();
    }
@WebMethod(operationName = "findTrucByDrid")
    public String findTrucByDrid(@WebParam(name = "name") String txt) {
        ArrayList truck  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from truck where driverid= '"+txt+"'";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("TruckID");
                String a2= rs.getString("Make");
		String a3= rs.getString("Year");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                truck.add(a1);
                truck.add(a2); 
                truck.add(a3);
                }
                System.out.println("test.Test.main()"+ truck.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return truck.toString();
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "expenseByEmpId")
    public String expenseByEmpId(@WebParam(name = "name") String txt) {
        ArrayList exp  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from expense where employeeid='"+txt+"'";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("AmountSpent");
                String a2= rs.getString("PurposeofExpense");
		String a3= rs.getString("DatePurchased");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                exp.add(a1);
                exp.add(a2); 
                exp.add(a3);
                }
                System.out.println("test.Test.main()"+ exp.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return exp.toString();
    }
    
    @WebMethod(operationName = "expenseBytruckId")
    public String expenseBytruckId(@WebParam(name = "name") String txt) {
        ArrayList exp  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from expense where truckid='"+txt+"'";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("AmountSpent");
                String a2= rs.getString("PurposeofExpense");
		String a3= rs.getString("DatePurchased");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                exp.add(a1);
                exp.add(a2); 
                exp.add(a3);
                }
                System.out.println("test.Test.main()"+ exp.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return exp.toString();
    }
    @WebMethod(operationName = "truckList")
    public String truckList() {
        //TODO write your implementation code here:
        ArrayList truck  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="SELECT * FROM truck";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("TruckID");
                String a2= rs.getString("Make");
		String a3= rs.getString("Year");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                truck.add(a1);
                truck.add(a2); 
                truck.add(a3);
                }
                System.out.println("test.Test.main()"+ truck.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return truck.toString();
    }
   @WebMethod(operationName = "driverList")
    public String driverList() {
        //TODO write your implementation code here:
        ArrayList driver  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from employee inner join truckemp on truckemp.employeeID = employee.employeeID";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    System.err.println("----------------------------");
                String a1= rs.getString("EmployeeID");
                String a2= rs.getString("FirstName");
		String a3= rs.getString("LastName");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                driver.add(a1);
                driver.add(a2); 
                driver.add(a3);
                }
                System.out.println("test.Test.main()"+ driver.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return driver.toString();
    }
     @WebMethod(operationName = "employeeList")
    public String employeeList() {
        //TODO write your implementation code here:
        ArrayList employee  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="SELECT * FROM employee";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("EmployeeID");
                String a2= rs.getString("FirstName");
		String a3= rs.getString("LastName");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                employee.add(a1);
                employee.add(a2); 
                employee.add(a3);
                }
                System.out.println("test.Test.main()"+ employee.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return employee.toString();
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "customerList")
    public String customerlist() {
        //TODO write your implementation code here:
     ArrayList Customer  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from customer";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("customerID");
                String a2= rs.getString("CustomerTitle");
		String a3= rs.getString("PhoneNumber");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                Customer.add(a1);
                Customer.add(a2); 
                Customer.add(a3);
                }
                System.out.println("test.Test.main()"+ Customer.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return Customer.toString();
    
    }
    
    @WebMethod(operationName = "orderDetail")
    public String orderDetail() {
        //TODO write your implementation code here:
     ArrayList order  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
                Class.forName("oracle.jdbc.OracleDriver");
                int i=0;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:makani", "system","Tani$1234");
                Statement st=con.createStatement();
                String sql ="select * from orderdetail";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                String a1= rs.getString("OrderID");
                String a2= rs.getString("OrderDate");
		String a3= rs.getString("CustomerID");
                String a4 = rs.getString("TruckID");
                System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                order.add(a1);
                order.add(a2); 
                order.add(a3);
                }
                System.out.println("test.Test.main()"+ order.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return order.toString();
    
    }
}
