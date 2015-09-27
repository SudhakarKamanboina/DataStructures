package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writefeature {

	public static void main(String[] args)
	{
		try {
			 
			String content = "@attribute feature"; 
			File file = new File("D:/feature.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for( int i=0; i<=700;i++)
			{	
				bw.write(content+i+"numeric");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
