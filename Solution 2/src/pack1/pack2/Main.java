package pack1.pack2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Labrab2 {
    public static void main(String[] args) {
        final String regex = "([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}";
        final String string = "aE:dC:cA:56:76:54.\n"
                + "01:23:45:67:89:Az";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
