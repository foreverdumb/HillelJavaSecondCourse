package com.hillel.homework_8.services;

import com.hillel.homework_8.models.NodeClass;

public class CustomCollectionImplClass implements CustomCollectionInterfaceClass {
    public NodeClass head;
    public NodeClass tail;
    private int counter;

    @Override
    public boolean push(String new_data) {
        NodeClass new_Node = new NodeClass(new_data);
        new_Node.next = head;
        new_Node.previous = null;
        if (head != null) {
            head.previous = new_Node;
        }
        head = new_Node;
        return true;
    }

    @Override
    public boolean insertAfter(NodeClass previous_node, String new_data) {
        if (previous_node == null) {
            System.out.println("The given previous node can not be null! ");
            return false;
        }
        NodeClass new_Node = new NodeClass(new_data);
        new_Node.next = previous_node.next;
        previous_node.next = new_Node;
        new_Node.previous = previous_node;
        if (new_Node.next != null) {
            new_Node.next.previous = new_Node;
        }
        return true;
    }

    @Override
    public boolean append(String new_data) {
        NodeClass new_Node = new NodeClass(new_data);
        NodeClass last = head;
        new_Node.next = null;
        if (head == null) {
            new_Node.previous = null;
            head = new_Node;
        }
        while (true) {
            assert last != null;
            if (last.next == null) break;
            last = last.next;
            last.next = new_Node;
            new_Node.previous = last;
        }
        return true;
    }

    @Override
    public boolean addAll(CustomCollectionImplClass strColl) {
        if (strColl.size() != 0) {
            for (int i = 0; i < strColl.size(); i++) {
                push(strColl.get(i));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(String[] strArr) {
        if (strArr.length != 0) {
            for (String s : strArr) {
                push(s);
            }
            return true;
        }
        return false;
    }

    @Override
    public void printList(NodeClass node) {
        NodeClass last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.previous;
        }
    }

    @Override
    public boolean deleteElement(String element) {
        NodeClass current = head;
        for (int i = 0; i < size(); i++) {
            current = current.next;
            if (current.data.equals(element)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
        }
        return true;
    }

    @Override
    public boolean deleteElement(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds. Can't remove a node. No node exists " +
                    "at the specified index");
        if (size() == 0) {
            throw new NullPointerException("Empty list");
        }
        if (size() > 0) {
            NodeClass current;
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return delete(current);
        }
        return true;
    }

    @Override
    public boolean delete(NodeClass current) {
        if (current == head) {
            head = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }
        if (current == tail) {
            tail = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }
        counter--;
        return true;
    }

    @Override
    public int size() {
        NodeClass node = head;
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }

    @Override
    public String get(int index) {
        if (index > counter && index < 0) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        } else {
            NodeClass current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    @Override
    public boolean contains(String value) {
        if (size() != 0) {
            NodeClass current = head;
            for (int i = 0; i < size(); i++) {
                if (current.getData().equals(value)) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (size() != 0) {
            for (NodeClass node = head; node != null; ) {
                NodeClass next = node.getNext();
                node.setNext(null);
                node.setPrevious(null);
                node = next;
            }
            head = tail = null;
            counter = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean trim() {
        if (size() != 0) {
            int count = 0;
            NodeClass current = head;
            while (current != null) {
                if (current.getData() == null) {
                    NodeClass next = current.getNext();
                    delete(current);
                    count++;
                    current = next;
                    continue;
                }
                current = current.getNext();
            }
            return count > 0;
        }
        return false;
    }

    @Override
    public boolean compare(CustomCollectionImplClass collStr) {
        if (this.size() != collStr.size() || this.size() == 0 || collStr.size() == 0) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(collStr.get(i))) {
                return false;
            }
        }
        return true;
    }
}
