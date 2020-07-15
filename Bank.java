package internship;
/*
 * 这是一个Bank类，用于处理网上银行的用户登录
 * @author 网络s1801-郭子云-1811660103
 */
import java.util.Scanner;

public class Bank {
	 Scanner input = new Scanner(System.in);
	    User user;							//实例化对象
	    DBUtil dbUtil = new DBUtil();

	    public Bank(){						//银行系统入口
	        start();
	    }

	    public void start(){				//用户模式选择函数
	        Root root = new Root(user,dbUtil);
	        Customers customers = new Customers(user,dbUtil);
	        int key2;
	        while (true){
	            enterBank();
	            key2 = input.nextInt();
	            if (key2 == 1){
	            	customers .initCustomers();		//进入普通用户模式
	            }
	            else if (key2 == 2) {
	                root.initRoot();				//进入管理员模式
	            }
	            else if (key2 == 0) {
	                System.out.println("\n感谢您的使用，再见！");
	                break;
	            }
	        } 
	    }

	    public void enterBank(){				//银行系统入口界面
	        System.out.println("您已进入GZY银行管理系统，请选择要进入的模式：");
	        System.out.println("-------------------------");
	        System.out.println("	1.用户模式");
	        System.out.println("	2.管理员模式");
	        System.out.println("	0.退出系统");
	        System.out.println("-------------------------");
	        System.out.print("请选择：");
	    }
 
}

