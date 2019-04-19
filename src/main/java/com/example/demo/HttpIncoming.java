package com.example.demo;

public class HttpIncoming {
    private String transactionId;

    private String requestReceivedTimestamp;

    private String environment;

    private String serviceName;

    private String requestURL;

    private String userId;

    private String ipAddress;

    private String requestHeader;

    private String requestPayload;

    private String modifiedRequestPayload;

    private String requestModificationStatus;

    private String responseHeader;

    private String responsePayload;

    private String modifiedResponsePayload;

    private String responseSentTimestamp;

    private String responseModificationStatus;

    private String timeTaken;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRequestReceivedTimestamp() {
        return requestReceivedTimestamp;
    }

    public void setRequestReceivedTimestamp(String requestReceivedTimestamp) {
        this.requestReceivedTimestamp = requestReceivedTimestamp;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(String requestPayload) {
        this.requestPayload = requestPayload;
    }

    public String getModifiedRequestPayload() {
        return modifiedRequestPayload;
    }

    public void setModifiedRequestPayload(String modifiedRequestPayload) {
        this.modifiedRequestPayload = modifiedRequestPayload;
    }

    public String getRequestModificationStatus() {
        return requestModificationStatus;
    }

    public void setRequestModificationStatus(String requestModificationStatus) {
        this.requestModificationStatus = requestModificationStatus;
    }

    public String getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(String responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(String responsePayload) {
        this.responsePayload = responsePayload;
    }

    public String getModifiedResponsePayload() {
        return modifiedResponsePayload;
    }

    public void setModifiedResponsePayload(String modifiedResponsePayload) {
        this.modifiedResponsePayload = modifiedResponsePayload;
    }

    public String getResponseSentTimestamp() {
        return responseSentTimestamp;
    }

    public void setResponseSentTimestamp(String responseSentTimestamp) {
        this.responseSentTimestamp = responseSentTimestamp;
    }

    public String getResponseModificationStatus() {
        return responseModificationStatus;
    }

    public void setResponseModificationStatus(String responseModificationStatus) {
        this.responseModificationStatus = responseModificationStatus;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

}
