import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class Company {
    private ArrayList<Employee> staff = new ArrayList<>();
    double companyIncome = (Math.random() * 10_000_000) + 5_000_000;
    public void hire(Employee employee){
        staff.add(employee);
    }

    public void fire (Employee employee){
        staff.remove(employee);
    }

    public void hireAll (Collection <Employee> employees){
        staff.addAll(employees);
    }

    public double getIncome(){
        return companyIncome;
    }

    public ArrayList<Employee> getMaxSalaryStaff(int count){
        if (count < 0 || count > staff.size()){
            System.out.println("Error");
            return new ArrayList<>();
        }
        TreeSet<Employee> employees = new TreeSet<>((o1, o2) -> Double.compare(o2.getMonthSalary(), o1.getMonthSalary()));
        employees.addAll(staff);
        ArrayList<Employee> maxSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++){
            maxSalaryStaff.add(employees.first());
            employees.remove(employees.first());
        }
        return maxSalaryStaff;
    }

    public ArrayList<Employee> getMinSalaryStaff(int count){
        if (count < 0 || count > staff.size()){
            System.out.println("Error");
            return new ArrayList<>();
        }
        TreeSet<Employee> employees = new TreeSet<>(Comparator.comparingDouble(Employee::getMonthSalary));
        employees.addAll(staff);
        ArrayList<Employee> minSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++){
            minSalaryStaff.add(employees.first());
            employees.remove(employees.first());
        }
        return minSalaryStaff;
    }

    public ArrayList<Employee> getStaff(){
        return staff;
    }
}