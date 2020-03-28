package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    private static String ELEMENT1 = "ELEMENT1";
    private static String ELEMENT2 = "ELEMENT2";
    private static String ELEMENT3 = "ELEMENT3";

    private SinglyLinkedList<String>list;
    @Before
    public void setup() {
        list = new SinglyLinkedList<String>();
        Assert.assertTrue(list.getSizeOfList() == 0);
    }

    @Test
    public void addElementTest(){
        list.addElement(ELEMENT1);
        Assert.assertTrue(list.getSizeOfList()==1);
        String element = list.getElementByIndex(0);
        Assert.assertEquals(ELEMENT1, element);
        list.addElement(ELEMENT2);
        Assert.assertTrue(list.getSizeOfList()==2);
    }

    @Test
    public void removeElementByIndexTest() {
        Assert.assertTrue(list.getSizeOfList() == 0);
        //index less than zero
        boolean removeSuccess = list.removeElementByIndex(-1);
        Assert.assertFalse(removeSuccess);
        //Index greater than size of array
        removeSuccess = list.removeElementByIndex(1000);
        Assert.assertFalse(removeSuccess);
        //Head does not exist
        removeSuccess = list.removeElementByIndex(0);
        Assert.assertFalse(removeSuccess);

        list.addElement(ELEMENT1);
        list.addElement(ELEMENT2);
        list.addElement(ELEMENT3);
        Assert.assertTrue(list.getSizeOfList() == 3);

        list.removeElementByIndex(2);
        Assert.assertTrue(list.getSizeOfList() == 2);
        String elementAt1 = list.getElementByIndex(1);
        Assert.assertEquals(ELEMENT3, elementAt1);
    }

    @Test
    public void containsElementTest() {
        Assert.assertFalse(list.containsElement(ELEMENT1));
        list.addElement(ELEMENT1);
        Assert.assertTrue(list.getSizeOfList() == 1);
        Assert.assertTrue(list.containsElement(ELEMENT1));
        list.addElement(ELEMENT2);
        Assert.assertTrue(list.getSizeOfList() == 2);
        Assert.assertTrue(list.containsElement(ELEMENT2));
    }

    @Test
    public void findElementByIndexTest() {
        list.addElement(ELEMENT1);
        Assert.assertTrue(list.containsElement(ELEMENT1));
        Assert.assertTrue(list.findIndexByElement(ELEMENT1) == 0);
        list.addElement(ELEMENT2);
        Assert.assertTrue(list.containsElement(ELEMENT2));
        Assert.assertTrue(list.findIndexByElement(ELEMENT2) == 1);
    }

    @Test
    public void getElementByIndex() {
        list.addElement(ELEMENT1);
        String element = list.getElementByIndex(0);
        Assert.assertEquals(ELEMENT1, element);
        list.addElement(ELEMENT2);
        String element2 = list.getElementByIndex(1);
        Assert.assertEquals(ELEMENT2, element2);
    }

}
