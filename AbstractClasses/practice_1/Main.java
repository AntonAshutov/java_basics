public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 180; i++){
            company.hire(new Operator((Math.random()*50_000) + 50_000));
        }

        for (int i = 0; i < 80; i++){
            company.hire(new Manager((Math.random()*70_000) + 60_000));
        }

        for (int i = 0; i < 10; i++){
            company.hire(new TopManager(((Math.random()*70_000) + 80_000), (company.getIncome() > 10_000_000)));
        }

        System.out.println("Stuff with highest salary:");
        for (Employee employee : company.getMaxSalaryStaff(500)){
            System.out.println(employee);
        }
        System.out.println("________________________________");

        System.out.println("Stuff with lowest salary:");
        for (Employee employee : company.getMinSalaryStaff(30)){
            System.out.println(employee);
        }
        System.out.println("________________________________");

        for (int i = 0; i < 50; i++){
            int index = (int) (Math.random()*company.getStaff().size());
            company.fire(company.getStaff().get(index));
        }

        System.out.println("Stuff with highest salary:");
        for (Employee employee : company.getMaxSalaryStaff(10)){
            System.out.println(employee);
        }
        System.out.println("________________________________");

        System.out.println("Stuff with lowest salary:");
        for (Employee employee : company.getMinSalaryStaff(30)){
            System.out.println(employee);
        }

    }
}
