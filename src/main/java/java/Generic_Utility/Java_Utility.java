package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to avoid duplicates
	 * 
	 * @return
	 * @author sunita
	 */
	public int getRandomNum() {
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
		//pull
		//pushing back
	}
}
