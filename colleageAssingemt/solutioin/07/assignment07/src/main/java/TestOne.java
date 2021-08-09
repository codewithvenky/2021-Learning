

import java.util.Arrays;
import java.util.List;

class Employee
{
    private int id;
    private   String name ;
    private  String department;
    private int salary ;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class TestOne {
    public static void main(String[] args)
    {

        List<Employee> list = Arrays.asList(new Employee(1,"Swapnil","It",1000),
                new Employee(2,"Rahul","HR",6000),
                new Employee(3,"APARNA","HR",5000),
                new Employee(4,"VIVEK","IT",7000),
                new Employee(5,"JOE","It",9000),
                new Employee(6,"SARITA","It",7000)
          );
      
        list.forEach(e -> System.out.println(e));



    }
}
