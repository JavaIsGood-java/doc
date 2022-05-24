
import redis.clients.jedis.Jedis;


//操作集合
public class RedisDemo10{

	public static void main(String[] args){
		//创建数据库连接对象
		Jedis jedis=new Jedis();
		
		//进行身份验证
		jedis.auth("123456");

		System.out.println("向集合中添加一个或多个元素："+jedis.sadd("myset","d","r"));

		System.out.println("将集合中某个元素移动到另一个集合中："+jedis.smove("myset","myset1","d"));

		System.out.println("将一个或多个集合的所有元素合并起来，组成一个新的集合："+jedis.sunionstore("aidset","myset1","myset2"));

		System.out.println("判断某个元素是否在集合中："+jedis.sismember("myset","a"));

		System.out.println("获取集合中元素的数量："+jedis.scard("myset"));

		System.out.println("获取集合中所有的元素："+jedis.smembers("myset"));

		System.out.println("随机获取集合中一个或指定个数个元素："+jedis.srandmember("myset",1));

		System.out.println("获取一个或多个集合的并集（不会存在重复元素）："+jedis.sunion("myset1","myset2","myset3"));

		System.out.println("获取某个集合与其他一个或多个集合的差集："+jedis.sdiff("myset","set1","set2","set3"));

		System.out.println("将一个或多个集合的差集保存为一个新的集合："+jedis.sdiffstore("newset","myset1","mset2","mysetn"));

		System.out.println("获取一个或多个集合的交集（相同的元素）："+jedis.sinter("set1","set2","setn"));

		System.out.println("将一个或多个集合的交集保存为一个新的集合："+jedis.sinterstore("newset","s1","s2","sn"));

		System.out.println("随机删除集合中一个或指定个数个元素："+jedis.spop("myset",2));

		System.out.println("删除集合中指定的一个或多个元素："+jedis.srem("a","b","c"));

	}
}