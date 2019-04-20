package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "script", uniqueConstraints = @UniqueConstraint(columnNames = "script_id"))
public class Script {
    @Id
    @Column(name = "script_id")
    private String scriptId;

    @Column(name = "type")
    private String type;

    @Column(name = "stmt")
    private String stmt;

    @Column(name = "environment")
    private String environment;

    @Column(name = "createTs")
    private String createTs;

    @Column(name = "processingService")
    private String processingService;

    @Column(name = "processingTs")
    private String processingTs;

    @Column(name = "result")
    private String result;

    @Column(name = "resultStatus")
    private String resultStatus;

    @Column(name = "resultTs")
    private String resultTs;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getProcessingService() {
        return processingService;
    }

    public void setProcessingService(String processingService) {
        this.processingService = processingService;
    }

    public String getProcessingTs() {
        return processingTs;
    }

    public void setProcessingTs(String processingTs) {
        this.processingTs = processingTs;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStmt() {
        return stmt;
    }

    public void setStmt(String stmt) {
        this.stmt = stmt;
    }

    public String getCreateTs() {
        return createTs;
    }

    public void setCreateTs(String createTs) {
        this.createTs = createTs;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultTs() {
        return resultTs;
    }

    public void setResultTs(String resultTs) {
        this.resultTs = resultTs;
    }

}
