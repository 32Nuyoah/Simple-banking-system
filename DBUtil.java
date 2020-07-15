package internship;
/*
 * ����һ��DBUtil�࣬��������ģ������ϵͳ�е��˻�����Ϣ���൱�����ݿ�Ĺ��ܡ�
 * @author ����s1801-������-1811660103
 */
import java.util.HashMap;
import java.util.Iterator;

public class DBUtil {
	 HashMap<String,User> map = new HashMap<String, User>();		//����HashMap����
	    public DBUtil(){							//�ղι��캯��

	    }
	    
	    public HashMap<String, User> getUsers(){	//��ȡmap����
	        return map;
	    }

	    public DBUtil(String cardId, User user){	//�������˻�����д�뼯��
	        map.put(cardId,user);
	    }

	    public void addUser(String cardId,User user){	//����˻����󵽼�����
	        map.put(cardId,user);
	    }
	    
	    public void getAllUsers(){					//��ѯ�����˻�
	        Iterator<String> iterator = map.keySet().iterator();	//����map�м��ļ���
	        System.out.println("************************************�û��б�****************************************");
	        while (iterator.hasNext()){
	            Object key = iterator.next();
	            User value_all = map.get(key);
	            String format = "���п��ţ�%-8s���п����룺%-8s�˻�����%-8s�绰���룺%-8s�˻���%-8f\n";		//������ʽ�����ַ����Լ����Ӷ���ַ�������
	            System.out.printf(format,value_all.getCardId(),value_all.getCardPwd(),			//��ӡ���
	            		value_all.getUserName(),value_all.getCall(),value_all.getAccount());
	        }
	    }

	    public void getSingleUser(Object key){		//��ѯָ���˻�
	        User value_single = map.get(key);		//��ȡָ��������Ӧ�ĵ��˻�����
	        System.out.println("*******�û���Ϣ*******");
	        System.out.println("���п��ţ�"+key);
	        System.out.println("���п����룺"+value_single.getCardPwd());
	        System.out.println("�˻�����"+value_single.getUserName());
	        System.out.println("�绰���룺"+value_single.getCall());
	        System.out.println("�˻���"+value_single.getAccount());
	        System.out.println("*********************");
	    }

	    public void delete(Object key){				//ɾ��ָ���˻�
	        map.remove(key);						
	    }

}
