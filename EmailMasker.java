public class EmailMasker {

    private static final String ATSIGN = "@";
    private static final char DOT_CHAR = '.';
    private static final char ASTERISK_CHAR = '*';
    private static final int ONE = 1;

    /**
     * String input: abc.abc@abc.om
     * String output: a**.**c@abc.com
     */
    public String maskEmail(String email) {
        StringBuilder sb = new StringBuilder(email);
        int beforeAtIndexPos = sb.indexOf(ATSIGN) - ONE;
        for (int i = ONE; i < beforeAtIndexPos; i++) {
            if (sb.charAt(i) != DOT_CHAR) {
                sb.setCharAt(i, ASTERISK_CHAR);
            }
        }
        return sb.toString();
    }
}