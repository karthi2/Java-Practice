import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCodeEasy_EmployeeImportance {
	static class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee();

		e1.id = 1;
		e1.importance = 5;
		List<Integer> e1Sub = new ArrayList<>();
		e1Sub.add(2);
		e1Sub.add(3);
		e1.subordinates = e1Sub;

		Employee e2 = new Employee();
		e2.id = 2;
		e2.importance = 3;

		Employee e3 = new Employee();
		e3.id = 3;
		e3.importance = 10;

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);

		LeetCodeEasy_EmployeeImportance empImp = new LeetCodeEasy_EmployeeImportance();

		System.out.println(empImp.getImportance(employees, 1));
	}

	private int getImportance(List<Employee> employees, int id) {
		Iterator<Employee> iter = employees.iterator();
		int importance = 0;

		while (iter.hasNext()) {
			Employee emp = iter.next();
			
			if (emp.id == id) {
				importance += emp.importance;

				if (emp.subordinates != null) {
					Iterator<Integer> iterSub = emp.subordinates.iterator();

					while (iterSub.hasNext()) {
						importance += getImportance(employees, iterSub.next());
					}
				}
				
				break;
			}
		}

		return importance;
	}

}
