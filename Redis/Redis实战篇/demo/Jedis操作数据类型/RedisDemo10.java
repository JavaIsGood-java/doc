
import redis.clients.jedis.Jedis;


//��������
public class RedisDemo10{

	public static void main(String[] args){
		//�������ݿ����Ӷ���
		Jedis jedis=new Jedis();
		
		//���������֤
		jedis.auth("123456");

		System.out.println("�򼯺������һ������Ԫ�أ�"+jedis.sadd("myset","d","r"));

		System.out.println("��������ĳ��Ԫ���ƶ�����һ�������У�"+jedis.smove("myset","myset1","d"));

		System.out.println("��һ���������ϵ�����Ԫ�غϲ����������һ���µļ��ϣ�"+jedis.sunionstore("aidset","myset1","myset2"));

		System.out.println("�ж�ĳ��Ԫ���Ƿ��ڼ����У�"+jedis.sismember("myset","a"));

		System.out.println("��ȡ������Ԫ�ص�������"+jedis.scard("myset"));

		System.out.println("��ȡ���������е�Ԫ�أ�"+jedis.smembers("myset"));

		System.out.println("�����ȡ������һ����ָ��������Ԫ�أ�"+jedis.srandmember("myset",1));

		System.out.println("��ȡһ���������ϵĲ�������������ظ�Ԫ�أ���"+jedis.sunion("myset1","myset2","myset3"));

		System.out.println("��ȡĳ������������һ���������ϵĲ��"+jedis.sdiff("myset","set1","set2","set3"));

		System.out.println("��һ���������ϵĲ����Ϊһ���µļ��ϣ�"+jedis.sdiffstore("newset","myset1","mset2","mysetn"));

		System.out.println("��ȡһ���������ϵĽ�������ͬ��Ԫ�أ���"+jedis.sinter("set1","set2","setn"));

		System.out.println("��һ���������ϵĽ�������Ϊһ���µļ��ϣ�"+jedis.sinterstore("newset","s1","s2","sn"));

		System.out.println("���ɾ��������һ����ָ��������Ԫ�أ�"+jedis.spop("myset",2));

		System.out.println("ɾ��������ָ����һ������Ԫ�أ�"+jedis.srem("a","b","c"));

	}
}