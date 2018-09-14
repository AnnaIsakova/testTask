import java.util.*;

public class Main {

    private static List<TimeLine> timeLines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = scanner.nextInt();
        String input;
        for (int i = 0; i < numOfLines; i++) {
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if (input.isEmpty()) throw new IllegalArgumentException("Input malformed");
            char firstChar = input.charAt(0);
            if (firstChar == Properties.TIME_LINE_MARKER) {
                collectData(input);
            } else if (firstChar == Properties.QUERY_MARKER) {
                System.out.println(getQueryProcessResult(input));
            } else {
                throw new IllegalArgumentException("Input malformed");
            }
        }
    }

    public static void collectData(String input) {
        TimeLine timeLine = DataUtil.getTimeLineFromInput(input);
        timeLines.add(timeLine);

    }

    public static String getQueryProcessResult(String input) {
        String result = "-";
        Query query = DataUtil.getQueryFromInput(input);
        int totalMinutes = 0;
        double counter = 0.0;
        for (TimeLine t : timeLines) {
            if (t.isMatchTheQuery(query)) {
                totalMinutes += t.getMinutes();
                counter++;
            }
        }
        if (counter == 0) {
            return result;
        } else {
            long average = Math.round(totalMinutes / counter);
            return String.valueOf(average);
        }
    }

}
