package test;

public class Test {
	//필드, 메소드, 생성자: level이 없다
	Test(){
		num = 5;
	}
	void service() {
		int sum = 0;
		for(int i=1; i<=10; i++){
			sum += i;
		}
//		a += 5;
		calculate();
		num = 10;
		
		int a = 10;
		a += 5; 
	}
	int calculate() {
		return 0;
	}
	int num;
}
