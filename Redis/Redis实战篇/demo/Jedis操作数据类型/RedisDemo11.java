import java.util.Map;
import java.util.HashMap;

import redis.clients.jedis.Jedis;

//操作有序集合
public class RedisDemo11{
	public static void main(String[] args){

		//创建数据对象
		Jedis jedis = new Jedis("127.0.0.1",6379);

		//进行身份验证
		jedis.auth("123456");

		System.out.println("向有序集合中添加元素："+jedis.zadd("mysset",3.2,"d"));

		Map<String,Double> map = new HashMap<String,Double>();
		map.put("kd",8.2);
		map.put("k",2.1);
		System.out.println("向有序集合中添加多个元素："+jedis.zadd("mysset",map));

		System.out.println("将有序集合中元素对应的小数值进行增量操作（增量可正可负）:"+jedis.zincrby("mysset",1.5,"d"));

		System.out.println("获取有序集合中元素的数量："+jedis.zcard("mysset"));

		System.out.println("获取有序集合中小数值在指定区间的元素的数量："+jedis.zcount("mysset",1.0,10));

		System.out.println("获取有序集合中在指定区间的元素数量："+jedis.zlexcount("mysset","[a","[z"));

		System.out.println("获取有序集合指定下标范围内的值（包括）,并进行升序排序："+jedis.zrange("mysset",0,-1));

		System.out.println("获取有序集合指定下标范围内的值（包括），并进行降序排序："+jedis.zrevrange("mysset",0,-1));

		System.out.println("获取有序集合中指定元素对应的小数："+jedis.zscore("mysset","d"));

		System.out.println("获取有序集合中在指定区间内的元素："+jedis.zrangeByLex("mysset","[a","[z"));

		System.out.println("获取有序集合中在指定分数区间的元素，并进行升序排序："+jedis.zrangeByScore("mysset","0","100"));

		System.out.println("获取有序集合中在指定分数区间的元素，并进行降序排序："+jedis.zrevrangeByScore("mysset","0","10"));

		System.out.println("获取指定元素的排名（按照小数值从小到大排序）："+jedis.zrank("mysset","d"));

		System.out.println("获取指定元素的排名（按照小数值从大到小排序）："+jedis.zrevrank("mysset","d"));

		//System.out.println("将一个或多个有序集合的交集复制出来保存到另一个有序集合中："+jedis.zinterStore("newsset",2,"mysset","mysett1"));

		//System.out.println("将一个或多个有序集合的并集复制出来保存到另一个有序集合中："+jedis.zunionStore("newsset",2,"mysset","mysset1"));

		System.out.println("删除有序集合中指定的一个或多个元素："+jedis.zrem("mysset","a","b"));

		System.out.println("删除有序集合中在指定区间的元素："+jedis.zremrangeByLex("mysset","[aa","[bb"));

		System.out.println("删除有序集合中在指定排名区间内（包括）的元素："+jedis.zremrangeByRank("mysset",2,10));

		System.out.println("删除有序集合中在指定小数区间内（包括）的元素："+jedis.zremrangeByScore("mysset",20.3,36.1));
	}
}