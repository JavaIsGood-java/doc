import redis.clients.jedis.Jedis;

//操作String
public class RedisDemo07{
	public static void main(String[] args){

		//取得数据库连接对象
		Jedis jedis = new Jedis("127.0.0.1",6379);

		//Redis服务器设置了密码，所以需要进行身份验证
		jedis.auth("123456");

		System.out.println("设置键值对："+jedis.set("name","zhangsan"));
		
		System.out.println("设置多个键值对："+jedis.mset("age","20","sex","男"));

		System.out.println("设置不存在的键值对："+jedis.setnx("name","lisi"));

		System.out.println("设置多个不存的键值对："+jedis.msetnx("age","21","sex","男"));
		
		System.out.println("获取某个键的值："+jedis.get("name"));

		System.out.println("获取多个键的值："+jedis.mget("name","age","sex"));

		System.out.println("获取某个键的部分值："+jedis.getrange("name",0,4));

		System.out.println("修改某个键的部分值："+jedis.setrange("name",0,"lisi"));

		System.out.println("修改某个键的值,并返回旧值："+jedis.getSet("name","wangwu"));

		System.out.println("对某个键的值进行追加："+jedis.append("name","1"));

		System.out.println("统计键的值的长度："+jedis.strlen("name"));
	
		System.out.println("自增："+jedis.incr("index"));

		System.out.println("增量操作："+jedis.incrBy("index",2));

		System.out.println("自减："+jedis.decr("index"));

		System.out.println("减量操作："+jedis.decrBy("index",10));

		System.out.println("浮点数增量操作："+jedis.incrByFloat("index",2.1));
	}
}