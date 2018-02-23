package com.xsis.training.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.xsis.training.logic.utilisasi.DeretAngka;

public class Soal9 {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		this.kolom = n;
		this.baris = n;
		data = new String[this.baris][this.kolom];
		
		int[] dt = DeretAngka.getAngkaKebalik(n);
		System.out.println(Arrays.toString(dt));
		
		for(int i = 0; i < this.baris; i++){
			for(int j = 0; j < this.kolom; j++){
				data[i][j] = dt[j]+"";
			}
		}
	}
	
	public void showMatrix(){
		for(int i = 0; i < this.baris; i++){
			for(int j = 0; j < this.kolom; j++){
				System.out.print(data[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		Soal9 soal1 = new Soal9();
		//n => argument
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("masukkan inputan : >> ");
		int input = Integer.parseInt(br.readLine());
		
		soal1.setDataMatrix(input);
		soal1.showMatrix();
	}
	
}
