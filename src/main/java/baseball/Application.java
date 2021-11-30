package baseball;


import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
	
	static int ball = 0, strike = 0; 
	

    public static void main(String[] args) {
    	int trigger = 1;
    	while(trigger == 1) {
    		if(trigger == 1) {
        		//������
        		gameStart();
        		trigger= result.Reset();
        		
        	}
    		if(trigger ==2) {
        		//��������
        		System.out.println("���� ����");
        	}
//    		else {
//    			throw new IllegalArgumentException("�߸��� �Է°� �Դϴ�.");
//    		}
    	}
    		
    }
    
    
    //���� ��ŸƮ
    static void gameStart() {
    	ball = 0; strike = 0;
    	String n = RandomNumber.threeNum();
    	System.out.println(n);
    
    	//����� �Է�
    	while (strike !=3) {
    		ball=0; strike=0;
	    	String g = GuessNumber.input();
	    	
	    	for(int i = 0; i < 3; i ++) {
	    		countBall(n,g,i);
	    		countStrike(n,g,i);
	    	}
	    	//�������ϱ� 
	    	result.output(ball, strike);
    	}	
    	
    }
    
 
    //�� ī��Ʈ
    static void countBall(String n ,String g, int idx) {	
    	if(n.charAt(idx)!=g.charAt(idx) && g.contains(Character.toString(n.charAt(idx)))){
    		ball++;
    	}
    }
   
    //��Ʈ����ũ ī��Ʈ
    static void countStrike(String n ,String g, int idx) {	
    	if(n.charAt(idx)==g.charAt(idx)){
    		strike++;
    	}
    }
    
  
}
 



class RandomNumber{
    	//��ǻ�Ͱ� 3�ڸ� �����
    	static final int[] n =new int[3];
    	static final int startNum = 1;
    	static final int endNum = 9;
    	static final int cnt = 0;
    	
    	static String threeNum() {
    		 //�ߺ�������
        	Set<Integer> set = new HashSet<>();
       	
        	while(set.size() <3) {
	    		set.add(Randoms.pickNumberInRange(startNum, endNum));
        	}
        	
        	StringBuilder strB = new StringBuilder();
        	set.forEach(strB::append);
        	//���ڿ��� ����
        	return strB.toString(); 
    }
}



class GuessNumber{
	
	static String input() {
	System.out.print("���ڸ� �Է����ּ��� :");
	String read = Console.readLine();
		if(read.length() !=3) {
	        throw new IllegalArgumentException("�߸��� �Է°� �Դϴ�.");
		}
	return read;
	}
}




class result{
	static void output(int ball, int strike) {
		if(ball != 0 ) {
	    	System.out.print(ball + "��");
	    	if(strike == 0){
	    		System.out.println();}
		}
		if(strike != 0) {
	    	System.out.println(strike + "��Ʈ����ũ");  	

		}
		if(ball==0 && strike==0 ) {
	    	System.out.println("����");  	
		}
		if(strike == 3) { 	
	    	System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");  
		}
	}
	static int Reset() {
		System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		String goStop = Console.readLine();
		return Integer.valueOf(goStop);
	}
}
//�� �׽�Ʈ
  
