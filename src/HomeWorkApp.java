public class HomeWorkApp {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Tourist", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Zoraida The Witch", "Main Witch", "magic@voodoo.com", "892312313", 100000, 200);
        employees[2] = new Employee("VonSchill The Mercenary", "General", "runandgun@malifaux.com", "892312314", 250000, 45);
        employees[3] = new Employee("Sonya Criid", "Inquisitor", "purification@malifaux.com", "892312315", 25000, 32);
        employees[4] = new Employee("Sheimus", "Mad Hatter", "hathathat@malifaux.com", "892312317", 10000, 20);
        for(Employee employee : employees) {
            if (employee.getAge() > 40 ) {
                employee.printInfo();
            }
        }
    }
}
