package com.worpdress.salaboy.smartprocessdiscovery.model.process;

import com.worpdress.salaboy.smartprocessdiscovery.model.results.BusinessProcess;
import com.worpdress.salaboy.smartprocessdiscovery.model.results.BusinessRule;


import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: salaboy
 * Date: 2/4/11
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Goal {
    public enum GoalStatus { OPEN, CLOSED, SUSPENDED };
    private Long id;
    private String name;
    private String description;
    private List<BusinessProcess> businessProcessList;
    private List<BusinessRule> businessRulesList;
    private Date startDate;
    private Date endDate;
    private Date dueDate;
    private String result;
    private GoalStatus status;

    public Goal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BusinessProcess> getBusinessProcessList() {
        return businessProcessList;
    }

    public void setBusinessProcessList(List<BusinessProcess> businessProcessList) {
        this.businessProcessList = businessProcessList;
    }

    public List<BusinessRule> getBusinessRulesList() {
        return businessRulesList;
    }

    public void setBusinessRulesList(List<BusinessRule> businessRulesList) {
        this.businessRulesList = businessRulesList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }
}
