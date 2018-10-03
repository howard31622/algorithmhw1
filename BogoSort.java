import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class BogoSort{
	public long time1, time2;
	static int countilength = 0 ;
	static String message = "";
	static String input = "";
	
	public BogoSort(int[] i) {
		countilength = i.length;
		int [] j = new int[countilength];
//		System.out.println("countilength = "+countilength);
		
		time1 = System.currentTimeMillis();
		int counter = 0;
		int countertest = 0;
		
		

		shuffle(i);
		//註解 31 34 43 44 45 46 就可以跑bogo sort
		shufflej(i,j);

			//判斷在n-1長度中n2是>n1若沒有則重排
			while(!isBiger(i,j)) {
				//判斷n1有沒有按照順序排列，若沒有拋牌重排
				while(!isSorted(i)) {
				//shuffle(i);
					shuffle(i);
					counter++;

				}
				
				shufflej(i,j);
				countertest++;
			}
			
		System.out.println("I'll sort " + i.length + " elements...");
		
		
		System.out.println("Solution found! (shuffled " + counter + " times)");
		print(i);
		print(j);
		System.out.println("Solution found! (shuffled " + countertest + " times)");

		
		
		time2 = System.currentTimeMillis();
		System.out.println("總共花了：" + (time2-time1)+ "毫秒");
		message = message + " n1陣列 : ";
		for(int x : i) { 
			message = message + x + " " ;
			
		}
		message = message + "\n";
		message = message + " n2陣列 : ";
		for(int x : j) { 
			message = message + x + " " ;
			
		}
		message = message + "\n";
		message = message + "總共花了：" + (time2-time1)+ "毫秒";
		
		
	}
	//只用來顯示
	private void print(int[] i) {
		for(int x : i) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	//n2用的洗牌function
	private void shufflej(int[] i ,int[] j) {
		int [] temp = new int[countilength] ;
		for (int x = 0;x<temp.length;++x) {
			temp[x] = x;
		}
//		System.out.println("print temp");
//		print(temp);
		for(int x = 0; x < i.length; x++) {
			int changenumber = (int)(Math.random() * i.length);
//			System.out.println(temp[changenumber]);
			while(temp[changenumber] == -1) { 
//				System.out.println(changenumber);
				changenumber = (int)(Math.random() * i.length);
			}
			j[x] = i[changenumber];
			temp[changenumber]=-1;
		}
//		print(j);
//		print(i);
//		System.out.println("correct");
		
//		for(int x = 0; x < i.length; ++x) {
//			int index1 = (int) (Math.random() * i.length),
//				index2 = (int) (Math.random() * i.length);
//			int a = j[index1];
//			j[index1] = j[index2];
//			j[index2] = a;
//		}
	}
	//n1用的洗牌function
	private void shuffle(int[] i) {
		for(int x = 0; x < i.length; ++x) {
			int index1 = (int) (Math.random() * i.length),
				index2 = (int) (Math.random() * i.length);
			int a = i[index1];
			i[index1] = i[index2];
			i[index2] = a;
		}
	}
	//判斷n-1長度中每個數n2有沒有大於的n1之function
	private boolean isBiger(int[] i ,int[] j) {
		for(int y = 0; y<j.length-1;y++) {
//			System.out.println("y = "+ y);
			if(i[y]>j[y]) {return false;}
			else if(i[y] == j[y]) {return false;}
		}
		
		return true;
	}
	//判斷有沒有按照順序排列的function
	private boolean isSorted(int[] i) {
		for(int x = 0; x < i.length - 1; ++x) {
			if(i[x] > i[x+1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		
// 		int n = 0; //要輸入n個數
//		
// 		Scanner scanner = new Scanner(System.in);
// 		System.out.println("請輸入要幾個數字：");
// 		n = scanner.nextInt();
// 		int [] i;
// 		i = new int [n] ;
// 		System.out.println("請輸入" + n +"字(以空白鍵分開)：");
// 		for (int x = 1;x <= n ; x++) {
// 			i[x-1] = scanner.nextInt();
// //			System.out.println(i[x-1]);/
// 		}
//		int [] i = lovationText;
		
		//gui介面
		int gap = 10;
		JFrame f = new JFrame("algohw1");
		f.setSize(410, 400);
		f.setLocation(200, 200);
		f.setLayout(null);
		
		JPanel pInput = new JPanel();
		pInput.setBounds(gap, gap, 375, 120);
		pInput.setLayout(new GridLayout(4,3,gap,gap));
		
		 
		
		
		JLabel location = new JLabel("請輸入n字(以空白鍵分開)：");
		JTextField locationText = new JTextField();
		

		JButton b = new JButton("確定");
		
		pInput.add(location);
		pInput.add(locationText);
		
		
		JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        b.setBounds(150, 120 + 30, 80, 30);
        ta.setBounds(gap, 150 + 60, 375, 120);
        
		
		
		f.add(pInput);
		f.add(b);
        f.add(ta);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  
	    f.setVisible(true);
		//點擊監測
	    b.addActionListener(new ActionListener(){
	    	boolean checkedpass = true;
	    	public void actionPerformed(ActionEvent e){
	    		checkedpass = true;
	    		checkEmpty(locationText,"");
				
				
				input = locationText.getText();
				
				
				if(checkedpass){
					message = "";
					System.out.println("input  " + input);
					String[] i1 = input.split(" ");
					int [] i = new int[i1.length];
					for (int x = 0; x < i1.length; x++)
						i[x] = Integer.parseInt(i1[x]);
					
					
					
					
					new BogoSort(i);
					String model = "%s";
					String result= String.format(model,message);
					ta.setText("");
			        ta.append(result);
			        
				}
					
	    	}
	    	
	    	//檢查是否為空
	    	private void checkEmpty(JTextField tf, String msg){
	    		if(!checkedpass)
	    			return;
	    		String value = tf.getText();
	    		if(value.length()==0){
	    			JOptionPane.showMessageDialog(f, msg + " 不能為空");
	    			tf.grabFocus();
	    			checkedpass = false;
	    		}
	    	}
	    	
	    		
	    	
	    });
	   
		
		
	}

}