
public abstract class Data {

    int serviceId;
    int variationId;
    int questionTypeId;
    int categoryId;
    int subCategoryId;
    char responseType;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        if (serviceId < 1 || serviceId > 10) {
            throw new IllegalArgumentException("serviceId must be between 1 and 10");
        }
        this.serviceId = serviceId;
    }

    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        if (variationId < 1 || variationId > 3) {
            throw new IllegalArgumentException("variationId must be between 1 and 3");
        }
        this.variationId = variationId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        if (questionTypeId < 1 || questionTypeId > 10) {
            throw new IllegalArgumentException("questionTypeId must be between 1 and 10");
        }
        this.questionTypeId = questionTypeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        if (categoryId < 1 || categoryId > 20) {
            throw new IllegalArgumentException("categoryId must be between 1 and 20");
        }
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        if (subCategoryId < 1 || subCategoryId > 5) {
            throw new IllegalArgumentException("subCategoryId must be between 1 and 5");
        }
        this.subCategoryId = subCategoryId;
    }

    public char getResponseType() {
        return responseType;
    }

    public void setResponseType(char responseType) {
        if (responseType != Properties.RESPONSE_TYPE_PREVOUS && responseType != Properties.RESPONSE_TYPE_NEXT) {
            throw new IllegalArgumentException("responseType must have value" + Properties.RESPONSE_TYPE_PREVOUS
                    + " or " + Properties.RESPONSE_TYPE_NEXT);
        }
        this.responseType = responseType;
    }
}
