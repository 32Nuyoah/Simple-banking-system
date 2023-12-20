package internship;
/*
 * 这是一个Root类，用于处理管理员模式的操作
 * @author 
 */
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Root {
	private Scanner input = new Scanner(System.in);		//私有化input
    User user;									//实例化
    DBUtil dbUtil = new DBUtil();
    final String rootName = "root";				//管理员账户
    final String passWd = "root";				//管理员密码
    private String inputPassWd,inputRootName;	//私有化inputPassWd inputRootName

    public Root(User user,DBUtil dbUtil){			//创建构造方法
        this.user = user;
        this.dbUtil = dbUtil;
    }

    public void initRoot(){				//管理员登陆
        int key;
        System.out.println("欢迎进入管理员模式");
        while (true) {
            System.out.print("请输入管理员账号：");
            inputRootName = input.next();
            System.out.print("请输入账号密码：");
            inputPassWd = input.next();
            if (checkPwd(inputRootName, inputPassWd)) {		//检查账号密码是否输入正确
                System.out.println("登录成功！");
                while (true) {
                    enterRoot();				//进入管理员界面
                    key = input.nextInt();
                    switch (key) {
                        case 1:					//添加用户
                            createUser();
                            break;
                        case 2:					//删除用户
                            deleteUser();
                            break;
                        case 3:
                            searchUser();		//查询用户
                            break;
                        case 0:
                        	break;
                        default: System.out.println("选择业务异常，请重新选择");	//输出其它选项提示错误信息
                    		break;
                    }
                    if (key == 0) break;		//退出管理员界面
                }
                break;
            } else {
                System.out.println("账号或密码错误，请重新输入！");
            }
        }
    }

    public void enterRoot(){			//管理员界面
        System.out.println("****************************************");
        System.out.println("	1.添加用户		2.删除用户");
        System.out.println("	3.查询用户		0.退出");
        System.out.println("****************************************");
        System.out.print("请选择：");
    }

    public void createUser(){			//添加用户
        String answer = "n";
        System.out.println("\n当前处于：银行管理系统>管理员模式>添加用户\n");
        do {
            System.out.println("请设置账户卡号(9位数字):");//设置账户卡号
            String cardId = input.next();
            String reges ="[0-9]{9}";				//正则表达式规则
            if(!cardId.matches(reges)) {			//如果不符合要求则报错
				System.out.println("卡号不符合规范!!");
				System.out.println("创建账户失败，返回管理员界面!!");
				break;
			} 
            System.out.println("请设置账户卡密码(6位数字)：");//设置账户密码
            String cardPwd = input.next();
            reges ="[0-9]{6}";						//正则表达式规则
            System.out.println("请再次确认您的密码");
            String cardPwd1 = input.next();
            while (!cardPwd1.equals(cardPwd)) {		//比较两次输入密码是否一致
                System.out.println("对不起，两次输入的密码不一致，请重新输入");
                System.out.println("请重新输入您的密码");
                cardPwd = input.next();
                System.out.println("请再次确认您的密码");
                cardPwd1 = input.next();
            }
            if(!cardPwd.matches(reges)) {			//如果不符合要求则报错
				System.out.println("密码不符合规范!!");
				System.out.println("创建账户失败，返回管理员界面!!");
				break;
			}
            System.out.println("请设置账户名：");	//设置账户名	
            String userName = input.next();
            System.out.println("请设置手机号码：");	//设置手机号码
            String call = input.next();
            System.out.println("请设置存款金额：");	//设置初始存款额
            double account = input.nextDouble();
            user = new User(cardId,cardPwd,userName,call,account); //账户对象赋值
            dbUtil.addUser(user.getCardId(), user);//将账户对象写入集合
            System.out.println("用户"+user.getUserName()+"创建成功，余额为"+user.getAccount()+"\n输入'y'继续创建，或输入'n'返回上一级");
            answer = input.next();
        } while (answer.equals("y"));

    }

    public void deleteUser(){		//删除账户
        String answer = "n";
        System.out.println("\n当前处于：银行管理系统>管理员模式>删除用户");
        do {
            System.out.println("请输入要删除用户的银行卡号");
            String key1 = input.next();
            if(checkKey(key1)) {			//如果集合中包含所user对象,则移除对象
            	dbUtil.delete(key1);
                System.out.println("用户已删除，当前用户列表如下\n");
                dbUtil.getAllUsers();
                System.out.println("输入'y'继续删除，或输入'n'返回上一级");
                answer = input.next();
            	
    		}
            else {							//如果不包含则打印语句
    			System.out.print("删除失败，没有找到该用户\n");
    		}
        } while (answer.equals("y"));

    }

    public void searchUser(){	//查询账户
        String answer = "n";
        int choice;
        System.out.println("\n当前处于：银行管理系统>管理员模式>查询用户\n");
        do {
        System.out.println("******************************************");
        System.out.println("	1.查询单个用户\t2.查看所有用户");
        System.out.println("******************************************");
        choice = input.nextInt();
        if (choice==1) {		//查询单个账户
            System.out.println("请输入要查询用户的银行卡号");
            String key3 = input.next();
            dbUtil.getSingleUser(key3);
        }
        else if (choice == 2){	//查询所有账户
            dbUtil.getAllUsers();
        }
        System.out.println("查询完成，输入'y'继续查询，或输入'n'返回上一级");
        answer = input.next();
        }while (answer.equals("y"));
    }

    public boolean checkPwd(String inputRootName,String inputPassWd){	//比较管理员账号密码是否输入正确
        boolean flag = false;
        if (inputRootName.equals(rootName)){
            if (inputPassWd.equals(passWd)){
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean checkKey(String key2) {	//检查集合中是否有所键入key
    	boolean flag = false;
    	Iterator iterator = dbUtil.getUsers().entrySet().iterator();	//迭代map中键的集合
    	while(iterator.hasNext()){
    		Map.Entry<String,User> entry = (Map.Entry<String,User>) iterator.next();
    		if (key2.equals(entry.getKey())){
    			 flag = true;
    		}
    	}
    	return flag;
    }
}
