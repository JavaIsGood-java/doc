import java.util.Map;
import java.util.HashMap;

import redis.clients.jedis.Jedis;

//�������򼯺�
public class RedisDemo11{
	public static void main(String[] args){

		//�������ݶ���
		Jedis jedis = new Jedis("127.0.0.1",6379);

		//���������֤
		jedis.auth("123456");

		System.out.println("�����򼯺������Ԫ�أ�"+jedis.zadd("mysset",3.2,"d"));

		Map<String,Double> map = new HashMap<String,Double>();
		map.put("kd",8.2);
		map.put("k",2.1);
		System.out.println("�����򼯺�����Ӷ��Ԫ�أ�"+jedis.zadd("mysset",map));

		System.out.println("�����򼯺���Ԫ�ض�Ӧ��С��ֵ�����������������������ɸ���:"+jedis.zincrby("mysset",1.5,"d"));

		System.out.println("��ȡ���򼯺���Ԫ�ص�������"+jedis.zcard("mysset"));

		System.out.println("��ȡ���򼯺���С��ֵ��ָ�������Ԫ�ص�������"+jedis.zcount("mysset",1.0,10));

		System.out.println("��ȡ���򼯺�����ָ�������Ԫ��������"+jedis.zlexcount("mysset","[a","[z"));

		System.out.println("��ȡ���򼯺�ָ���±귶Χ�ڵ�ֵ��������,��������������"+jedis.zrange("mysset",0,-1));

		System.out.println("��ȡ���򼯺�ָ���±귶Χ�ڵ�ֵ���������������н�������"+jedis.zrevrange("mysset",0,-1));

		System.out.println("��ȡ���򼯺���ָ��Ԫ�ض�Ӧ��С����"+jedis.zscore("mysset","d"));

		System.out.println("��ȡ���򼯺�����ָ�������ڵ�Ԫ�أ�"+jedis.zrangeByLex("mysset","[a","[z"));

		System.out.println("��ȡ���򼯺�����ָ�����������Ԫ�أ���������������"+jedis.zrangeByScore("mysset","0","100"));

		System.out.println("��ȡ���򼯺�����ָ�����������Ԫ�أ������н�������"+jedis.zrevrangeByScore("mysset","0","10"));

		System.out.println("��ȡָ��Ԫ�ص�����������С��ֵ��С�������򣩣�"+jedis.zrank("mysset","d"));

		System.out.println("��ȡָ��Ԫ�ص�����������С��ֵ�Ӵ�С���򣩣�"+jedis.zrevrank("mysset","d"));

		//System.out.println("��һ���������򼯺ϵĽ������Ƴ������浽��һ�����򼯺��У�"+jedis.zinterStore("newsset",2,"mysset","mysett1"));

		//System.out.println("��һ���������򼯺ϵĲ������Ƴ������浽��һ�����򼯺��У�"+jedis.zunionStore("newsset",2,"mysset","mysset1"));

		System.out.println("ɾ�����򼯺���ָ����һ������Ԫ�أ�"+jedis.zrem("mysset","a","b"));

		System.out.println("ɾ�����򼯺�����ָ�������Ԫ�أ�"+jedis.zremrangeByLex("mysset","[aa","[bb"));

		System.out.println("ɾ�����򼯺�����ָ�����������ڣ���������Ԫ�أ�"+jedis.zremrangeByRank("mysset",2,10));

		System.out.println("ɾ�����򼯺�����ָ��С�������ڣ���������Ԫ�أ�"+jedis.zremrangeByScore("mysset",20.3,36.1));
	}
}