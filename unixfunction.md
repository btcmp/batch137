//output : [0, 1, 4, 8, 13, 19]
	public static int[] getIncrement(int n){
		int input = n;
		int increment = 4;
		int current = 4;
		int[] data = new int[input];
		for(int i = 0; i < input; i++){
			if(i < 2){
				data[i] = i;
			}else {
				increment++;
				data[i] = current;
				current = current + increment - 1;
				
			}
		}
		
		return data;
	}