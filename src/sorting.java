import com.myproject.EmployeeRepository;


public class sorting{
    public static void main(String[] args) {

        EmployeeRepository employeeRepository=new EmployeeRepository();

        employeeRepository.getAll().forEach(System.out::println);
        System.out.println("finding employee by Name: Karthik as first name");
        System.out.println(employeeRepository.findEmployeeByFirstName("Karthik"));
        System.out.println("Total Salary of the employees is:"+employeeRepository.findSalarySum());
        System.out.println("Highest Salary of the employees is:"+employeeRepository.findEmployeeWithHighestSalary());
        System.out.println("Sorting By Employeeid then Name:");
        employeeRepository.sortByEmployeeId().forEach(System.out::println);
        System.out.println();
        System.out.println(employeeRepository.findSeniorMostEmployee());

        System.out.println();
        employeeRepository.sortByDepartment();
        employeeRepository.NoofEmployeesInDepartment();

        employeeRepository.sortByNameEmployee().forEach(System.out::println);

        employeeRepository.NoofEmployeesHighestDepartment();

        employeeRepository.EmployeeWithoutDepartment();
        employeeRepository.SalaryIncrement();
    }


}
