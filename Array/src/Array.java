public class Array<E> {
    private E[] data;
    private int size = 0;

    /**
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * @desc 无参构造器，默认capacity是10
     */
    public Array() {
        this(10);
    }

    /**
     * @desc 变长参数 | 数组 构造器
     * @param array
     */
    public Array(E[] array) {
        size = array.length;
        data = (E[])new Object[size];

        for (int i = 0; i < size; i += 1) {
            data[i] = array[i];
        }
    }

    /**
     * @desc 获得数组的数据个数
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * @desc 获得数组容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @desc 数组是不是为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @desc 按照索引添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("operation fail, index is illegal");
        }

        if (data.length == size) { // 需要扩容
            resize(2 * data.length);
        }

        for (int i = size; i > index; i -= 1) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size += 1;
    }

    /**
     * @desc 在起始位置添加元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * @desc 在最后位置添加元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * @desc 查询某个索引的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("operation fail, index is illegal");
        }

        return data[index];
    }

    public E getFirst() {
        return data[0];
    }

    public E getLast() {
        return data[size - 1];
    }

    public void set(int index, E e) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("operation fail, index is illegal");
        }

        data[index] = e;
    }

    /**
     * @desc 数组是不是包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i += 1) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @desc 在数组中查找元素e，如果不存在返回-1, 存在返回其第n个索引
     * @param e
     * @param n
     * @return
     */
    public int find(E e, int n) {
        int count = 0;

        for (int i = 0; i < size; i += 1) {
            if (data[i].equals(e) && ++count == n) {
                return i;
            }
        }

        return -1;
    }

    public int find(E e) {
        return this.find(e, 1);
    }

    /**
     * @desc 在数组中查找第1个为e的元素的索引
     * @param e
     * @return
     */
    public int findFirst(E e) {
        return find(e, 1);
    }

    /**
     * @desc 在数组中照抄最后一个元素为e的索引
     * @param e
     * @return
     */
    public int findLast(E e) {
        int n = -1;

        for (int i = 0; i < size; i += 1) {
            if (data[i].equals(e)) {
                n = i;
            }
        }

        return n;
    }

    public Array findAll(E e) {
        Array array = new Array(data.length);

        for (int i = 0; i < size; i += 1) {
            if (data[i].equals(e)) {
                array.addLast(i);
            }
        }

        return array;
    }

    /**
     * @desc 在数组中查找元素等于e的个数
     * @param e
     * @return
     */
    public int findCount(E e) {
        int count = 0;

        for (int i = 0; i < size; i += 1) {
            if (data[i].equals(e)) {
                count += 1;
            }
        }

        return count;
    }

    /**
     * @desc 从数组中删除某个索引的元素，并且将这个元素返回
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("operation fail, index is illegal");
        }

        E ret = data[index];

        for (int i = index + 1; i < size; i += 1) {
            data[i - 1] = data[i];
        }

        // 释放内存空间
        data[size] = null;
        size -= 1;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e, int n) {
        int index = find(e, n);

        if (index != -1) {
            remove(index);
        }
    }

    public void removeElement(E e) {
        int index = find(e, 1);

        if (index != -1) {
            remove(index);
        }
    }

    public void removeFirstElement(E e) {
        removeElement(e, 1);
    }

    public void removeLastElement(E e) {
        int index = findLast(e);

        if (index != -1) {
            remove(index);
        }
    }

    public void removeAllElement(E e) {
        int offset = 0;
        int newSize = size;

        for (int i = 0; i < size; i += 1) {
            if (offset > 0) {
                data[i - offset] = data[i];
            }

            if (data[i].equals(e)) {
                offset += 1;
                newSize -= 1;
            }
        }

        // 释放内存空间
        for (int j = newSize; j < size; j += 1) {
            data[j] = null;
        }

        size = newSize;
    }

    public void removeAll() {
        data = (E[])new Object[0];
        size = 0;
    }

    private void resize(int newCapacity) {
        E[] newData = (E [])new Object[newCapacity];

        for (int i = 0; i < size; i += 1) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ，capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i += 1) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(" ，");
            }
        }
        res.append("]");

        return res.toString();
    }
}
