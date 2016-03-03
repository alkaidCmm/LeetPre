package com.cmm.jzOffer.In20151111;

public class FriendsZone {
	// 简单的并查集应用
	int set[] = new int[1000];

	int find(int x) // 带路径优化的并查集查找算法
	{
		int i, j, r;
		r = x;
		while (set[r] != r)
			r = set[r];
		i = x;
		while (i != r) {
			j = set[i];
			set[i] = r;
			i = j;
		}
		return r;
	}

	void merge(int x, int y) // 优化的并查集归并算法
	{
		int t = find(x);
		int h = find(y);
		if (t < h)
			set[h] = t;
		else
			set[t] = h;
	}

	int friends(int n, int m, int r[][]) {
		int i, count;
		for (i = 1; i <= n; ++i)
			// 初始化并查集，各点为孤立点，分支数为n
			set[i] = i;
		for (i = 0; i < m; ++i)
			merge(r[i][0], r[i][1]);
		count = 0;
		for (i = 1; i <= n; ++i) {
			if (set[i] == i)
				++count;
		}
		return count;
	}

	public static void main(String[] args) {
		FriendsZone fz=new FriendsZone();
		//fz.friends(5, 3, r);

	}

}
