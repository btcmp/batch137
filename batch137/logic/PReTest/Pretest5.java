package com.xsis.training.logic.PReTest;

public class Pretest5 {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		this.kolom = n;
		this.baris = n;
		data = new String[this.baris][this.kolom];
		int kanan = n - 1;
		int kiri2 = -1;
		
		for(int i = 0; i < this.baris; i++){
			for(int j = 0; j < this.kolom; j++){
				if(i % 2 == 0){
					data[i][j] = "#";
				} else if(i % 4 == 1){
					if(j == kanan){
						data[i][j] = "&";
						kanan = kanan - 2;
						kiri2 = kiri2 + 2;
					}
				} else if(i % 4 == 3){
					if(j == kiri2){
						data[i][j] = "+";
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
		Pretest5 soal1 = new Pretest5();
		//n => argument
		int n = 9;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
