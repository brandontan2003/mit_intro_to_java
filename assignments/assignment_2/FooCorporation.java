package assignments.assignment_2;

public class FooCorporation {
    static double minimumPay = 8;
    static int maximumHoursWorked = 60;

    public static void main(String[] args) {
        calculateSalary("Employee 1", 7.50, 35);
        calculateSalary("Employee 2", 8.20, 47);
        calculateSalary("Employee 3", 10.00, 73);
    }

    public static void calculateSalary(String employeeName, Double basePay, Integer hoursWorked) {
        if (!validateInput(employeeName, basePay, hoursWorked)) {
            return;
        }
        double totalSalary;
        if (hoursWorked <= 40) {
            totalSalary = basePay * hoursWorked;
        } else {
            double baseSalary = basePay * 40;
            totalSalary = baseSalary + (basePay * 1.5 * (hoursWorked - 40));
        }
        System.out.println(employeeName + " earns: $" + totalSalary);
    }

    public static Boolean validateInput(String employeeName, Double basePay, Integer hoursWorked) {
        if (basePay < minimumPay) {
            System.err.printf("Error: %s earns $%.2f, which is below the legal minimum pay of $%.2f%n", employeeName, basePay, minimumPay);
            return Boolean.FALSE;
        }
        if (hoursWorked > maximumHoursWorked) {
            System.err.printf("Error: %s works %d hours, which is above the legal working hours of %d hours%n", employeeName, hoursWorked, maximumHoursWorked);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

