package com.xsis.training.logic;

import com.xsis.training.logic.utilisasi.DeretAngka;

public class MekarSegitiga {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		this.kolom = n*n;
		this.baris = DeretAngka.getTriangular(n);
		data = new String[this.baris][this.kolom];
		for(int bangun=0; bangun < n; bangun++){
			//ketiga
			for(int i = 0; i < 1; i++){
				for(int j = 0; j < 1; j++){
					data[i][j] = "*";
				}
			}
			//kedua
			for(int i = 1; i < 3; i++){
				for(int j = 1; j < 4; j++){
					if(i+j >= 3 && -i +j <= 1){
						data[i][j] = "#";
					}
				}
			}
			//ketiga
			for(int i = 3; i < 6; i++){
				for(int j = 4; j < 9; j++){
					if(i+j >= 9 && -i +j <= 3){
						data[i][j] = "#";
					}
				}
			}
			
			//ke-empat
			for(int i = 6; i < 10; i++){
				for(int j = 9; j < 16; j++){
					if(i+j >= 18 && -i +j <= 6){
						data[i][j] = "#";
					}
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
		MekarSegitiga soal1 = new MekarSegitiga();
		//n => argument
		int n = 4;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
