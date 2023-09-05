package etc.exception.custom;

public class MainClass {

	public static void main(String[] args) {

		LoginUser user = new LoginUser("abc1234", "aaa1111!");
		
		String rt;
		try {
			rt = user.loginValidate("abc1234", "aaa1111!");
			System.out.println(rt);
		} catch (LoginValidateException e) {
			System.out.println(e.getMessage());
		}
	}

}
