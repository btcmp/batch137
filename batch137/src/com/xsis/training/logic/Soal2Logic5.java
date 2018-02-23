package com.xsis.training.logic;

import java.util.Arrays;

import com.xsis.training.logic.utilisasi.DeretAngka;

public class Soal2Logic5 {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		int max = DeretAngka.getTriangular(n);
		this.kolom = max;
		this.baris = max;
		data = new String[this.baris][this.kolom];
		int[] dataArr = DeretAngka.getArrTriangular(n);
		System.out.println(Arrays.toString(dataArr));
		
		for(int bangun = 0; bangun<n; bangun++){
			for(int i = 0; i < this.baris; i++){
				for(int j = 0; j < this.kolom; j++){
					//kotak 1
					for(int ki=dataArr[bangun]; ki < dataArr[bangun+1]; ki++){
						for(int kj=dataArr[bangun]; kj <dataArr[bangun+1]; kj++){
							data[ki][kj] = "*";
						}
					}
					/*//kotak 2
					for(int ki=1; ki < 3; ki++){
						for(int kj=1; kj < 3; kj++){
							data[ki][kj] = "*";
						}
					}
					//kotak 3
					for(int ki=3; ki < 6; ki++){
						for(int kj=3; kj < 6; kj++){
							data[ki][kj] = "*";
						}
					}*/
				}
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
	
	public static void main(String[] args){
		Soal2Logic5 soal1 = new Soal2Logic5();
		//n => argument
		int n = 3;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
