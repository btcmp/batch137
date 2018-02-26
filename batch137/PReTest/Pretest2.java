package com.xsis.training.logic.PReTest;

public class Pretest2 {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		int p = n - 1;
		int q = n + 1;
		this.kolom = n * q;
		this.baris = n * q;
		
		data = new String[this.baris][this.kolom];
		int addI2 = 0;
		for(int i2=0; i2 < n+1; i2++){
			int addJ2 = 0;
			for(int j2 = 0; j2 < n+1; j2++){
				for(int i = 0; i < this.baris; i++){
					for(int j = 0; j < this.kolom; j++){
						if(i == 0 && j <= p-1 || j == 0 && i <= p-1 || j == p -1 && i <= p -1 || i == p-1 && j <= p-1){
							if(j2 == i2 || i2 + j2 == n){
								data[i + addI2][j + addJ2] = "*";
							}
									
						} 
					}
				}
				addJ2 = addJ2 + p;
			}
			addI2 = addI2 + p;
		}
		
		
				
			
	}
	
	public void showMatrix(){
		for(int i = 0; i < this.baris; i++){
			for(int j = 0; j < this.kolom; j++){
				if(data[i][j] != null){
					System.out.print(data[i][j] + "\t");
				} else {
					System.out.print("\t");
				}
				
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args){
		Pretest2 soal1 = new Pretest2();
		//n => argument
		int n = 4;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
