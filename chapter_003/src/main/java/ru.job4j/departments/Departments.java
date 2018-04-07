package ru.job4j.departments;

import java.util.*;

public class Departments {

    private List<Department> departmentList = new ArrayList<>();

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void add(Department department) {
            String[] depParts = department.separate();
            String poisk = "";
            for (int ind = 0; ind < depParts.length; ind++) {
                if (ind == 0) {
                    poisk = poisk.concat(depParts[0]);
                } else {
                    poisk = poisk.concat("\\").concat(depParts[ind]);
                }
              Department newOne = new Department(poisk);
              departmentList.add(newOne);
            }
            departmentList = new ArrayList<Department>(new HashSet<Department>(departmentList));
    }

    public  static Set<Department> sort(Set<Department> list) {
        TreeSet<Department> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }


    public void sortAscending() {
        Comparator<Department> compar = new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        this.departmentList.sort(compar);
    }

    public void sortDecreasingly() {
        Comparator<Department> compar = new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                    int len1 = o1.getKey().length();
                    int len2 = o2.getKey().length();
                    int lim = Math.min(len1, len2);
                    char[]  v1 = o1.getKey().toCharArray();
                    char[] v2 = o2.getKey().toCharArray();

                    int k = 0;
                    while (k < lim) {
                        char c1 = v1[k];
                        char c2 = v2[k];
                        if (c1 != c2) {
                            return c2 - c1;
                        }
                        k++;
                    }
                    return len1 - len2;
                }
        };
        this.departmentList.sort(compar);
    }

    public static void main(String[] args) {
        Departments  departmentList = new Departments();
        Department d1 = new Department("K1\\SK1");
        Department d2 = new Department("K1\\SK2");
        Department d3 = new Department("K1\\SK1\\SSK1");
        Department d4 = new Department("K1\\SK1\\SSK2");
        Department d5 = new Department("K2");
        Department d6 = new Department("K2\\SK1\\SSK1");
        Department d7 = new Department("K2\\SK1\\SSK2");
        departmentList.add(d1);
        departmentList.add(d2);
        departmentList.add(d3);
        departmentList.add(d4);
        departmentList.add(d5);
        departmentList.add(d6);
        departmentList.add(d7);
        departmentList.sortAscending();
        departmentList.sortDecreasingly();
    }


}
