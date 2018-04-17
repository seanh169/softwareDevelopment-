
public class replaceSpaces {
	
	public static char[] replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, x = 0;
		for(int i = 0; i < trueLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if( trueLength < str.length) str[trueLength] = '\0';
		for(int i = trueLength-1; i >= 0; i--) {
			if(str[i]== ' ') {
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index  = index -3;
			}else {
				str[index-1] = str[i];
				index--;
			}
		}
		return str;
	}
	public static void main(String[] args) {
		String s = "H E L L O";
		replaceSpaces n = new replaceSpaces();
		char[] arr = {'h',' ', 'e',' ',' '};
		arr = replaceSpaces(arr,5);
		System.out.println(replaceSpaces(arr,5));
	}
}
