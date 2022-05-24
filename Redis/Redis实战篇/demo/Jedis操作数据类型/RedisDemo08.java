import redis.clients.jedis.Jedis;
import java.util.Map;
import java.util.HashMap;


//操作Hash
public class RedisDemo08{
	public static void main(String[] args){
		//创建数据库连接对象
		Jedis jedis = new Jedis("127.0.0.1",6379);
	
		//Redis服务器设置了密码，所以需要进行身份验证
		jedis.auth("123456");

		System.out.println("设置哈希表的域值："+jedis.hset("student","name","zhangsan"));

		System.out.println("设置哈希表的域值（前提是域不存）:"+jedis.hsetnx("student","name","zhangsan"));

		Map<String,String> map=new HashMap<String,String>();
		map.put("age","20");
		map.put("sex","男");
		System.out.println("设置哈希表的多个域值："+jedis.hmset("student",map));

		System.out.println("获取哈希表某个域的值："+jedis.hget("student","name"));

		System.out.println("获取哈希表所有的域和值："+jedis.hgetAll("student"));

		System.out.println("获取哈希表一个或多个域的值："+jedis.hmget("student","name","age","sex"));

		System.out.println("获取哈希表中所有的域："+jedis.hkeys("student"));

		System.out.println("获取哈希表中所有域的值："+jedis.hvals("student"));

		System.out.println("统计哈希表域的数量："+jedis.hlen("student"));

		System.out.println("统计哈希表域的值的长度："+jedis.hstrlen("student","name"));

		System.out.println("哈希表域的值的加法操作："+jedis.hincrBy("student","age",1));
	
		System.out.println("哈希表域的值的加法操作（浮点型）："+jedis.hincrByFloat("student","age",20));

		System.out.println("判断某个域是否存在："+jedis.hexists("student","name"));

		System.out.println("删除某个域："+jedis.hdel("student","name"));
	}
}