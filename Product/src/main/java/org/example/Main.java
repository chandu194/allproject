package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class product{
    String category;
    long price;
    String name;
    LocalDate date;

    public product(String category, long price, String name, LocalDate date) {
        this.category = category;
        this.price = price;
        this.name = name;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "product{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        List<product> products = Arrays.asList(
                new product("ceramic",12345L, "mug",LocalDate.of(2026,04,26)),
                new product("ceramic",1234L, "jar",LocalDate.of(2026,04,24)),
                new product("ceramic",1890L, "cup",LocalDate.of(2026,03,23)),
                new product("ceramic",12312L, "mug",LocalDate.of(2026,03,05)),
                new product("steel",123L, "cup",LocalDate.of(2026,04,05)),
                new product("steel",12305L, "plate",LocalDate.of(2026,04,03)),
                new product("steel",123415L, "kadai",LocalDate.of(2026,03,01)),
                new product("steel",1234111L, "cup",LocalDate.of(2026,03,26))
        );

        //find the latest 3 record in each category by sorting order of prod name
        Map<String,List<product>> latestThreeRecord = products.stream()
                .collect(Collectors.groupingBy(product::getCategory,
                        Collectors.collectingAndThen(Collectors.toList(),list->list
                                .stream()
                                .sorted(Comparator.comparing(product::getDate).reversed().thenComparing(product::getName))
                                .limit(3)
                                .collect(Collectors.toList())
                        )
                        ));
        System.out.println(latestThreeRecord);



        //find the second highest price in each category
        Map<String,List<product>> secondHighPrice= products.stream()
                .collect(Collectors.groupingBy(product::getCategory,
        Collectors.collectingAndThen(Collectors.toList(), list->{
            long secondHighest = list.stream()
                    .map(product::getPrice)
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .skip(1)
                    .findFirst()
                    .get();

            return list.stream()
                    .filter(x-> Objects.equals(secondHighest,x.getPrice()))
                    .collect(Collectors.toList());
                }
        )));
        System.out.println(secondHighPrice);

        //print the list of same prod in each category

        Map<String, Map<String,List<product>>>  sameProducts=products.stream()
                .collect(Collectors.groupingBy(product::getCategory,
                        Collectors.collectingAndThen(Collectors.groupingBy(product::getName), map->map
                                .entrySet()
                                .stream()
                                .filter(x->x.getValue().size()>1)
                                .collect(Collectors.toMap(Map.Entry::getKey,
                                        Map.Entry::getValue))


                        )
                        ));
        System.out.println(sameProducts);

        //in each category give the sum of amount of each month
        Map<String,Map<Month,Long>> sum=products.stream()
                .collect(Collectors.groupingBy(product::getCategory,
                        Collectors.groupingBy(date ->date.getDate().getMonth(),
                                Collectors.summingLong(product::getPrice)
                                )

                        ));
        System.out.println(sum);


//find the latest 3 record in each category by sorting order of prod name

        //find the second highest price in each category
        //print the list of same prod in each category
        //in each category give the sum of amount of each month


    }
}
