package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        //1- *************FOREACH******************

        // employees.forEach((Employee e)-> {
        //     System.out.println(e.getName() + " : "+ e.getSalary());
        // });






        //2- ******************filter****************

        //printing

        // employees.stream().filter((Employee e)->e.getDept().equals("Development")).forEach((Employee e)->{
        //     System.out.println(e.getName());
        // });

        // storing in a list

        List<Employee> list = employees.stream().filter((Employee e)->e.getDept().equals("Development") && e.getSalary()>90000.0).collect(Collectors.toList());
        // System.out.println(list);

        // You can also store it in set

        Set<Employee> set = employees.stream().filter((Employee e)->e.getDept().equals("Development") && e.getSalary()>90000.0).collect(Collectors.toSet());
        // System.out.println(set);

        // I want id and name in a map

        Map<Integer,String> map = employees.stream().filter((Employee e)->e.getDept().equals("Development") && e.getSalary()>70000.0).collect(Collectors.toMap(
                e->e.getId(),
                e->e.getName()
        ));
        // System.out.println(map);

        // 3- *****************map************************

        // Use case I want to collect all the deprtment (to extract a single attribute from objects)

        List<String> depaList = employees.stream().map((Employee e)->e.getDept()).distinct().collect(Collectors.toList());
        // System.out.println(depaList);

        // Now If we want to extract projects. Project is nested in Employee.
        // If there is one-many relation(Employee tagged to many projects) then you cannot use map.

        List<Stream<String>> pList = employees.stream().map((Employee e)->e.getProjects().stream().map((Project p)->p.getName())).collect(Collectors.toList());
        // System.out.println(pList);


        // 4- ***************** FlatMap ******************

        List<String> projectsList=employees.stream().flatMap((Employee e)-> e.getProjects().stream().map((Project p)->p.getName())).distinct().collect(Collectors.toList());
//        System.out.println(projectsList);

        // 5- ************** Sorted ************************


        // inside Comparator.comparing(the field by which you want it sorted)

        List<Employee> ascsortedEmployees =employees.stream().sorted(Comparator.comparing((Employee e)->e.getSalary())).collect(Collectors.toList());
//        System.out.println(ascsortedEmployees);

        //ascsortedEmployees.forEach((Employee e)->{
         //   System.out.println(e.getName() +" : "+ e.getDept() + " : " +e.getSalary());
        //});

        // desc

        List<Employee> descSortedOrder = employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing((Employee e)->e.getSalary()))).collect(Collectors.toList());

//        System.out.println(descSortedOrder);

//        descSortedOrder.stream().forEach((Employee e)->{
//            System.out.println(e.getName() +" : "+ e.getDept() +" : "+ e.getSalary());
//        });

        // 5- *********** MIN and MAX *********************

       Optional<Employee> maxPaidSalary= employees.stream().max(Comparator.comparingDouble((Employee e)->e.getSalary()));
       Optional<Employee> minPaidSalary= employees.stream().min(Comparator.comparingDouble((Employee e)->e.getSalary()));
//        System.out.println(minPaidSalary.get().getName() + " : "+ minPaidSalary.get().getSalary());
//        System.out.println(maxPaidSalary.get().getName() + " : "+ maxPaidSalary.get().getSalary());



        // ************ Gouping by ******************
        // Some complex queries.

        // You have to find out how many employees are male and how many are female. (group by like in SQL)

        Map<String,List<Employee>> groupedResult =employees.stream().collect(Collectors.groupingBy((Employee e)->e.getGender()));
        // This is giving a list og objects. Its difficult to read
        //        System.out.println(groupedResult);


        // collect has two parameters -> by what we want to groip and format
        // in nested Collectiors.mapping has two parameter -> Kya value chaiye and List/Set kis DS me chaiye
        // output - Gender - []
        Map<String,List<String>> groupedEmployees= employees.stream().collect(Collectors.groupingBy((Employee e)->e.getGender(),
                Collectors.mapping((Employee e)-> e.getName(),Collectors.toList())
                ));
//        System.out.println(groupedEmployees);

        // Now I want gender -> count
        Map<String,Long> countGrouped=employees.stream().collect(Collectors.groupingBy((Employee::getGender),Collectors.counting()));
//        System.out.println(countGrouped);

        // 6 *********** findFirst ********************
        // Finds the first element of the stream. Generally used with filter

        Optional<Employee> res=employees.stream().filter((Employee e)->e.getDept().equals("Development")).findFirst();
//        System.out.println(res.get());

        // If we use get method from optional it might give us Null pointer exception when there is no element present
        // Better way

//        if(res.isPresent()){
//            System.out.println(res.get());
//        }

//        res.ifPresent((Employee e)-> System.out.println(e.getName()));

        // Now if you don't want to check explictily then
        Employee ans =employees.stream().filter((Employee e)->e.getDept().equals("Development")).findFirst().orElse(new Employee());

        // other way
        Employee r= employees.stream().filter((Employee e)->e.getDept().equals("Development")).findFirst().orElseThrow(()->new IllegalArgumentException("Employee not foind"));
//        System.out.println(r);





        // 7- *************find any ********************************
        // Not much diff between find first and find any
        // Only diff is to say "If you find any object of certain type them continue my flow"

        Employee findAnyEx = employees.stream().
                filter((Employee e)->e.getDept().equals("Development")).
                findAny().
                orElseThrow(()->new IllegalArgumentException("Employee not foind"));


        // 8 ************** any match, all match, none match *********************
        /* They all take input as a Predicate similar like filter.
            Any match - If there is anything that matches then continue
               None match - If none matched then continue
               allMAtch = IF all match then continue the flow of stream

               All returns boolean
         */

        // I want to find if there is any Employee object of Boolean type
        Boolean ifAny =  employees.stream().anyMatch((Employee e)->e.getDept().equals("Development"));
//        System.out.println(ifAny);
        Boolean ifAll =  employees.stream().allMatch((Employee e)->e.getDept().equals("Development"));
//        System.out.println(ifAll);
        Boolean ifNone =  employees.stream().noneMatch((Employee e)->e.getDept().equals("Developmet"));
//        System.out.println(ifNone);

        // If salary of all employees is > 50000 then proceed
        Boolean ifAllGreater = employees.stream().allMatch((Employee e)->e.getSalary()>50000);
//        System.out.println(ifAllGreater);

        // 9 ********** LIMIT ***************


        // If you are getting List of 10 size as results but you want only 3.
        // Example find top 3 employees with salary (decs)

        List<Employee> sortedEmpDesc= employees.stream()
                .sorted(Collections
                        .reverseOrder(Comparator.comparing((Employee e)->e.getSalary())))
                .limit(5)
                .collect(Collectors.toList());

//        sortedEmpDesc.forEach((Employee e)->{
//            System.out.println(e.getName() + " : "+ e.getSalary());
//        });


        // 10 ********** Skip **************

        // takes long
        // skips first n elements and get the list of reat all

       List<Employee> sortedEmpSkip=employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing((Employee e)->e.getSalary())))
                .skip(2)
                .collect(Collectors.toList());

      sortedEmpSkip.forEach((Employee e)->{
          System.out.println(e.getName() +" : "+ e.getSalary());
      });
    }
    
}
