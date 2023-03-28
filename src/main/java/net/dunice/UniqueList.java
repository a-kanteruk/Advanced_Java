package net.dunice;

import java.util.*;

public class UniqueList {
    public static void main(String[] args) {
        Collection myCollection = new ArrayList<>();
        UniqueList unique = new UniqueList();

        myCollection.add("Artem");
        myCollection.add("Artur");
        myCollection.add("Artem");
        System.out.println(myCollection);

        myCollection =unique.selection(myCollection);
        System.out.println(myCollection);

    }
    public Collection selection(Collection someCollections){
        HashSet mySet = new HashSet();
        for (Object item: someCollections) mySet.add(item);
        someCollections.clear();
        for (Object item: mySet) someCollections.add(item);

        return someCollections;
    }
}
