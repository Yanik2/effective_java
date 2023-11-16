package org.example.employee;

import java.util.List;

public class EmployeeMain {
  public static void main(String[] args) {
    List<Manager> mngrs = List.of(new Manager(), new Manager());

    //Compiler error
    //Because return type is smth what implements Comparable
    //and Manager implements Comparable through Employee, but Comparable parameterized
    // with Employee which is not Comparable<T> but Comparable<? super T>
    //and Comparable<Employee> is not a super type of Comparable<Manager>
    Employee mngr = max(mngrs);
    Employee mngr2 = maxWildcard(mngrs);
  }

  public static <T extends Comparable<T>> T max(List<T> list) {
    return list.get(0);
  }

  //No errors with this method, because of wildcards
  public static <T extends Comparable<? super T>> T maxWildcard(List<? extends T> list) {
    return list.get(0);
  }
}
