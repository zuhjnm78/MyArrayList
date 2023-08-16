import java.util.Arrays;

    public class MyArrayList implements StringList {

        private static final int DEFAULT_CAPACITY = 10;

        private String[] array;
        private int size;

        public MyArrayList() {
            array = new String[DEFAULT_CAPACITY];
            size = 0;
        }

        public MyArrayList(int initialCapacity) {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException("Initial capacity cannot be negative");
            }
            array = new String[initialCapacity];
            size = 0;
        }

        private void ensureCapacity(int minCapacity) {
            int oldCapacity = array.length;
            if (minCapacity > oldCapacity) {
                int newCapacity = Math.max(oldCapacity * 2, minCapacity);
                array = Arrays.copyOf(array, newCapacity);
            }
        }

        @Override
        public String add(String item) {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            ensureCapacity(size + 1);
            array[size] = item;
            size++;
            return item;
        }
        @Override
        public String add(int index, String item) {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            ensureCapacity(size + 1);
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = item;
            size++;
            return item;
        }

        @Override
        public String set(int index, String item) {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            String oldItem = array[index];
            array[index] = item;
            return oldItem;
        }

        @Override
        public String remove(String item) {
            int index = indexOf(item);
            if (index != -1) {
                return remove(index);
            }
            throw new IllegalArgumentException("Item not found");
        }

        @Override
        public String remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            String removedItem = array[index];
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null; // Clear the last element
            size--;
            return removedItem;
        }
        @Override
        public boolean contains(String item) {
            if (item == null) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (item.equals(array[i])) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int indexOf(String item) {
            if (item == null) {
                return -1;
            }
            for (int i = 0; i < size; i++) {
                if (item.equals(array[i])) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(String item) {
            if (item == null) {
                return -1;
            }
            for (int i = size - 1; i >= 0; i--) {
                if (item.equals(array[i])) {
                    return i;
                }
            }
            return -1;
        }
        @Override
        public String get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            return array[index];
        }

        @Override
        public boolean equals(StringList otherList) {
            if (otherList == null) {
                throw new IllegalArgumentException("Other list cannot be null");
            }
            if (this == otherList) {
                return true;
            }
            if (this.size() != otherList.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!this.get(i).equals(otherList.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public void clear() {
            Arrays.fill(array, 0, size, null);
            size = 0;
        }

        @Override
        public String[] toArray() {
            return Arrays.copyOf(array, size);
        }

        @Override
        public int size() {
            return size;
        }
    }
