package com.xsis.training.logic.utilisasi;

public class DeretAngka {

	//function
	//1,3,5,3,2,1
	public static int[] getAngkaKebalik(int n){
		
		int[] data = new int[n];
		int angka = 1;
		for(int i = 0; i < n; i++){
			//System.out.println(angka);
			data[i] = angka;
			if(i <= n/2 -1){
				angka = angka + 2;
			} else {
				angka = angka - 2;
			}	
		}
		
		return data;
		//System.out.println(Arrays.toString(data));
	}
	
	//output : 1,3,6,10,15..
	public static int getTriangular(int n){
		int hasil = 0;
		for(int i = 1; i <= n; i++){
			hasil = hasil + i;
		}
		return hasil;
	}
	
	//from [1,3,6,10,15] 
	public static int[] getArrTriangular(int n){
		int[] data = new int[n+1];
		int hasil = 0;
		data[0] = 0;
		for(int i = 1; i <= n; i++){
			hasil = hasil + i;
			data[i] = hasil;
		}
		return data;
	}
	
	//output : [0, 1, 4, 8, 13, 19]
	public static int[] getIncrement(int n){
		int input = n;
		int increment = 4;
		int current = 4;
		int[] data = new int[input];
		for(int i = 0; i < input; i++){
			if(i < 2){
				data[i] = i;
			}else {
				data[i] = current;
				current = current + increment;
				increment++;
			}
		}
		
		return data;
	}
}
