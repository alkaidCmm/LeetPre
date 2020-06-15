package com.cmm.fuckalgor;

/**
 * @author cmm
 * @date 2020/6/12 11:41 AM
 * @desc 数组实现大根堆：最大优先级队列
 * 如果某个节点 A 比它的子节点（中的一个）小，那么 A 就不配做父节点，应该下去，下面那个更大的节点上来做父节点，这就是对 A 进行下沉。
 * <p>
 * 如果某个节点 A 比它的父节点大，那么 A 不应该做子节点，应该把父节点换下来，自己去做父节点，这就是对 A 的上浮。
 */
public class MaxStack<Key extends Comparable<Key>> {

    private Key[] keyArr;

    /**
     * 堆中 数据 个数
     */
    private int N = 0;

    public MaxStack(int cap) {
        // 索引 0 不使用，多分配一个空间
        this.keyArr = (Key[]) new Comparable[cap + 1];
    }

    public Key max() {
        return keyArr[1];
    }

    /* 插入元素 k */
    public void insert(Key key) {
        N++;
        keyArr[N] = key;
        swim(N);
    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        Key max = max();
        exch(1, N);
        keyArr[N] = null;
        N--;
        sink(1);
        return max;
    }

    /* 上浮第 k 个元素，以维护最大堆性质 */
    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            // 数值交换，下标k变换为父k
            exch(k, parent(k));
            k = parent(k);
        }
    }


    /**
     * 下沉第 k 个元素，以维护最大堆性质
     * 下沉某个节点 A，需要 A 和其两个子节点比较大小，如果 A 不是最大的就需要调整位置，要把较大的那个子节点和 A 交换。
     */
    private void sink(int k) {
        while (left(k) < N) {
            int old = left(k);
            if (right(k) <= N && less(old, right(k))) {
                old = right(k);
            }
            // k节点数值，大于左右两个子节点对应的数值
            if (less(old, k)) {
                break;
            }
            exch(k, old);
            k = old;
        }
    }

    /* 交换数组的两个元素 */
    private void exch(int i, int j) {
        Key temp = keyArr[i];
        keyArr[i] = keyArr[j];
        keyArr[j] = temp;
    }

    /* keyArr[i] 是否比 keyArr[j] 小？ */
    private boolean less(int i, int j) {
        return keyArr[i].compareTo(keyArr[j]) < 0;
    }

    // 父节点的索引
    int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }

    public static void main(String[] args) {
//        int[] keyArr=new int[]{0,20,10,15,6,7,12,13};
        MaxStack<Integer> maxStack = new MaxStack<>(10);
        maxStack.insert(0);
        maxStack.insert(1);
        maxStack.insert(2);
        maxStack.insert(3);
        maxStack.insert(4);
        maxStack.insert(5);
        maxStack.insert(6);
        maxStack.insert(7);
        maxStack.insert(8);
        maxStack.insert(9);
        maxStack.insert(10);


    }

}
