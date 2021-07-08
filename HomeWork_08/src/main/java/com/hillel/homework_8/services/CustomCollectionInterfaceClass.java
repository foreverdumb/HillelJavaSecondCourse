package com.hillel.homework_8.services;

import com.hillel.homework_8.models.NodeClass;

public interface CustomCollectionInterfaceClass {
    boolean push(String new_data);

    boolean insertAfter(NodeClass previous_node, String new_data); //non homework method

    boolean append(String new_data); //non homework method

    boolean addAll(CustomCollectionImplClass strColl);

    boolean addAll(String[] strArr);

    boolean deleteElement(String element);

    boolean deleteElement(int index);

    boolean delete(NodeClass current);

    boolean contains(String value);

    boolean clear();

    boolean trim();

    boolean compare(CustomCollectionImplClass collStr);

    void printList(NodeClass node);

    int size();

    String get(int index);
}
