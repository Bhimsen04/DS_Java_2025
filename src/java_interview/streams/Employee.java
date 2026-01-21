package java_interview.streams;

class Employee{
    private String name;
    private int salary;
    private int id;

    public Employee(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getId(){
        return this.id;
    }
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", id=" + id + "]";
    }
}