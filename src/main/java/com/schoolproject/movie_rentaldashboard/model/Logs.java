package com.schoolproject.movie_rentaldashboard.model;

/**
 * Log entry for movie rental actions.
 */
public class Logs {
    private int actionId;
    private String dateTime;
    private String userType;
    private String userName;
    private String action;
    private String details;

    /**
     * Constructs a Log object with the specified parameters.
     *
     * @param actionId   The unique identifier for the log entry.
     * @param dateTime   The date and time of the logged action.
     * @param userType   The type of user who performed the action.
     * @param userName   The name of the user who performed the action.
     * @param action     The type of action that was performed.
     * @param details    Additional details about the action.
     */
    public Logs(int actionId, String dateTime, String userType, String userName, String action, String details) {
        this.actionId = actionId;
        this.dateTime = dateTime;
        this.userType = userType;
        this.userName = userName;
        this.action = action;
        this.details = details;
    }
    public Logs(String dateTime, String userType, String userName, String action, String details) {
        this.dateTime = dateTime;
        this.userType = userType;
        this.userName = userName;
        this.action = action;
        this.details = details;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
