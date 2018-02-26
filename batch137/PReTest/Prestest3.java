package com.xsis.training.logic.PReTest;

public class Prestest3 {

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
				if(i >= j && i+j <= n - 1 && j % 2 == 0){
					data[i][j] = "*";
				} else if(i <= j && i+j <= n - 1 && i % 2 == 0){
					data[i][j] = "*";
				} else if(i + j >= n - 1 && i <= j && j % 2 == 0){
					data[i][j] = "*";
				} else if(i + j >= n - 1 && i >= j&& i % 2 == 0){
					data[i][j] = "*";
				}
				
				//untuk memotong garis 
				if(i -j == 1){
					if(i % 2 == 0){
						data[i][j] = "*";
					} else {
						data[i][j] = " ";
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
		Prestest3 soal1 = new Prestest3();
		//n => argument
		int n = 9;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
