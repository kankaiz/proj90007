package com.proj90007.model;
// default package



/**
 * Review entity. @author MyEclipse Persistence Tools
 */

public class Review  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private User initiator;
     private User hrReviewer;
     private User supervisorReviewer;
     private Integer reviewYear;
     private String status;
     private Integer selfRate;
     private String selfAssessment;
     private String newGoal;
     private Integer supervisorRate;
     private String supervisorAssessment;
     private Integer collaboration;
     private Integer communication;
     private Integer customerFocus;
     private Integer businessProfessional;
     private Integer hrRate;
     private String hrAssessment;
     private Integer compliance;


    // Constructors

    /** default constructor */
    public Review() {
    }

	/** minimal constructor */
    public Review(Integer id, User initiator, String status) {
        this.id = id;
        this.initiator = initiator;
        this.status = status;
    }
    
    /** full constructor */
    public Review(Integer id, User initiator, User hrReviewer, User supervisorReviewer, Integer reviewYear, String status, Integer selfRate, String selfAssessment, String newGoal, Integer supervisorRate, String supervisorAssessment, Integer collaboration, Integer communication, Integer customerFocus, Integer businessProfessional, Integer hrRate, String hrAssessment, Integer compliance) {
        this.id = id;
        this.initiator = initiator;
        this.hrReviewer = hrReviewer;
        this.supervisorReviewer = supervisorReviewer;
        this.reviewYear = reviewYear;
        this.status = status;
        this.selfRate = selfRate;
        this.selfAssessment = selfAssessment;
        this.newGoal = newGoal;
        this.supervisorRate = supervisorRate;
        this.supervisorAssessment = supervisorAssessment;
        this.collaboration = collaboration;
        this.communication = communication;
        this.customerFocus = customerFocus;
        this.businessProfessional = businessProfessional;
        this.hrRate = hrRate;
        this.hrAssessment = hrAssessment;
        this.compliance = compliance;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public User getInitiator() {
        return this.initiator;
    }
    
    public void setInitiator(User initiator) {
        this.initiator = initiator;
    }

    public User getHrReviewer() {
		return hrReviewer;
	}

	public void setHrReviewer(User hrReviewer) {
		this.hrReviewer = hrReviewer;
	}

	public User getSupervisorReviewer() {
        return this.supervisorReviewer;
    }
    
    public void setSupervisorReviewer(User supervisorReviewer) {
        this.supervisorReviewer = supervisorReviewer;
    }

    public Integer getReviewYear() {
        return this.reviewYear;
    }
    
    public void setReviewYear(Integer reviewYear) {
        this.reviewYear = reviewYear;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSelfRate() {
        return this.selfRate;
    }
    
    public void setSelfRate(Integer selfRate) {
        this.selfRate = selfRate;
    }

    public String getSelfAssessment() {
        return this.selfAssessment;
    }
    
    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public String getNewGoal() {
        return this.newGoal;
    }
    
    public void setNewGoal(String newGoal) {
        this.newGoal = newGoal;
    }

    public Integer getSupervisorRate() {
        return this.supervisorRate;
    }
    
    public void setSupervisorRate(Integer supervisorRate) {
        this.supervisorRate = supervisorRate;
    }

    public String getSupervisorAssessment() {
        return this.supervisorAssessment;
    }
    
    public void setSupervisorAssessment(String supervisorAssessment) {
        this.supervisorAssessment = supervisorAssessment;
    }

    public Integer getCollaboration() {
        return this.collaboration;
    }
    
    public void setCollaboration(Integer collaboration) {
        this.collaboration = collaboration;
    }

    public Integer getCommunication() {
        return this.communication;
    }
    
    public void setCommunication(Integer communication) {
        this.communication = communication;
    }

    public Integer getCustomerFocus() {
        return this.customerFocus;
    }
    
    public void setCustomerFocus(Integer customerFocus) {
        this.customerFocus = customerFocus;
    }

    public Integer getBusinessProfessional() {
        return this.businessProfessional;
    }
    
    public void setBusinessProfessional(Integer businessProfessional) {
        this.businessProfessional = businessProfessional;
    }

    public Integer getHrRate() {
        return this.hrRate;
    }
    
    public void setHrRate(Integer hrRate) {
        this.hrRate = hrRate;
    }

    public String getHrAssessment() {
        return this.hrAssessment;
    }
    
    public void setHrAssessment(String hrAssessment) {
        this.hrAssessment = hrAssessment;
    }

    public Integer getCompliance() {
        return this.compliance;
    }
    
    public void setCompliance(Integer compliance) {
        this.compliance = compliance;
    }




}