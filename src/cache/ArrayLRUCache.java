package cache;

/**
 *
 * 描述：用数组实现的LRU（最近最少使用）算法缓存
 * 目前版本：v1.0
 * 版本计划：
 * 	v1.1 缓存中不命中时，只需要对不为null的元素向后移位即可，做法：加入size全局变量，以便获取数组已存元素的个数
 *  v1.2 通过数据层接口获取需要缓存的数据，替代模拟数据
 *  v1.3 User对象替换为接口
 *  v1.4 优化为可扩容
 *  v1.5 性能优化
 */
public class ArrayLRUCache {

    private User[] cache;

    public ArrayLRUCache(int capacity) {
        cache = new User[capacity];
    }

    public User get(Integer userId) {
        User cacheUser = null;
        boolean isExist = checkExist(userId);// O(n)
        if(!isExist) {// 缓存不命中，把所有元素向后移1位
        	move(cache.length-1);// O(n)
            cacheUser = new User(userId, userId+"");
            
        } else {// 缓存中存在，把元素之前的元素向后移1位
        	int cacheIndex = getCacheIndex(userId);// O(n)
        	move(cacheIndex);// O(n)
            cacheUser = cache[cacheIndex];
        }
        cache[0] = cacheUser;
        return cacheUser;
    }
    
    private int getCacheIndex(Integer userId) {
    	int cacheIndex = 0;
        for(int i=0; i<cache.length-1; i++) {
            if(cache[i] != null && cache[i].getId() == userId) {
                cacheIndex = i;
                break;
            }
        }
        return cacheIndex;
    }

    private boolean checkExist(Integer id) {
        for (User item : cache) {
            if (item != null && item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从下标1开始到endIndex，每个元素向后移动1
     * @param endIndex  结束位置
     */
    private void move(int endIndex) {
        for(int i=endIndex; i>0; i--) {
            cache[i] = cache[i--];
        }
    }

    // 仅供单元测试使用
    public boolean assertEquals(User[] expectCache) {
        for(int i=0; i<cache.length-1; i++) {
            if(cache[i]!=null && expectCache!=null
                    && (!cache[i].equals(expectCache[i]))) {
                return false;
            }
        }
        return true;
    }
}
