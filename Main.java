package oop6z4;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File folderIn = new File("a");
		File folderOut = new File("b");
		File[] fileArray = folderIn.listFiles();
		int countThread=fileArray.length;		
		copyFile(countThread, folderIn, folderOut, fileArray);
		
		System.out.println("Copy FINISH");
		

	}
	public static void copyFile(int count, File in, File out, File[]fileArr){
		Thread [] copyArray=new Thread[count];
		for (int i = 0; i < copyArray.length; i++) {
			copyArray[i]= new Thread(new CopyThread(fileArr[i], out));	
			
		}
		for (int i = 0; i < copyArray.length; i++) {
			copyArray[i].start();
		}
		for (int i = 0; i < copyArray.length; i++) {
			try {
				copyArray[i].join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}

}
