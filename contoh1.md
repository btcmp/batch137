# Contoh Logic 2 Soal 9
```java
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
		
		int[] dt = this.getAngkaKebalik(n);
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
	
	//function
	public int[] getAngkaKebalik(int n){
		
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
}

```