package internship;
/*
 * ����һ��User�࣬���ڶ����˻�����
 * @author ����s1801-������-1811660103
 */
public class User {
	public String cardId;			//���п���
	public String cardPwd;			//���п�����
	public String userName;			//�˻���
	public String call;				//�ֻ�����
	public double account;			//����
	 
	public String getCardId() {					//��ȡ���п���
		return cardId;
	}
 
 
	public void setCardId(String cardId) {		//д�����п���
		this.cardId = cardId;
	}
 
 
	public String getCardPwd() {				//��ȡ���п�����
		return cardPwd;
	}
 
 
	public void setCardPwd(String cardPwd) {	//д�����п�����
		this.cardPwd = cardPwd;
	}
 

	public String getUserName() {				//��ȡ�˻���
		return userName;
	}
 
 
	public void setUserName(String userName) {	//д���˻���
		this. userName =  userName;
	}
 
 
	public String getCall() {					//��ȡ�绰����
		return call;
	}
 
 
	public void setCall(String call) {			//д��绰����
		this.call = call;
	}
	
	
	public double getAccount(){					//��ȡ����
		return account;
	}
	
	public void setAccount(double account){		//д�����
		this.account=account;
	}
	
	public User(String cardId,String cardPwd,String userName,String call,double account){		//д�������˻�����
        setCardId(cardId);
        setCardPwd(cardPwd);
        setUserName(userName);
        setCall(call);
        setAccount(account);
    }
}