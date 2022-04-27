package cache;

/**
 *
 * 描述：用数组实现的LRU（最近最少使用）算法缓存
 * 时间复杂度：
 * 空间复杂度：
 *
 */
public class ArrayLRUCache {

    private User[] cache;// TODO 可以优化为接口实现

    public ArrayLRUCache(int capacity) {// TODO 可以优化为自动扩容，也可支持容量上限可配置
        cache = new User[capacity];
    }

    /**
     * 根据用户id从缓存中获取用户信息
     * @param userId 用户id
     * @return
     */
    public User get(Integer userId) {
        User cacheUser = null;
        boolean isExist = checkExist(userId);
        if(!isExist) {// 缓存中不存在，把所有元素都向后移1位
            // v1.0 每个元素向后移动1位
            backwardOne(cache.length-1);
            cacheUser = new User(userId, userId+"");// 此处可以优化为从数据层接口获取数据 TODO
            // v1.1 优化：只需要对不为null的元素移位即可，做法：加入size全局变量，以便获取数组已存元素的个数 TODO
        } else {// 缓存中存在，把元素之前的元素都向后移1位
            int cacheIndex = 0;
            for(int i=0; i<cache.length-1; i++) {
                if(cache[i] != null && cache[i].getId() == userId) {
                    cacheIndex = i;
                    break;
                }
            }
            backwardOne(cacheIndex);
            cacheUser = cache[cacheIndex];
        }
        cache[0] = cacheUser;
        return cacheUser;
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
    private void backwardOne(int endIndex) {
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
