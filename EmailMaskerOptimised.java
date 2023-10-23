public class EmailMaskerOptimised {
    public static String maskEmail(String email) {
        if (email == null || email.isEmpty()) {
            return email;
        }

        int atIndex = email.indexOf('@');
        if (atIndex <= 0) {
            return email;
        }

        // Get the local part and domain of the email
        String localPart = email.substring(0, atIndex);
        String domain = email.substring(atIndex);

        int length = localPart.length();
        int maskLength = Math.max(length / 2, 1); // Mask at least half of the characters
        int startIndex = (length - maskLength) / 2; // Start masking from the middle of the local part

        StringBuilder maskedLocalPart = new StringBuilder(localPart);
        for (int i = startIndex; i < startIndex + maskLength; i++) {
            maskedLocalPart.setCharAt(i, '*');
        }

        // Return the masked email
        return maskedLocalPart.append(domain).toString();
    }

    public static void main(String[] args) {
        String email1 = "john.doe@example.com";
        String email2 = "johndoe@example.com";
        String email3 = "johndoe@";

        System.out.println("Original Email: " + email1);
        System.out.println("Masked Email: " + maskEmail(email1));
        System.out.println();

        System.out.println("Original Email: " + email2);
        System.out.println("Masked Email: " + maskEmail(email2));
        System.out.println();

        System.out.println("Original Email: " + email3);
        System.out.println("Masked Email: " + maskEmail(email3));
        System.out.println();
    }
}
