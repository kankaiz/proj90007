package com.proj90007.dao;
// default package

import com.proj90007.model.Review;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 	* A data access object (DAO) providing persistence and search support for Review entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Review
  * @author MyEclipse Persistence Tools 
 */
    @Transactional
public class ReviewDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ReviewDAO.class);
		//property constants
	public static final String REVIEW_YEAR = "reviewYear";
	public static final String STATUS = "status";
	public static final String SELF_RATE = "selfRate";
	public static final String SELF_ASSESSMENT = "selfAssessment";
	public static final String NEW_GOAL = "newGoal";
	public static final String SUPERVISOR_RATE = "supervisorRate";
	public static final String SUPERVISOR_ASSESSMENT = "supervisorAssessment";
	public static final String COLLABORATION = "collaboration";
	public static final String COMMUNICATION = "communication";
	public static final String CUSTOMER_FOCUS = "customerFocus";
	public static final String BUSINESS_PROFESSIONAL = "businessProfessional";
	public static final String HR_RATE = "hrRate";
	public static final String HR_ASSESSMENT = "hrAssessment";
	public static final String COMPLIANCE = "compliance";



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(Review transientInstance) {
        log.debug("saving Review instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Review persistentInstance) {
        log.debug("deleting Review instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Review findById( java.lang.Integer id) {
        log.debug("getting Review instance with id: " + id);
        try {
            Review instance = (Review) getCurrentSession()
                    .get("com.proj90007.model.Review", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Review instance) {
        log.debug("finding Review instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.proj90007.model.Review") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Review instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Review as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByReviewYear(Object reviewYear
	) {
		return findByProperty(REVIEW_YEAR, reviewYear
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findBySelfRate(Object selfRate
	) {
		return findByProperty(SELF_RATE, selfRate
		);
	}
	
	public List findBySelfAssessment(Object selfAssessment
	) {
		return findByProperty(SELF_ASSESSMENT, selfAssessment
		);
	}
	
	public List findByNewGoal(Object newGoal
	) {
		return findByProperty(NEW_GOAL, newGoal
		);
	}
	
	public List findBySupervisorRate(Object supervisorRate
	) {
		return findByProperty(SUPERVISOR_RATE, supervisorRate
		);
	}
	
	public List findBySupervisorAssessment(Object supervisorAssessment
	) {
		return findByProperty(SUPERVISOR_ASSESSMENT, supervisorAssessment
		);
	}
	
	public List findByCollaboration(Object collaboration
	) {
		return findByProperty(COLLABORATION, collaboration
		);
	}
	
	public List findByCommunication(Object communication
	) {
		return findByProperty(COMMUNICATION, communication
		);
	}
	
	public List findByCustomerFocus(Object customerFocus
	) {
		return findByProperty(CUSTOMER_FOCUS, customerFocus
		);
	}
	
	public List findByBusinessProfessional(Object businessProfessional
	) {
		return findByProperty(BUSINESS_PROFESSIONAL, businessProfessional
		);
	}
	
	public List findByHrRate(Object hrRate
	) {
		return findByProperty(HR_RATE, hrRate
		);
	}
	
	public List findByHrAssessment(Object hrAssessment
	) {
		return findByProperty(HR_ASSESSMENT, hrAssessment
		);
	}
	
	public List findByCompliance(Object compliance
	) {
		return findByProperty(COMPLIANCE, compliance
		);
	}
	

	public List findAll() {
		log.debug("finding all Review instances");
		try {
			String queryString = "from Review";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Review merge(Review detachedInstance) {
        log.debug("merging Review instance");
        try {
            Review result = (Review) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Review instance) {
        log.debug("attaching dirty Review instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Review instance) {
        log.debug("attaching clean Review instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ReviewDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ReviewDAO) ctx.getBean("ReviewDAO");
	}
}