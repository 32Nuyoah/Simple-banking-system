package internship;
/*
 * 这是一个DBUtil类，该类用于模拟银行系统中的账户人信息，相当于数据库的功能。
 * @author 
 */
import java.util.HashMap;
import java.util.Iterator;

public class DBUtil {
	 HashMap<String,User> map = new HashMap<String, User>();		//创建HashMap集合
	    public DBUtil(){							//空参构造函数

	    }
	    
	    public HashMap<String, User> getUsers(){	//获取map集合
	        return map;
	    }

	    public DBUtil(String cardId, User user){	//将整个账户对象写入集合
	        map.put(cardId,user);
	    }

	    public void addUser(String cardId,User user){	//添加账户对象到集合中
	        map.put(cardId,user);
	    }
	    
	    public void getAllUsers(){					//查询所有账户
	        Iterator<String> iterator = map.keySet().iterator();	//迭代map中键的集合
	        System.out.println("************************************用户列表****************************************");
	        while (iterator.hasNext()){
	            Object key = iterator.next();
	            User value_all = map.get(key);
	            String format = "银行卡号：%-8s银行卡密码：%-8s账户名：%-8s电话号码：%-8s账户余额：%-8f\n";		//创建格式化的字符串以及连接多个字符串对象
	            System.out.printf(format,value_all.getCardId(),value_all.getCardPwd(),			//打印输出
	            		value_all.getUserName(),value_all.getCall(),value_all.getAccount());
	        }
	    }

	    public void getSingleUser(Object key){		//查询指定账户
	        User value_single = map.get(key);		//获取指定键所对应的的账户对象
	        System.out.println("*******用户信息*******");
	        System.out.println("银行卡号："+key);
	        System.out.println("银行卡密码："+value_single.getCardPwd());
	        System.out.println("账户名："+value_single.getUserName());
	        System.out.println("电话号码："+value_single.getCall());
	        System.out.println("账户余额："+value_single.getAccount());
	        System.out.println("*********************");
	    }

	    public void delete(Object key){				//删除指定账户
	        map.remove(key);						
	    }

}
