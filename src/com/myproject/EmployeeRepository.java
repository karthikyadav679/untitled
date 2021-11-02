package com.myproject;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {
   private List<Employee>employeeList=null;
    private Object List;

    public List<Employee> getAll(){
        employeeList=new ArrayList<>();
        Department department1=new Department(1,"Cloud and Digital",1010);
     Department department2=new Department(2,"SAP-S4-HANA",2101);
     Department department3=new Department(Integer.MAX_VALUE,"null",Integer.MAX_VALUE);
        Employee e1=new Employee(1,"Karthik","N","karthikyadav679.ky@gmail.com","9741025495",LocalDate.of(2021,10,11),"Associate",35500,1010,department1);
      Employee e2=new Employee(2,"vikram","Gaikwad","vikram@gmail.com","9741235495",LocalDate.of(2021,10,11),"Associate",35500,1010,department1);
      Employee e3=new Employee(3,"Phani","Raja","raja.phani@gmail.com","9841024495",LocalDate.of(2021,10,11),"Associate",35500,1010,department1);
      Employee e4=new Employee(4,"Tanmayi","Jain","tanmayi@gmail.com","923402545",LocalDate.of(2021,10,11),"Associate",35500,1010,department1);
      Employee e5=new Employee(1010,"Pramod","Bellur","pramod@gmail.com","946350255",LocalDate.of(2015,10,11),"Manager",100000,130,department1);
      Employee e6=new Employee(1011,"Vedant","ashis","vedant@gmail.com","946350255",LocalDate.of(2015,10,11),"Manager",100000,130,department2);
     Employee e7=new Employee(22,"pooja","gamma","pooja@gmail.com","94430255",LocalDate.of(2021,10,11),"Associate",35500,2101,department2);
     Employee e8=new Employee(23,"Sai","Kiran","kiran@gmail.com","946350255",LocalDate.of(2021,10,11),"Associate",35500,2101,department2);
      Employee e9=new Employee(25,"Naman","Mishra","naman@gmail.com","5389545839505",LocalDate.of(2021,10,11),"Associate",55434,Integer.MAX_VALUE,department3);

      Employee e10=new Employee(26,"Priyanaka","W","priyanka@gmail.com","538954583",LocalDate.of(2021,10,11),"Associate",23434,Integer.MAX_VALUE,department3);

        employeeList.add(e1);
      employeeList.add(e2);
      employeeList.add(e3);
      employeeList.add(e4);
      employeeList.add(e5);
     employeeList.add(e6);
     employeeList.add(e7);
     employeeList.add(e8);
     employeeList.add(e9);
     employeeList.add(e10);
      return employeeList;
    }


   public Optional<Employee> findEmployeeByFirstName(String Name){
      Optional<Employee> list= Optional.ofNullable(employeeList.stream()
                               .filter(employee1 -> employee1.getFirstName().equals(Name))
                               .findFirst()
                               .orElse(null));

     return list;
   }

   public double findSalarySum(){
        double total=employeeList.stream().
                map(Employee::getSalary).
                reduce((sal,sum)->sum+sal).get();

        return total;
   }

   public Optional<Employee> findEmployeeWithHighestSalary(){
       Optional<Employee>employee=employeeList.stream()
               .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
       return employee;
   }

   public Optional<Employee> findSeniorMostEmployee(){
        Optional<Employee> e=employeeList.stream().sorted(Comparator.comparing(Employee::getHiredate)).findFirst();
        return e;
   }

   public List<Employee> sortByEmployeeId(){
       List<Employee>employee= employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeId)).toList();
       return employee;
   }

    public List<Employee> sortByNameEmployee(){
        List<Employee>employee= employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)).toList();
        return employee;
    }

    public void NoofEmployeesInDepartment(){

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((k,v)-> System.out.println(k.getDepartmentName()+" : employees count is:"+v.size() ));

    }
    public void EmployeeWithoutDepartment(){

        System.out.println("Employees Without Department are :");
        employeeList.stream().collect(Collectors.toMap(Employee::getFirstName,Employee::getDepartment )).forEach((k, v)-> {
            if (v.getDepartmentName().equalsIgnoreCase("null")) {
                System.out.println(k);
            }
        });
    }
    public void SalaryIncrement(){
        employeeList.stream().forEach(Employee -> System.out.println(Employee.getFirstName()+" "+Employee.getLastName()+" your salary increased to "+(Math.round(Employee.getSalary()*1.15f))));
    }


    public void NoofEmployeesHighestDepartment(){

        final Department key = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Department with Highest no of Employees :" +key.getDepartmentName());
    }
    public void sortByDepartment(){
       employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((k,v)-> System.out.println(k.getDepartmentName()+" : employees list is:"+v ));

    }
}
