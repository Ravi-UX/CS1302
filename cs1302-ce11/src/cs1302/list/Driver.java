package cs1302.list;

import cs1302.listadt.StringList;

public class Driver {

    public static void printNode(StringList.Node node, int numLinks) {
        for(int i = 0; i < numLinks; i++) {
            node = node.getNext();
        }
        System.out.println(node.getStr());
    }

    public static void main(String[] args) {

        // CODE BLOCK 1
        StringList.Node a = new StringList.Node();
        a.setStr("Billy");

        // CODE BLOCK 2
        new StringList.Node("Linda", a);

        // CODE BLOCK 3
        StringList.Node b = new StringList.Node("Juno");
        b.setNext(a);
        a.setNext(new StringList.Node("Sally"));
        b.getNext().getNext().setNext(new StringList.Node("Barry"));

        // CODE BLOCK 4
        StringList.Node c = b.getNext().getNext();
        c.getNext().setNext(new StringList.Node("Simon"));

        // CODE BLOCK 5
        System.out.println(c.getNext().getNext().getNext());
        System.out.println(b.getStr());
        System.out.println(a.getNext().getNext().getStr());
        System.out.println(c.getNext().getNext().getStr());

        // CODE BLOCK 6
         a.setNext(new StringList.Node("Simone"));

        // CODE BLOCK 7
        System.out.println(a.getNext().getNext());

        printNode(a, 1);
        printNode(b, 2);
        printNode(c, 0);
        printNode(a.getNext(), 0);
        printNode(c.getNext(), 3);
    } // main

} // Driver
