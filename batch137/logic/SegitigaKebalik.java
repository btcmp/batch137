package com.xsis.training.logic;

public class SegitigaKebalik {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		this.kolom = n*2-1;
		this.baris = n;
		data = new String[this.baris][this.kolom];
		for(int i = 0; i < this.baris; i++){
			for(int j = 0; j < this.kolom; j++){
				if(-i +j >= 0 && +i +j <= (n-1)*2){
						data[i][j] = "#";	
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
		SegitigaKebalik soal1 = new SegitigaKebalik();
		//n => argument
		int n = 3;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
