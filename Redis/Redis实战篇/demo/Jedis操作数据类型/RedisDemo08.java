import redis.clients.jedis.Jedis;
import java.util.Map;
import java.util.HashMap;


//����Hash
public class RedisDemo08{
	public static void main(String[] args){
		//�������ݿ����Ӷ���
		Jedis jedis = new Jedis("127.0.0.1",6379);
	
		//Redis���������������룬������Ҫ���������֤
		jedis.auth("123456");

		System.out.println("���ù�ϣ�����ֵ��"+jedis.hset("student","name","zhangsan"));

		System.out.println("���ù�ϣ�����ֵ��ǰ�����򲻴棩:"+jedis.hsetnx("student","name","zhangsan"));

		Map<String,String> map=new HashMap<String,String>();
		map.put("age","20");
		map.put("sex","��");
		System.out.println("���ù�ϣ��Ķ����ֵ��"+jedis.hmset("student",map));

		System.out.println("��ȡ��ϣ��ĳ�����ֵ��"+jedis.hget("student","name"));

		System.out.println("��ȡ��ϣ�����е����ֵ��"+jedis.hgetAll("student"));

		System.out.println("��ȡ��ϣ��һ���������ֵ��"+jedis.hmget("student","name","age","sex"));

		System.out.println("��ȡ��ϣ�������е���"+jedis.hkeys("student"));

		System.out.println("��ȡ��ϣ�����������ֵ��"+jedis.hvals("student"));

		System.out.println("ͳ�ƹ�ϣ�����������"+jedis.hlen("student"));

		System.out.println("ͳ�ƹ�ϣ�����ֵ�ĳ��ȣ�"+jedis.hstrlen("student","name"));

		System.out.println("��ϣ�����ֵ�ļӷ�������"+jedis.hincrBy("student","age",1));
	
		System.out.println("��ϣ�����ֵ�ļӷ������������ͣ���"+jedis.hincrByFloat("student","age",20));

		System.out.println("�ж�ĳ�����Ƿ���ڣ�"+jedis.hexists("student","name"));

		System.out.println("ɾ��ĳ����"+jedis.hdel("student","name"));
	}
}