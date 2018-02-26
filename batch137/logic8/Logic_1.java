package com.xsis.training.logic8;

public class Logic_1 {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		this.kolom = n;
		this.baris = n;
		data = new String[this.baris][this.kolom];
		for(int i = 0; i < this.baris; i++){
			for(int j = 0; j < this.kolom; j++){
				if(i == j && j <= n / 2 || j == 0){
					data[i][j] = "*";
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
		Logic_1 soal1 = new Logic_1();
		//n => argument
		int n = 5;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
