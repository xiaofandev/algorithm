package usage.other;

import util.ArrayStack;

/**
 * 括号格式验证器，规则：3种括号可以任意嵌套，但必须成对
 * 合法格式如下：{[()]}、{([])}、[{()}]、[({})]...
 * 非法格式如下：{(})
 *
 */
public class BracketsChecker {

	private final ArrayStack<String> leftBracketStack = new ArrayStack<>(3);
	
	public boolean check(String expression) {
		String[] brackets = expression.split(" ");
		for(int i=0; i<brackets.length; i++) {
			switch(brackets[i]) {
				case "{":
					leftBracketStack.push("{");
					break;
				case "[":
					leftBracketStack.push("[");
					break;
				case "(":
					leftBracketStack.push("(");
					break;
				case "}":
					if(isMatch("}")) {
						leftBracketStack.pop();
					}
					break;
				case "]":
					if(isMatch("]")) {
						leftBracketStack.pop();
					}
					break;
				case ")":
					if(isMatch(")")) {
						leftBracketStack.pop();
					}
					break;
			}
		}
		
		if(leftBracketStack.getSize()>0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 判断右括号是否和左括号栈顶元素匹配
	 * @param rightBracket 右括号
	 * @return 
	 */
	private boolean isMatch(String rightBracket) {
		String leftBracket = leftBracketStack.getLast();
		boolean result = false;
		switch (rightBracket) {
			case "}": 
				if("{".equals(leftBracket)) {
					result = true;
				}
				break;
			case "]": 
				if("[".equals(leftBracket)) {
					result = true;
				}
				break;
			case ")": 
				if("(".equals(leftBracket)) {
					result = true;
				}
				break;
		}
		return result;
	}
}
