package com.file;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

	public static void display2() throws ClassNotFoundException {

		String csvFile = "C:\\Users\\Vinay Konda\\Desktop\\New folder (3)\\1\\file.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));

			ArrayList<String> al = new ArrayList<String>();

			while ((line = br.readLine()) != null) {

				String[] transaction = line.split(cvsSplitBy);

				al.add(transaction[0] + "," + transaction[1] + "," + transaction[2] + "," + transaction[3] + ","
						+ transaction[4] + "," + transaction[5]);

			}

			String csv[] = al.toArray(new String[al.size()]);

			System.out.println("Root Elements : records");

			System.out.println("-------------------------");

			for (String s1 : al) {
				System.out.println("Duplicates List " + s1);
			}

			

			RemoveDuplicate.method(al);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}