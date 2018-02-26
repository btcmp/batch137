package com.xsis.training.logic.PReTest;

public class Pretest1 {

	 int kolom=0;
	 int baris=0;
	//matrix
	private String[][] data;
	
	//parameter
	public void setDataMatrix(int n){
		int p = n - 1;
		this.kolom = n * p;
		this.baris = n * p;
		
		data = new String[this.baris][this.kolom];
		int addBlock = 0;
		for(int block = 0; block < n; block++){
			int addBangun = 0;
			for(int bangun = 0; bangun < n; bangun++){
				for(int i = 0; i < this.baris; i++){
					for(int j = 0; j < this.kolom; j++){
						if(j <= p-1 && i <= p-1 && i >= j){
							if(block == 0 || bangun == 0 || bangun == block){
								data[i + addBlock][j+ addBangun] = "*";
							}
							
						}
					}
				}
				addBangun = addBangun + p;
			}
			addBlock = addBlock +p;
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
		Pretest1 soal1 = new Pretest1();
		//n => argument
		int n = 4;
		soal1.setDataMatrix(n);
		soal1.showMatrix();
	}
}
