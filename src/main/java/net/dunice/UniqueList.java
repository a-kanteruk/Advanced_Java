package net.dunice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueList {
    HashSet mySet = new HashSet();
    public static void main(String[] args) {
        List<String> someList = new ArrayList<>();
        UniqueList unique = new UniqueList();

        someList.add("Artem");
        someList.add("Artur");
        someList.add("Artem");
        System.out.println(someList);

        someList = unique.uniqueElements(someList);
        System.out.println(someList);

    }
    public List uniqueElements(List someCollections){

        for (Object item: someCollections){mySet.add(item);}
        someCollections.clear();
        for (Object item: mySet){someCollections.add(item);}
        mySet.clear();

        return someCollections;
    }
}
