import redis.clients.jedis.Jedis;



//操作List
public class RedisDemo09{

	public static void main(String[] args){
		//得到数据库连接对象
		Jedis jedis=new Jedis();

		//如果Redis服务器设置了密码，需要进行身份验证
		jedis.auth("123456");

		System.out.println("在列表头部插入一个或若干个值："+jedis.lpush("list1","a","b"));

		System.out.println("在列表尾部插入一个或若干个值："+jedis.rpush("list1","c","d"));

		System.out.println("在列表指定元素的前面或后面插入一个值："+jedis.linsert("list1","after","b","c"));

		System.out.println("在列表头部插入一个值（前提是列表已存在）:"+jedis.lpushx("list1","a"));
	
		System.out.println("在列表尾部插入一个值（前提是列表已存在）:"+jedis.rpushx("list1","z"));

		System.out.println("修改指定下标的值："+jedis.lset("list1",0,"k"));

		System.out.println("获取列表的长度（元素的个数）:"+jedis.llen("list1"));

		System.out.println("获取列表指定下标的值："+jedis.lindex("list1",0));

		System.out.println("获取列表指定范围内的值（0~-1表示获取全部）："+jedis.lrange("list1",0,-1));

		System.out.println("删除列表的头部元素并得到它的值："+jedis.lpop("list1"));

		System.out.println("删除列表的尾部元素并得到它的值："+jedis.rpop("list1"));

		System.out.println("在指定的时间内删除一个或多个列表的头部元素（单位为秒）："+jedis.blpop(10,"list1","list2"));

		System.out.println("在指定的时间内删除一个或多个列表的尾部元素（单位为秒）："+jedis.brpop(10,"list1","list2"));

		System.out.println("删除列表中与指定值相同的值，并指定删除的数量（0表示删除全部）："+jedis.lrem("list1",0,"a"));

		System.out.println("删除列表中指定范围外的值（保留指定范围内的值）："+jedis.ltrim("list1",0,1));

		System.out.println("将列表头部元素移动到另一个列表的尾部："+jedis.rpoplpush("list1","list2"));
	}
}