package com.hillel.homework_5;

import com.hillel.homework_5.models.PhoneClass;
import com.hillel.homework_5.phone_utils.PhoneGeneratorClass;
import com.hillel.homework_5.services.PhoneService;
import com.hillel.homework_5.services.PhoneServiceImplClass;

import java.util.Arrays;
import java.util.Comparator;

public class CreatingSubscriberMainClass {
    public static void main(String[] args) {
        PhoneClass[] objectsArr = PhoneGeneratorClass.generateArray();
        PhoneService phoneService = new PhoneServiceImplClass();
        phoneService.printAllObj(objectsArr);
        phoneService.printSubscribersIncreasedCityCalls(objectsArr, 150);
        phoneService.printSubscribersUsedLongDistanceCalls(objectsArr);
        Comparator<PhoneClass> internetTrafficComparator = new internetTrafficComparator();
        Arrays.sort(objectsArr, internetTrafficComparator);
        System.out.println("Subscribers with highest internet traffic consumption: "
                + "\n" + Arrays.deepToString(objectsArr).replace("},", "},\n"));
        Comparator<PhoneClass> alphabetSortingComparator = new alphabetSortingComparator();
        Arrays.sort(objectsArr, alphabetSortingComparator);
        System.out.println("Subscribers sorted by first name: "
                + "\n" + Arrays.deepToString(objectsArr).replace("},", "},\n"));

    }

}

class internetTrafficComparator implements Comparator<PhoneClass> {

    @Override
    public int compare(PhoneClass o1, PhoneClass o2) {
        return o2.getInternetTraffic() - o1.getInternetTraffic();
    }
}

class alphabetSortingComparator implements Comparator<PhoneClass> {

    @Override
    public int compare(PhoneClass o1, PhoneClass o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
