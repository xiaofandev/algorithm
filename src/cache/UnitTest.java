package cache;

public class UnitTest {

    public static void main(String[] args) {
        testNoneExist();
        testExist();
    }

    public static void testNoneExist() {
        // 初始化缓存
        int capacity = 5;
        ArrayLRUCache cache = new ArrayLRUCache(capacity);
        for(int i=0; i<capacity; i++) {
            cache.get(i);
        }
        // 测试一个缓存不存在的用户id
        cache.get(6);
        // 期望结果:6,1,2,3,4
        User[] expectCache = new User[capacity];
        User user6 = new User(6, "6");
        expectCache[0] = user6;

        User user1 = new User(1, "1");
        expectCache[1] = user1;

        User user2 = new User(2, "2");
        expectCache[2] = user2;

        User user3 = new User(3, "3");
        expectCache[3] = user3;

        User user4 = new User(4, "4");
        expectCache[4] = user4;
        System.out.println("测试通过？"+cache.assertEquals(expectCache));
    }

    public static void testExist() {
        // 初始化缓存
        int capacity = 5;
        ArrayLRUCache cache = new ArrayLRUCache(capacity);
        for(int i=0; i<capacity; i++) {
            cache.get(i);
        }
        // 测试一个缓存已存在的用户id
        cache.get(3);
        // 期望结果:3,1,2,4,5
        User[] expectCache = new User[capacity];
        User user3 = new User(3, "3");
        expectCache[0] = user3;

        User user1 = new User(1, "1");
        expectCache[1] = user1;

        User user2 = new User(2, "2");
        expectCache[2] = user2;

        User user4 = new User(4, "4");
        expectCache[3] = user4;

        User user5 = new User(5, "5");
        expectCache[4] = user5;
        System.out.println("测试通过？"+cache.assertEquals(expectCache));

    }
}
