import java.util.Date;

public class TimeLine extends Data {

    Date date;
    int minutes;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean isMatchTheQuery(Query query) {
        return isResponseTypeMatch(query.getResponseType())
                && isServiceInfoMatch(query.getServiceId(), query.getVariationId())
                && isQuestionInfoMatch(query.getQuestionTypeId(), query.getCategoryId(), query.getSubCategoryId())
                && isDateMatch(query.getDateFrom(), query.getDateTo());
    }

    private boolean isServiceInfoMatch(int qServiceId, int qServiceVariationId) {
        return (qServiceId == 0)
                || (qServiceId == this.serviceId
                    && (qServiceVariationId == 0 || qServiceVariationId == this.variationId));
    }

    private boolean isQuestionInfoMatch(int qQuestionTypeId, int qCategoryId, int qSubCategoryId) {
        return (qQuestionTypeId == 0)
                || (qQuestionTypeId == this.questionTypeId
                    && (qCategoryId == 0 || qCategoryId == this.categoryId))
                    && (qSubCategoryId == 0 || qSubCategoryId == this.subCategoryId);
    }

    private boolean isResponseTypeMatch(char qResponseType){
        return qResponseType == this.responseType;
    }

    private boolean isDateMatch(Date qDateFrom, Date qDateTo) {
        boolean isAfter = this.date.after(qDateFrom) || this.date.equals(qDateFrom);
        boolean isBefore = false;
        if (qDateTo != null && isAfter) {
            isBefore = this.date.before(qDateTo) || this.date.equals(qDateTo);
        }
        return isAfter && isBefore;
    }

    @Override
    public String toString() {
        return "TimeLine{" +
                "date=" + date +
                ", minutes=" + minutes +
                ", serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", responseType=" + responseType +
                '}';
    }
}
