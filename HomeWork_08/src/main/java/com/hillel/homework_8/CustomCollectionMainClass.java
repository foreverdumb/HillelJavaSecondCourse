package com.hillel.homework_8;

import com.hillel.homework_8.services.CustomCollectionImplClass;

public class CustomCollectionMainClass {
    public static void main(String[] args) {
        CustomCollectionImplClass list_1 = new CustomCollectionImplClass();
        CustomCollectionImplClass list_2 = new CustomCollectionImplClass();
        CustomCollectionImplClass list_3 = new CustomCollectionImplClass();
        CustomCollectionImplClass list_4 = new CustomCollectionImplClass();
        CustomCollectionImplClass list_5 = new CustomCollectionImplClass();
        CustomCollectionImplClass list_6 = new CustomCollectionImplClass();
        String[] strColl = new String[3];

        list_1.push("Andrew1");
        list_1.push("Andrew2");
        list_1.push("Andrew3");
        list_1.push("Andrew4");
        list_1.push("Andrew5");

        list_2.push("Andrew1");
        list_2.push("Andrew2");
        list_2.push("Andrew3");
        list_2.push("Andrew4");
        list_2.push("Andrew5");

        list_3.push("Andrew1");
        list_3.push("Andrew2");
        list_3.push("Andrew3");
        list_3.push("Andrew4");
        list_3.push("Andrew5");

        list_4.push("Andrew1");
        list_4.push("Andrew2");
        list_4.push(null);
        list_4.push("Andrew4");
        list_4.push("Andrew5/");

        list_5.push("Andrew1_5");
        list_5.push("Andrew2_5");
        list_5.push("Andrew3_5");
        list_5.push("Andrew4_5");
        list_5.push("Andrew5_5");

        list_6.push("Olha1_5");
        list_6.push("Olha2_5");
        list_6.push("Olha3_5");
        list_6.push("Olha4_5");
        list_6.push("Olha5_5");

        strColl[0] = "Valera1";
        strColl[1] = "Valera2";
        strColl[2] = "Valera3";

        System.out.println("\n--------------------------");
        System.out.println(list_1.get(1));

        list_1.printList(list_1.head);
        System.out.println("\n--------------------------");

        System.out.println(list_1.size());
        System.out.println("\n--------------------------");

        list_1.deleteElement("Andrew4");
        list_1.printList(list_1.head);

        System.out.println("\n--------------------------");
        list_1.printList(list_1.head);

        System.out.println("\n--------------------------");
        list_1.deleteElement(2);
        list_1.printList(list_1.head);

        System.out.println("\n--------------------------");
        System.out.println(list_2.compare(list_3));

        System.out.println("\n--------------------------");
        System.out.println(list_1.compare(list_3));

        System.out.println("\n--------------------------");
        System.out.println(list_4.trim());

        System.out.println("\n--------------------------");
        list_4.printList(list_4.head);

        System.out.println("\n--------------------------");
        System.out.println(list_3.contains("Andrew4"));

        System.out.println("\n--------------------------");
        list_5.printList(list_5.head);

        System.out.println("\n--------------------------");
        list_5.clear();
        list_5.printList(list_5.head);

        System.out.println("\n--------------------------");
        list_3.addAll(strColl);
        list_3.printList(list_3.head);

        System.out.println("\n--------------------------");
        list_2.addAll(list_6);
        list_2.printList(list_2.head);
    }
}
