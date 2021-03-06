package test;

public class Assert {

	private static final String SUCCESS = "test success!"; 
	private static final String FAILURE = "test failure!";
	
	public static void equal(boolean source, boolean expect) {
		if (source == expect) {
			success();
		} else {
			failure();
		}
	}
	
	public static void equal(Object source, Object expect) {
		if (source == expect) {
			success();
		} else {
			if (source == null || expect == null) {
				failure();
			} else {
				if (source.equals(expect)) {
					success();
				} else {
					failure();
				}
			}
		}
		
	}
	
	public static void equal(Object[] source, Object[] expect) {
		if (source == null || expect == null) {
			failure();
		} else {
			if (source.length != expect.length) {
	    		failure();
	    	} else {
	    		// null,null->success
    			// null,object->failure
    			// object, null->failure
    			// object, objct->
    			//                equal=true->success
    			//                equal=false->failure
	    		boolean success = true;
	    		for (int i=0; i<source.length-1; i++) {
	    			if (source[i] == null) {
	    				if (expect[i] != null) {
	    					success = false;
	    					break;
	    				}
	    			} else {
	    				if (expect[i] == null) {
	    					success = false;
	    					break;
	    				} else {
	    					if(!source[i].equals(expect[i])) {
	    						success = false;
	    						break;
	    					}
	    				}
	    			}
	            }
	    		if (success) {
	    			success();
	    		} else {
	    			failure();
	    		}
	    	}
		}
	}
	
	public static void success() {
		System.out.println(SUCCESS);
	}
	
	public static void success(String msg) {
		System.out.println(SUCCESS + "[" + msg + "]");
	}
	
	public static void failure() {
		System.out.println(FAILURE);
	}

	public static void failure(String msg) {
		System.out.println(FAILURE +"["+ msg + "]");
	}
	
}
