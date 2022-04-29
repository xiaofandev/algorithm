package test;

public class Assert {

	private static final String SUCCESS = "test success!"; 
	private static final String FAILURE = "test failure!";
	
	public static void equal(Object source, Object expect) {
		if(source == null || expect == null) {
			failure("source or expect parameter cannot be null");
		}
		if(source.equals(expect)) {
			success();
		} else {
			failure();
		}
	}
	
	public static void equal(Object[] source, Object[] expect) {
		if(source == null || expect == null) {
			failure();
		} else {
			if(source.length != expect.length) {
	    		failure();
	    	} else {
	    		// null,null->success
    			// null,object->failure
    			// object, null->failure
    			// object, objct->
    			//                equal=true->success
    			//                equal=false->failure
	    		for(int i=0; i<source.length-1; i++) {
	    			if(source[i] == null) {
	    				if(expect[i] != null) {
	    					failure();
	    					break;
	    				}
	    			} else {
	    				if(expect[i] == null) {
	    					failure();
	    					break;
	    				} else {
	    					if(!source[i].equals(expect[i])) {
	    						failure();
	    						break;
	    					}
	    				}
	    			}
	            }
	    		success();
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
	
	public static void testCaseNumber(int number) {
		System.out.print("#"+number);
	}
	
	public static void printArray(Object[] array) {
		for(Object obj : array) {
			System.out.print(obj);
		}
		System.out.println();
	}
	
// unit test
	public static void main(String[] args) {
		testEqualObjectArray();
	}
	
	public static void testEqualObject() {
		// TODO
	}
	
	public static void testEqualObjectArray() {
		// #1
		// decription: not null
		// init status: 
		// input: source=["0", "1", null],expect=["0", "1", null]
		// output: null,[print log 'test success!']
		String[] source = new String[]{"0", "1", null};
		String[] expect = new String[]{"0", "1", null};
		Assert.equal(source, expect);

	}
	
}
