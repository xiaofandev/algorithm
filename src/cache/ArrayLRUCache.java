package cache;

public class ArrayLRUCache {

    private User[] cache;

    public ArrayLRUCache(int capacity) {
        cache = new User[capacity];
    }

    public User get(Integer userId) {
        User cacheUser = null;
        boolean hitted = checkHitted(userId);
        if(hitted) {
        	int cacheIndex = getCacheIndex(userId);
        	move(cacheIndex);
            cacheUser = cache[cacheIndex];
        } else {
        	move(cache.length-1);
            cacheUser = new User(userId, userId+"");
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

    private boolean checkHitted(Integer id) {
        for (User item : cache) {
            if (item != null && item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void move(int endIndex) {
        for(int i=endIndex; i>0; i--) {
            cache[i] = cache[i--];
        }
    }

    // only for unit test
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
