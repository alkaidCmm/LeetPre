package com.cmm.jzOffer._44isContinuous;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Demo {
	public double getTotalCost(double totalCost) {
		double result = totalCost;
		Random rand = new Random();
		final double transformCost = rand.nextInt(50);// 随机生成一个邮费的价格
		double totalAndDiscountCostFirst = 0;// 方案一最后消费
		double totalAndDiscountCostSecond = 0;// 方案方案二最后消费
		if (totalCost - 100 < 0.0001)// 没有优惠
			return totalCost + transformCost;// 返回原价+邮费
		else {
			totalAndDiscountCostFirst = totalCost;// 方案一消费，免邮
			if (totalCost - 300 > 0.0001)// 方案二，超过300
				totalAndDiscountCostSecond = totalCost - transformCost + 20;
			else// 方案二，100到300之间
				totalAndDiscountCostSecond = totalCost - transformCost + 10;
			result = totalAndDiscountCostFirst < totalAndDiscountCostSecond
					? totalAndDiscountCostFirst : totalAndDiscountCostSecond;// 结果去两种方案最小值
			return result;
		}
	}

	public void writeFile(String fileName, String contentFile,
			String[] positionFileCopy) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("不存在");
			System.out.println(file.createNewFile());
			file.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(file, true);
		OutputStreamWriter out = new OutputStreamWriter(fos, "utf-8");
		BufferedWriter bw = new BufferedWriter(out);
		bw.write(contentFile);
		bw.write("\r\n");
		bw.flush();
		for(int i=0;i<positionFileCopy.length-1;i++)
			fileChannelCopy(file, new File(positionFileCopy[i]));
		System.out.println("写入成功！");
	}

	public void fileChannelCopy(File s, File t) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
