package internship;
/*
 * 这是一个User类，用于定义账户对象
 * @author 网络s1801-郭子云-1811660103
 */
public class User {
	public String cardId;			//银行卡号
	public String cardPwd;			//银行卡密码
	public String userName;			//账户名
	public String call;				//手机号码
	public double account;			//存款额
	 
	public String getCardId() {					//获取银行卡号
		return cardId;
	}
 
 
	public void setCardId(String cardId) {		//写入银行卡号
		this.cardId = cardId;
	}
 
 
	public String getCardPwd() {				//获取银行卡密码
		return cardPwd;
	}
 
 
	public void setCardPwd(String cardPwd) {	//写入银行卡密码
		this.cardPwd = cardPwd;
	}
 

	public String getUserName() {				//获取账户名
		return userName;
	}
 
 
	public void setUserName(String userName) {	//写入账户名
		this. userName =  userName;
	}
 
 
	public String getCall() {					//获取电话号码
		return call;
	}
 
 
	public void setCall(String call) {			//写入电话号码
		this.call = call;
	}
	
	
	public double getAccount(){					//获取存款额
		return account;
	}
	
	public void setAccount(double account){		//写入存款额
		this.account=account;
	}
	
	public User(String cardId,String cardPwd,String userName,String call,double account){		//写入整个账户对象
        setCardId(cardId);
        setCardPwd(cardPwd);
        setUserName(userName);
        setCall(call);
        setAccount(account);
    }
}