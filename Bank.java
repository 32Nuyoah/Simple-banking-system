package internship;
/*
 * ����һ��Bank�࣬���ڴ����������е��û���¼
 * @author ����s1801-������-1811660103
 */
import java.util.Scanner;

public class Bank {
	 Scanner input = new Scanner(System.in);
	    User user;							//ʵ��������
	    DBUtil dbUtil = new DBUtil();

	    public Bank(){						//����ϵͳ���
	        start();
	    }

	    public void start(){				//�û�ģʽѡ����
	        Root root = new Root(user,dbUtil);
	        Customers customers = new Customers(user,dbUtil);
	        int key2;
	        while (true){
	            enterBank();
	            key2 = input.nextInt();
	            if (key2 == 1){
	            	customers .initCustomers();		//������ͨ�û�ģʽ
	            }
	            else if (key2 == 2) {
	                root.initRoot();				//�������Աģʽ
	            }
	            else if (key2 == 0) {
	                System.out.println("\n��л����ʹ�ã��ټ���");
	                break;
	            }
	        } 
	    }

	    public void enterBank(){				//����ϵͳ��ڽ���
	        System.out.println("���ѽ���GZY���й���ϵͳ����ѡ��Ҫ�����ģʽ��");
	        System.out.println("-------------------------");
	        System.out.println("	1.�û�ģʽ");
	        System.out.println("	2.����Աģʽ");
	        System.out.println("	0.�˳�ϵͳ");
	        System.out.println("-------------------------");
	        System.out.print("��ѡ��");
	    }
 
}

