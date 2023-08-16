import java.util.Arrays;

public class MyArrayListExtendedTest {
    public static void main(String[] args) {
        testBasicOperations();
        testAddAtIndex();
        testSet();
        testRemove();
        testContainsAndIndexOf();
        testEquals();
        testEmptyList();
        testToArray();
        testCapacityExpansion();
        testAddingNullItem();
        testAddingAtInvalidIndex();
        testGetWithInvalidIndex();
        testSetWithInvalidIndex();
        testRemoveWithInvalidIndex();
        testRemoveWithEmptyList();
        testGetWithEmptyList();
        testContainsWithNullItem();
        testIndexOfWithNullItem();
        testLastIndexOfWithNullItem();
        testEqualsWithNullOtherList();
        testClearOnAnAlreadyClearedList();
        testToArrayOnAnEmptyList();
        testToArrayOnNonEmptyList();
    }

    private static void testBasicOperations() {
        MyArrayList list = new MyArrayList();
        assert list.isEmpty();
        assert list.size() == 0;

        list.add("Ivan");
        list.add("Artem");

        assert list.size() == 2;
        assert list.get(0).equals("Ivan");
        assert list.get(1).equals("Artem");
        assert list.contains("Ivan");
        assert !list.isEmpty();
    }

    private static void testAddAtIndex() {
        MyArrayList list = new MyArrayList();

        list.add("Ivan");
        list.add(0, "Artem");
        list.add(1, "Oleg");

        assert list.size() == 3;
        assert list.get(0).equals("Ivan");
        assert list.get(1).equals("Artem");
        assert list.get(2).equals("Oleg");

        list.add(0, "Igor");
        assert list.get(0).equals("Igor");

        list.add(4, "Alex");
        assert list.get(4).equals("Alex");
    }

    private static void testSet() {
        MyArrayList list = new MyArrayList();
        list.add("Ivan");
        list.add("Artem");
        list.add("Oleg");

        assert list.set(1, "Igor").equals("Artem");
        assert list.get(1).equals("Igor");
    }

    private static void testRemove() {
        MyArrayList list = new MyArrayList();
        list.add("Ivan");
        list.add("Artem");
        list.add("Oleg");

        assert list.remove("Artem").equals("Artem");
        assert list.size() == 2;
        assert list.get(0).equals("Ivan");
        assert list.get(1).equals("Oleg");

        assert list.remove(0).equals("Ivan");
        assert list.size() == 1;
        assert list.get(0).equals("Oleg");
    }

    private static void testContainsAndIndexOf() {
        MyArrayList list = new MyArrayList();

        list.add("Ivan");
        list.add("Artem");
        list.add("Oleg");
        list.add("Artem");

        assert list.contains("Artem");
        assert !list.contains("Igor");
        assert list.indexOf("Artem") == 1;
        assert list.lastIndexOf("Artem") == 3;
        assert list.indexOf("Igor") == -1;
        assert list.lastIndexOf("Igor") == -1;
    }

    private static void testEquals() {
        MyArrayList list1 = new MyArrayList();
        list1.add("Ivan");
        list1.add("Artem");

        MyArrayList list2 = new MyArrayList();
        list2.add("Ivan");
        list2.add("Artem");

        MyArrayList list3 = new MyArrayList();
        list3.add("Ivan");
        list3.add("Igor");

        assert list1.equals(list2);
        assert !list1.equals(list3);
    }

    private static void testEmptyList() {
        MyArrayList list = new MyArrayList();
        assert list.isEmpty();
        assert list.size() == 0;

        list.add("Ivan");
        assert !list.isEmpty();
        assert list.size() == 1;

        list.clear();
        assert list.isEmpty();
        assert list.size() == 0;
    }

    private static void testToArray() {
        MyArrayList list = new MyArrayList();
        list.add("Ivan");
        list.add("Artem");
        list.add("Oleg");

        String[] array = list.toArray();
        assert array.length == 3;
        assert array[0].equals("Ivan");
        assert array[1].equals("Artem");
        assert array[2].equals("Oleg");
    }

    private static void testCapacityExpansion() {
        MyArrayList list = new MyArrayList(2);

        list.add("Ivan");
        list.add("Artem");
        list.add("Oleg");
        list.add("Igor");

        assert list.size() == 4;
        assert list.get(0).equals("Ivan");
        assert list.get(1).equals("Artem");
        assert list.get(2).equals("Oleg");
        assert list.get(3).equals("Igor");
    }

    private static void testAddingNullItem() {
        MyArrayList list = new MyArrayList();
        try {
            list.add(null);
        } catch (
                IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void testAddingAtInvalidIndex() {
        MyArrayList list = new MyArrayList();
        try {
            list.add(5, "Invalid");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }

        list.add("Ivan");
        list.add("Artem");
        list.add("Oleg");
    }

    private static void testGetWithInvalidIndex() {
        MyArrayList list = new MyArrayList();


        try {
            System.out.println(list.get(5)); // This should throw an IndexOutOfBoundsException
        } catch (
                IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void testSetWithInvalidIndex() {
        MyArrayList list = new MyArrayList();
        try {
            list.set(5, "Invalid");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void testRemoveWithInvalidIndex() {
        MyArrayList list = new MyArrayList();
        try {
            list.remove(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void testRemoveWithEmptyList() {
        MyArrayList list = new MyArrayList();
        list.clear();
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void testGetWithEmptyList() {
        MyArrayList list = new MyArrayList();
        try {
            System.out.println(list.get(0)); // This should throw an IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void testContainsWithNullItem() {
        MyArrayList list = new MyArrayList();
        System.out.println(list.contains(null));
    }

    private static void testIndexOfWithNullItem() {
        MyArrayList list = new MyArrayList();
        System.out.println(list.indexOf(null));
    }

    private static void testLastIndexOfWithNullItem() {
        MyArrayList list = new MyArrayList();
        System.out.println(list.lastIndexOf(null));
    }

    private static void testEqualsWithNullOtherList() {
        MyArrayList list = new MyArrayList();
        try {
            list.equals(null);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void testClearOnAnAlreadyClearedList() {
        MyArrayList list = new MyArrayList();
        list.clear();
        System.out.println(list.size());
    }

    private static void testToArrayOnAnEmptyList() {
        MyArrayList list = new MyArrayList();
        String[] array = list.toArray();
        System.out.println(Arrays.toString(array));
    }

    private static void testToArrayOnNonEmptyList() {
        MyArrayList list = new MyArrayList();
        list.add("Apple");
        list.add("Banana");
        String [] array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
