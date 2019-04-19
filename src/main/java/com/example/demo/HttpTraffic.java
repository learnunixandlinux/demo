package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "http", uniqueConstraints = @UniqueConstraint(columnNames = "TRANSACTION_ID"))
public class HttpTraffic {
    @Column(name = "ENVIRONMENT")
    private String environment;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "MODIFIED_REQUEST_PAYLOAD")
    private String modifiedRequestPayload;

    @Column(name = "MODIFIED_RESPONSE_PAYLOAD")
    private String modifiedResponsePayload;

    @Column(name = "REQUEST_HEADER")
    private String requestHeader;

    @Column(name = "REQUEST_MODIFICATION_STATUS")
    private String requestModificationStatus;

    @Column(name = "REQUEST_PAYLOAD")
    private String requestPayload;

    @Column(name = "REQUEST_RECEIVED_TIMESTAMP")
    private String requestReceivedTimestamp;

    @Column(name = "REQUEST_URL")
    private String requestURL;

    @Column(name = "RESPONSE_HEADER")
    private String responseHeader;

    @Column(name = "RESPONSE_MODIFICATION_STATUS")
    private String responseModificationStatus;

    @Column(name = "RESPONSE_PAYLOAD")
    private String responsePayload;

    @Column(name = "RESPONSE_SENT_TIMESTAMP")
    private String responseSentTimestamp;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @Column(name = "TIME_TAKEN")
    private String timeTaken;

    @Id
    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "USER_ID")
    private String userId;

    public String getEnvironment() {
        return environment;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getModifiedRequestPayload() {
        return modifiedRequestPayload;
    }

    public String getModifiedResponsePayload() {
        return modifiedResponsePayload;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public String getRequestModificationStatus() {
        return requestModificationStatus;
    }

    public String getRequestPayload() {
        return requestPayload;
    }

    public String getRequestReceivedTimestamp() {
        return requestReceivedTimestamp;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public String getResponseHeader() {
        return responseHeader;
    }

    public String getResponseModificationStatus() {
        return responseModificationStatus;
    }

    public String getResponsePayload() {
        return responsePayload;
    }

    public String getResponseSentTimestamp() {
        return responseSentTimestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setModifiedRequestPayload(String modifiedRequestPayload) {
        this.modifiedRequestPayload = modifiedRequestPayload;
    }

    public void setModifiedResponsePayload(String modifiedResponsePayload) {
        this.modifiedResponsePayload = modifiedResponsePayload;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public void setRequestModificationStatus(String requestModificationStatus) {
        this.requestModificationStatus = requestModificationStatus;
    }

    public void setRequestPayload(String requestPayload) {
        this.requestPayload = requestPayload;
    }

    public void setRequestReceivedTimestamp(String requestReceivedTimestamp) {
        this.requestReceivedTimestamp = requestReceivedTimestamp;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void setResponseHeader(String responseHeader) {
        this.responseHeader = responseHeader;
    }

    public void setResponseModificationStatus(String responseModificationStatus) {
        this.responseModificationStatus = responseModificationStatus;
    }

    public void setResponsePayload(String responsePayload) {
        this.responsePayload = responsePayload;
    }

    public void setResponseSentTimestamp(String responseSentTimestamp) {
        this.responseSentTimestamp = responseSentTimestamp;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
