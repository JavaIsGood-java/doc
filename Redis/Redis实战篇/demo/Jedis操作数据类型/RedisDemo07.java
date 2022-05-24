import redis.clients.jedis.Jedis;

//����String
public class RedisDemo07{
	public static void main(String[] args){

		//ȡ�����ݿ����Ӷ���
		Jedis jedis = new Jedis("127.0.0.1",6379);

		//Redis���������������룬������Ҫ���������֤
		jedis.auth("123456");

		System.out.println("���ü�ֵ�ԣ�"+jedis.set("name","zhangsan"));
		
		System.out.println("���ö����ֵ�ԣ�"+jedis.mset("age","20","sex","��"));

		System.out.println("���ò����ڵļ�ֵ�ԣ�"+jedis.setnx("name","lisi"));

		System.out.println("���ö������ļ�ֵ�ԣ�"+jedis.msetnx("age","21","sex","��"));
		
		System.out.println("��ȡĳ������ֵ��"+jedis.get("name"));

		System.out.println("��ȡ�������ֵ��"+jedis.mget("name","age","sex"));

		System.out.println("��ȡĳ�����Ĳ���ֵ��"+jedis.getrange("name",0,4));

		System.out.println("�޸�ĳ�����Ĳ���ֵ��"+jedis.setrange("name",0,"lisi"));

		System.out.println("�޸�ĳ������ֵ,�����ؾ�ֵ��"+jedis.getSet("name","wangwu"));

		System.out.println("��ĳ������ֵ����׷�ӣ�"+jedis.append("name","1"));

		System.out.println("ͳ�Ƽ���ֵ�ĳ��ȣ�"+jedis.strlen("name"));
	
		System.out.println("������"+jedis.incr("index"));

		System.out.println("����������"+jedis.incrBy("index",2));

		System.out.println("�Լ���"+jedis.decr("index"));

		System.out.println("����������"+jedis.decrBy("index",10));

		System.out.println("����������������"+jedis.incrByFloat("index",2.1));
	}
}