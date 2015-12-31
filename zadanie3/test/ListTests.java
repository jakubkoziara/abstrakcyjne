/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import list.TripleList;
import org.junit.Assert;

/**
 *
 * @author Kuba
 */
public class ListTests {

    public ListTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestEmptyListCreation() {
        TripleList<Integer> tripleList = new TripleList<>();
        Assert.assertEquals(0, tripleList.Counting());
        Assert.assertNull(tripleList.getNext());
        Assert.assertNull(tripleList.getPrev());
        Assert.assertNull(tripleList.getMiddle());
    }

    @Test
    public void TestAddingSingleElement() {
        TripleList<Integer> tripleList = new TripleList<>();
        final int value = 4;
        tripleList.add(value);
        Assert.assertEquals(1, tripleList.Counting());
        Assert.assertEquals(value, (int) tripleList.getValue());
        Assert.assertNull(tripleList.getPrev());
        Assert.assertNull(tripleList.getMiddle());
        Assert.assertNull(tripleList.getNext());
    }

    @Test
    public void TestAddingTwoElements() {

        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 4;
        int value2 = -9;
        tripleList.add(value1);
        tripleList.add(value2);
        Assert.assertEquals(2, tripleList.Counting());
        Assert.assertEquals(value1, (int) tripleList.getValue());
        Assert.assertEquals(value2, (int) tripleList.getMiddle().getValue());
        Assert.assertEquals(tripleList.getValue(), tripleList.getMiddle().getMiddle().getValue());
        Assert.assertNull(tripleList.getPrev());
        Assert.assertNotNull(tripleList.getMiddle());
        Assert.assertNull(tripleList.getNext());
        Assert.assertNull(tripleList.getMiddle().getPrev());
        Assert.assertNull(tripleList.getMiddle().getNext());
    }

    @Test
    public void TestAddingTreeElements() {
        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 4;
        int value2 = -9;
        int value3 = 47;
        tripleList.add(value1);
        tripleList.add(value2);
        tripleList.add(value3);
        Assert.assertEquals(3, (int) tripleList.Counting());

        Assert.assertEquals(value1, (int) tripleList.getValue());
        Assert.assertEquals(value2, (int) tripleList.getMiddle().getValue());
        Assert.assertEquals(value3, (int) tripleList.getNext().getValue());
        Assert.assertNull(tripleList.getPrev());
        Assert.assertNotNull(tripleList.getMiddle());
        Assert.assertNotNull(tripleList.getNext());
        Assert.assertNull(tripleList.getMiddle().getPrev());
        Assert.assertNotNull(tripleList.getMiddle().getMiddle());
        Assert.assertNull(tripleList.getMiddle().getNext());
        Assert.assertNotNull(tripleList.getNext().getPrev());
        Assert.assertNull(tripleList.getNext().getMiddle());
        Assert.assertNull(tripleList.getNext().getNext());
        Assert.assertEquals(value1, (int) tripleList.getValue());
        Assert.assertEquals(value2, (int) tripleList.getMiddle().getValue());
        Assert.assertEquals(value3, (int) tripleList.getNext().getValue());
    }

    public void TestAddingFiveElements() {

        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;
        int value4 = 4;
        int value5 = 5;
        tripleList.add(value1);
        tripleList.add(value2);
        tripleList.add(value3);
        tripleList.add(value4);
        tripleList.add(value5);
        Assert.assertEquals(5, (int) tripleList.Counting());
        Assert.assertEquals(value1, (int) tripleList.getValue());
        Assert.assertEquals(value2, (int) tripleList.getMiddle().getValue());
        Assert.assertEquals(value3, (int) tripleList.getNext().getValue());
        Assert.assertEquals(value4, (int) tripleList.getNext().getMiddle().getValue());
        Assert.assertEquals(value5, (int) tripleList.getNext().getNext().getValue());
    }

    @Test
    public void TestListsEnumerator() {
        double[] values = {1.1, 3.14, 6.13, 9.99999, 99.001};
        TripleList<Double> tripleList = new TripleList<>();
        int i;
        for (i = 0; i < values.length; ++i) {
            tripleList.add(values[i]);
        }
        i = 0;
        for (TripleList<Double> d : tripleList) {
            if (values[i++] == d.getValue()) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }

        }
    }

    @Test
    public void TestIfNoCycle() {
        /**
         * Initialization of the TripleList *
         */
        final int NUMBER_OF_ELEMENTS = 100;
        TripleList<Integer> tripleList = new TripleList<>();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; ++i) {
            tripleList.add(i);
        }
        /**
         * Created 2 TripleLists, first jumps every single element, another
         * every two elements, in out case every two elements means every
         * NextElement*
         */
        TripleList<Integer> tripleListEverySingleNode = tripleList;
        TripleList<Integer> tripleListEveryTwoNodes = tripleList.getNext();
        for (int i = 0; i < NUMBER_OF_ELEMENTS * NUMBER_OF_ELEMENTS; ++i) {
            Assert.assertNotSame(tripleListEverySingleNode, tripleListEveryTwoNodes);
            //JumpToNextElement(ref tripleListEverySingleNode);
            if (null == tripleListEveryTwoNodes.getNext()) {
                break;
            } else {
                tripleListEveryTwoNodes = tripleListEveryTwoNodes.getNext();
            }
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
