package com.xsis.training.teori;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyErrorHandling {

	public void index(){
		//Object anu = new Anu();
		String[] data = new String[2];
		
		try{
			data[0] = "ok";
			data[1] = "ok";
			data[2] = "failed kayaknya";
		} catch(Exception e){
			//e.printStackTrace();
		}
		
		System.out.println("executed!!");
	}
	
	public void myMessage() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("masukan umur : ");
		String data =br.readLine();
		try{
			int age = Integer.parseInt(data);
			int[] ar = new int[1];
			ar[0] = 0;
			ar[1] = 1;
		}catch(java.lang.NumberFormatException e){
			System.err.println("input harus bilbul");
		}catch(java.lang.ArrayIndexOutOfBoundsException e2){
			System.err.println("index array kebanyakan");
		}
		
		System.out.println("hallo, umur mu adalah :"+ data);
	}
	
	public static void main(String args[]){
		MyErrorHandling meh = new MyErrorHandling();
		meh.index();
		try {
			meh.myMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
