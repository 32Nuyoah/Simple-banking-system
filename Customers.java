package internship;
/*
 * 这是一个Customers类，用于处理普通用户模式的操作
 * @author 网络s1801-郭子云-1811660103
 */
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Customers {
	private Scanner input = new Scanner(System.in);
    User user;						//实例化对象
    DBUtil dbUtil = new DBUtil();
    private String cardId,cardPwd;

    public Customers(User user,DBUtil dbUtil){	//创建构造方法
        this.user = user;
        this.dbUtil = dbUtil;
    }
    public void initCustomers(){		//用户登陆
        int key3;
        while (true){
        	System.out.println("欢迎进入用户模式");
            System.out.print("请输入银行卡号：");
            cardId = input.next();
            System.out.print("请输入银行卡密码：");
            cardPwd = input.next();
            if (checkPwd(cardId,cardPwd)){	//检查用户密码是否正确
            	System.out.println("登录成功！");
            	while (true){
            		user = (User) dbUtil.getUsers().get(cardId);	//调用集合中指定用户数据
            		System.out.println("请选择您的业务：");
            		enterCustomers();
            		key3 = input.nextInt();
            		switch (key3){
                        case 1:					//存款
                        	deposit(user);
                        	break;
                        case 2:
                        	withdrawal(user);	//取款
                        	break;
                        case 3:
                        	balance(user);		//查询余额
                        	break;
                        case 0:
                        	break;
                        default: System.out.println("选择业务异常，请重新选择");
                        	break;
            		}
            		if (key3== 0) break;		//退出用户模式
            	}
            	break;
            } else {
            	System.out.println("银行卡号或密码错误，请重新输入！");	//账号或密码错误报错
            }            	
        }
    }

    public void deposit(User user){	//存款界面
        double temp1,temp2;
        String select = "n";
        System.out.println("当前处于：银行管理系统>用户模式>存款");
        do {
            System.out.print("请输入存款的金额：");
            temp1 = input.nextDouble();
            if (temp1>0){		//存款金额需大于0
                temp2 = user.getAccount();
                temp2 += temp1;
                user.setAccount(temp2);	//写入账户余额
                System.out.println("存款成功！");
                System.out.println("您当前的余额是："+user.getAccount()); //及时显示账户存款后余额
                System.out.println("继续存款，请输入'y',返回上级菜单,请输入'n'");
                select = input.next();
            }else {
                System.out.println("输入错误，请重新输入！");	//存款金额不符规则报错
            }
        } while (select.equals("y"));	//继续存款

    }

    public void withdrawal(User user){	//取款界面
        double temp1,temp2;
        String select = "n";
        System.out.println("当前处于：银行管理系统>用户模式>取款");
        do {
            System.out.print("请输入取款的金额：");
            temp1 = input.nextDouble();
            if (temp1<=user.getAccount() && temp1>0){	//取款金额需小于余额且大于0
                temp2 = user.getAccount();	//调用账户余额
                temp2 -= temp1;
                user.setAccount(temp2);		//写入账户余额
                System.out.println("取款成功！");
                System.out.println("您当前的余额是："+user.getAccount());		//及时显示取款后账户余额
                System.out.println("继续取款，请输入'y',返回上级菜单,请输入'n'");
                select = input.next();
            }
            else if (temp1<=0){
                System.out.println("输入错误，请重新输入!");	//取款金额小于0报错
            }
            else {
                System.out.println("余额不足，取款失败！");	//取款金额大于余额报错
            }
        } while (select.equals("y"));

    }

    public void balance(User user){	//查询余额
        String select = "n";
        System.out.println("当前处于：银行管理系统>用户模式>余额查询");
        System.out.println("您当前的余额是："+user.getAccount());	//调用余额
        System.out.println("返回上级菜单,请输入'n'");
        select = input.next();
    }

    public boolean checkPwd(String cardId,String cardPwd){	//检查所输账号密码是否与集合中所存数据一致
        boolean flag = false;
        Iterator iterator = dbUtil.getUsers().entrySet().iterator();
        while(iterator.hasNext()){	//遍历集合中账号密码
            Map.Entry<String,User> entry = (Map.Entry<String,User>) iterator.next();
            if (cardId.equals(entry.getKey())){	//比较账号
                if (cardPwd.equals(entry.getValue().getCardPwd())){	//比较密码
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void enterCustomers(){	//用户界面
        System.out.println("******************************");
        System.out.println("	1.存款	2.取款");
        System.out.println("	3.余额查询	0.退出");
        System.out.println("******************************");
        System.out.print("请选择：");
    }
}
