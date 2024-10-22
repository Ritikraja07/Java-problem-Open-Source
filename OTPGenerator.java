import java.security.SecureRandom;

public class OTPGenerator {

    private static final int OTP_LENGTH = 6; // Length of the OTP
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateOTP() {
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(secureRandom.nextInt(10)); // Append a random digit (0-9)
        }
        return otp.toString();
    }

    public static void main(String[] args) {
        String otp = generateOTP();
        System.out.println("Your OTP is: " + otp);
    }
}
