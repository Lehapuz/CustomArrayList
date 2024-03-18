package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class CustomArrayListTest {

    CustomArrayList<Integer> customListInt = new CustomArrayList<>();
    CustomArrayList<String> customListStr = new CustomArrayList<>();
    CustomArrayList<String> emptyList = new CustomArrayList<>();

    @BeforeEach
    protected void setUp() {
        customListInt.add(10);
        customListInt.add(22);
        customListInt.add(12);
        customListInt.add(4);
        customListInt.add(2);
        customListInt.add(65);
        customListInt.add(23);
        customListInt.add(24);
        customListInt.add(27);
        customListInt.add(15);
        customListInt.add(18);
        customListInt.add(22);
        customListStr.add("bb");
        customListStr.add("qqq");
        customListStr.add("aa");
        customListStr.add("cc");
        customListStr.add("xxx");
        customListStr.add("zzs");
    }

    @Test
    protected void check_size_of_lists() {
        int expectedINT = 12;
        int expectedSTR = 6;
        Assertions.assertEquals(expectedINT, customListInt.size());
        Assertions.assertEquals(expectedSTR, customListStr.size());
    }

    @Test
    protected void check_empty_list() {
        Assertions.assertTrue(emptyList.isEmpty());
    }

    @Test
    protected void check_existing_elements() {
        int expectedInt = 12;
        String expectedStr = "aa";
        Assertions.assertTrue(customListInt.contains(expectedInt));
        Assertions.assertTrue(customListStr.contains(expectedStr));
    }

    @Test
    protected void check_non_existing_elements() {
        int expectedInt = 112;
        String expectedStr = "abc";
        Assertions.assertFalse(customListInt.contains(expectedInt));
        Assertions.assertFalse(customListStr.contains(expectedStr));
    }

    @Test
    protected void remove_all_elements() {
        int expectedINT = 0;
        int expectedSTR = 0;
        //when
        customListInt.clear();
        customListStr.clear();
        //then
        Assertions.assertEquals(expectedINT, customListInt.size());
        Assertions.assertEquals(expectedSTR, customListStr.size());
    }

    @Test
    protected void when_get_existing_element_then_success() {
        int expectedINT = 2;
        String expectedSTR = "xxx";
        //when
        //then
        Assertions.assertEquals(expectedINT, customListInt.get(4));
        Assertions.assertEquals(expectedSTR, customListStr.get(4));
    }

    @Test
    protected void when_get_existing_element_then_fail() {
        //when
        //then
        assertThrows(
                IndexOutOfBoundsException.class, () -> customListInt.get(56));
    }

    @Test
    protected void when_add_element_by_index_then_success() {
        int expectedINT = 99;
        String expectedSTR = "add";
        //when
        customListInt.add(5, 99);
        customListStr.add(2, "add");
        //then
        Assertions.assertEquals(expectedINT, customListInt.get(5));
        Assertions.assertEquals(expectedSTR, customListStr.get(2));
    }

    @Test
    protected void when_add_element_by_index_then_fail() {
        //when
        //then
        assertThrows(
                IndexOutOfBoundsException.class, () -> customListInt.add(100, 50));
    }

    @Test
    protected void when_remove_element_by_index_then_success() {
        int expectedINT = 11;
        int expectedSTR = 5;
        //when
        customListInt.remove(5);
        customListStr.remove(5);
        //then
        Assertions.assertEquals(expectedINT, customListInt.size());
        Assertions.assertEquals(expectedSTR, customListStr.size());
    }

    @Test
    protected void when_remove_element_by_index_then_fail() {
        //when
        //then
        assertThrows(
                IndexOutOfBoundsException.class, () -> customListInt.remove(100));
    }

    @Test
    protected void when_sort_then_returned_sorted_list() {
        int expectedINT1 = 2;
        int expectedINT2 = 4;
        String expectedSTR1 = "aa";
        String expectedSTR2 = "bb";
        //when
        List<Integer> integerList = customListInt.sort();
        List<String> stringList = customListStr.sort();
        //then
        Assertions.assertEquals(expectedINT1, integerList.get(0));
        Assertions.assertEquals(expectedSTR1, stringList.get(0));
        Assertions.assertEquals(expectedINT2, integerList.get(1));
        Assertions.assertEquals(expectedSTR2, stringList.get(1));
    }

    @Test
    protected void when_quick_sort_then_returned_sorted_list() {
        int expectedINT1 = 2;
        int expectedINT2 = 4;
        String expectedSTR1 = "aa";
        String expectedSTR2 = "bb";
        //when
        customListInt.quickSort();
        customListStr.quickSort();
        //then
        Assertions.assertEquals(expectedINT1, customListInt.get(0));
        Assertions.assertEquals(expectedSTR1, customListStr.get(0));
        Assertions.assertEquals(expectedINT2, customListInt.get(1));
        Assertions.assertEquals(expectedSTR2, customListStr.get(1));
    }
}
