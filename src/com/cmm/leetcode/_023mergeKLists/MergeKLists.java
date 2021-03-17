package com.cmm.leetcode._023mergeKLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	private Comparator<IteratorWrapper> myComparator = new Comparator<IteratorWrapper>() {
		
		public int compare(IteratorWrapper left, IteratorWrapper right) {
			System.out.println("1122");
			return left.val - right.val;
		}
	};

	public class IteratorWrapper {
		Integer val;
		Iterator<Integer> it;

		public IteratorWrapper(Integer val, Iterator<Integer> it) {
			this.val = val;
			this.it = it;
		}
	}

	public List<Integer> mergeKLists(List<Iterator<Integer>> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		System.out.println("lists.size()=" + lists.size());
		PriorityQueue<IteratorWrapper> heap = new PriorityQueue<IteratorWrapper>(
				lists.size(), myComparator);
		System.out.println("heap.size()="+heap.size());
		for (int i = 0; i < lists.size(); i++) {
			//System.out.println(".....lists.get(i).next()="+lists.get(i).next());
			if (lists.get(i) != null && lists.get(i).hasNext()) {
				heap.offer(new IteratorWrapper(lists.get(i).next(), lists
						.get(i)));
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		while (!heap.isEmpty()) {
			IteratorWrapper iw = heap.poll();// 弹出队列头元素
			result.add(iw.val);
			if (iw.it.hasNext()) {
				iw.val = iw.it.next();
				heap.offer(iw);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> l11 = new ArrayList<Integer>();
		l11.add(1);
		l11.add(3);
		l11.add(5);
		l11.add(7);
		l11.add(10);
		l11.add(30);
		l11.add(50);
		List<Integer> l22 = new ArrayList<Integer>();
		l22.add(2);
		l22.add(3);
		l22.add(6);
		l22.add(17);
		l22.add(50);
		l22.add(130);
		l22.add(150);
		List<Integer> l33 = new ArrayList<Integer>();
		l33.add(35);
		l33.add(49);
		List<Iterator<Integer>> listIterators = new ArrayList<Iterator<Integer>>();
		listIterators.add(l33.iterator());
		listIterators.add(l22.iterator());
		listIterators.add(l11.iterator());
		for(Iterator<Integer> ll:listIterators){
			System.out.println("ll.netx()="+ll.next());
		}
		MergeKLists mkl = new MergeKLists();
		List<Integer> result = mkl.mergeKLists(listIterators);
		System.out.println(result.toString());

	}

}
