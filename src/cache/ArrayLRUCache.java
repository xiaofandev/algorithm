package cache;

import cache.exception.DataEmptyException;
import cache.exception.DataNotFoundException;

public class ArrayLRUCache {

    private User[] cache;
    private int capacity;
    
    public ArrayLRUCache(int capacity) {
    	this.capacity = capacity;
        cache = new User[capacity];
    }
    
    private void addToHead(User user) {
    	cache[0] = user;
    }
    
    /**
     * Move backward 1 offset to all element which their offset from 0 to endOffset-1
     * 
     */
    private void move(int endOffset) {
    	if(endOffset > capacity-1) {
    		throw new IndexOutOfBoundsException(endOffset);
    	}
    	
        for(int i=endOffset; i>0; i--) {
        	cache[i] = cache[i-1];
        }
    }

    private int getOffsetByUserId(int userId) {
    	if(cache[0] == null) {
    		throw new DataEmptyException();
    	} else {
	        for(int i=0; i<capacity-1; i++) {
	            if(cache[i] != null && cache[i].getId() == userId) {
	            	return i;
	            }
	        }
	        throw new DataNotFoundException();
    	}
    }

    public User getByUserId(int userId) {
    	User user = null;
        int offset = 0;
        try {
        	offset = getOffsetByUserId(userId);
        } catch (DataEmptyException e) {
        	user = new User(userId, userId+"");
        	addToHead(user);
        } catch (DataNotFoundException e) {
        	user = new User(userId, userId+"");
        	move(capacity-1);
        	addToHead(user);
        }
        user = cache[offset];
        move(offset);
        addToHead(user);
        return user;
    }
    
}
