import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    public static TimeLine getTimeLineFromInput(String input) {
        TimeLine result = new TimeLine();
        String[] data = input.split(" ");
        setServiceData(result, data[Properties.SERVICE_INFO_INDEX]);
        setQuestionData(result, data[Properties.QUESTION_INFO_INDEX]);
        result.setResponseType(data[Properties.RESPONSE_TYPE_INDEX].charAt(0));
        result.setDate(getDateFromString(data[Properties.DATE_INFO_INDEX]));
        result.setMinutes(Integer.parseInt(data[Properties.MINUTES_INDEX]));
        return result;
    }

    public static Query getQueryFromInput(String input) {
        Query result = new Query();
        String[] data = input.split(" ");
        setServiceData(result, data[Properties.SERVICE_INFO_INDEX]);
        setQuestionData(result, data[Properties.QUESTION_INFO_INDEX]);
        result.setResponseType(data[Properties.RESPONSE_TYPE_INDEX].charAt(0));
        setDateInterval(result, data[Properties.DATE_INFO_INDEX]);
        return result;
    }

    private static void setServiceData(Data timeLine, String serviceData) {
        String[] serviceInfo = serviceData.split("\\.");
        validateData(serviceInfo.length, 1, 2);

        timeLine.setServiceId(Integer.parseInt(serviceInfo[0]));
        if (serviceInfo.length == 2) {
            timeLine.setVariationId(Integer.parseInt(serviceInfo[1]));
        }
    }

    private static void setQuestionData(Data timeLine, String questionData) {
        String[] questionInfo = questionData.split("\\.");
        validateData(questionInfo.length, 1, 3);

        if (timeLine instanceof Query && questionInfo[0].equals("*")) {
            return;
        }
        timeLine.setQuestionTypeId(Integer.parseInt(questionInfo[0]));
        if (questionInfo.length > 1) {
            timeLine.setCategoryId(Integer.parseInt(questionInfo[1]));
            if (questionInfo.length == 3) {
                timeLine.setSubCategoryId(Integer.parseInt(questionInfo[2]));
            }
        }
    }

    private static void setDateInterval(Query query, String dateInterval) {
        String[] dateInfo = dateInterval.split("-");
        validateData(dateInfo.length, 1, 2);

        query.setDateFrom(getDateFromString(dateInfo[0]));
        if (dateInfo.length == 2) {
            query.setDateTo(getDateFromString(dateInfo[1]));
        }
    }

    private static void validateData(int givenLength, int min, int max) {
        if (givenLength < min || givenLength > max) {
            throw new IllegalArgumentException("Input malformed");
        }
    }

    private static Date getDateFromString(String date) {
        Date result = null;
        SimpleDateFormat formatter = new SimpleDateFormat(Properties.DATE_PATTERN);
        try {
            result = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
