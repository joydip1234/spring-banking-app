package jbr.springmvc.util;

public class VerificationCodeUtil {
	public static String createCode() {
		
		Integer randomOtp = (int)(Math.random()*1000000);
		String otp = String.valueOf(randomOtp);
		return otp;
	}
}
