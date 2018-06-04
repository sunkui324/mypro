package com.wolab.functionInterface;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForPeople {

    /**
     * 判断男性
     * @return
     */
    public static Predicate<People> isMale(){
        return p ->"man".equalsIgnoreCase(p.getSex());
    }

    /**
     *  年龄大于age
     * @param age
     * @return
     */
    public static Predicate<People> ageMoreThan(int age){
        return people -> people.getAge()>age;
    }

    /**
     * 女性,且年龄小于 age
     * @param age
     * @return
     */
    public static Predicate<People> isFemalAndAgeLessThan(int age){
        return people -> "woman".equalsIgnoreCase(people.getSex()) && people.getAge()<age;
    }

    /**
     * 根据predicate 过滤选择子list
     * @param peopleList
     * @param predicate
     * @return
     */
    public static List<People> filterPeople(List<People> peopleList,Predicate<People> predicate ){
        return peopleList.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        People xiaoMing = new People("小明",25,"man");
        People xiaoHong = new People("小红",38,"woman");
        People xiaoFang = new People("小芳",19,"woman");
        People xiaoLiu = new People("小刘",29,"man");
        People xiaoHei = new People("小黑",56,"man");
        List<People> peopleList = Arrays.asList(new People[]{xiaoMing,xiaoHong,xiaoFang,xiaoLiu,xiaoHei});

        System.out.println(PredicateForPeople.filterPeople(peopleList,PredicateForPeople.isMale()));
        System.out.println(PredicateForPeople.filterPeople(peopleList,PredicateForPeople.ageMoreThan(20)));
        System.out.println(PredicateForPeople.filterPeople(peopleList,PredicateForPeople.isFemalAndAgeLessThan(20)));

        System.out.println("test ssh accesss to github");
    }

}
