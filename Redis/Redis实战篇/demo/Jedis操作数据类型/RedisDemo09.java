import redis.clients.jedis.Jedis;



//����List
public class RedisDemo09{

	public static void main(String[] args){
		//�õ����ݿ����Ӷ���
		Jedis jedis=new Jedis();

		//���Redis���������������룬��Ҫ���������֤
		jedis.auth("123456");

		System.out.println("���б�ͷ������һ�������ɸ�ֵ��"+jedis.lpush("list1","a","b"));

		System.out.println("���б�β������һ�������ɸ�ֵ��"+jedis.rpush("list1","c","d"));

		System.out.println("���б�ָ��Ԫ�ص�ǰ���������һ��ֵ��"+jedis.linsert("list1","after","b","c"));

		System.out.println("���б�ͷ������һ��ֵ��ǰ�����б��Ѵ��ڣ�:"+jedis.lpushx("list1","a"));
	
		System.out.println("���б�β������һ��ֵ��ǰ�����б��Ѵ��ڣ�:"+jedis.rpushx("list1","z"));

		System.out.println("�޸�ָ���±��ֵ��"+jedis.lset("list1",0,"k"));

		System.out.println("��ȡ�б�ĳ��ȣ�Ԫ�صĸ�����:"+jedis.llen("list1"));

		System.out.println("��ȡ�б�ָ���±��ֵ��"+jedis.lindex("list1",0));

		System.out.println("��ȡ�б�ָ����Χ�ڵ�ֵ��0~-1��ʾ��ȡȫ������"+jedis.lrange("list1",0,-1));

		System.out.println("ɾ���б��ͷ��Ԫ�ز��õ�����ֵ��"+jedis.lpop("list1"));

		System.out.println("ɾ���б��β��Ԫ�ز��õ�����ֵ��"+jedis.rpop("list1"));

		System.out.println("��ָ����ʱ����ɾ��һ�������б��ͷ��Ԫ�أ���λΪ�룩��"+jedis.blpop(10,"list1","list2"));

		System.out.println("��ָ����ʱ����ɾ��һ�������б��β��Ԫ�أ���λΪ�룩��"+jedis.brpop(10,"list1","list2"));

		System.out.println("ɾ���б�����ָ��ֵ��ͬ��ֵ����ָ��ɾ����������0��ʾɾ��ȫ������"+jedis.lrem("list1",0,"a"));

		System.out.println("ɾ���б���ָ����Χ���ֵ������ָ����Χ�ڵ�ֵ����"+jedis.ltrim("list1",0,1));

		System.out.println("���б�ͷ��Ԫ���ƶ�����һ���б��β����"+jedis.rpoplpush("list1","list2"));
	}
}