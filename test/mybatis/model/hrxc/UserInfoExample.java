package mybatis.model.hrxc;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPK_IDIsNull() {
            addCriterion("PK_ID is null");
            return (Criteria) this;
        }

        public Criteria andPK_IDIsNotNull() {
            addCriterion("PK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPK_IDEqualTo(String value) {
            addCriterion("PK_ID =", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDNotEqualTo(String value) {
            addCriterion("PK_ID <>", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDGreaterThan(String value) {
            addCriterion("PK_ID >", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDGreaterThanOrEqualTo(String value) {
            addCriterion("PK_ID >=", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDLessThan(String value) {
            addCriterion("PK_ID <", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDLessThanOrEqualTo(String value) {
            addCriterion("PK_ID <=", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDLike(String value) {
            addCriterion("PK_ID like", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDNotLike(String value) {
            addCriterion("PK_ID not like", value, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDIn(List<String> values) {
            addCriterion("PK_ID in", values, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDNotIn(List<String> values) {
            addCriterion("PK_ID not in", values, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDBetween(String value1, String value2) {
            addCriterion("PK_ID between", value1, value2, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andPK_IDNotBetween(String value1, String value2) {
            addCriterion("PK_ID not between", value1, value2, "PK_ID");
            return (Criteria) this;
        }

        public Criteria andUSER_NOIsNull() {
            addCriterion("USER_NO is null");
            return (Criteria) this;
        }

        public Criteria andUSER_NOIsNotNull() {
            addCriterion("USER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUSER_NOEqualTo(String value) {
            addCriterion("USER_NO =", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NONotEqualTo(String value) {
            addCriterion("USER_NO <>", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOGreaterThan(String value) {
            addCriterion("USER_NO >", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NO >=", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOLessThan(String value) {
            addCriterion("USER_NO <", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOLessThanOrEqualTo(String value) {
            addCriterion("USER_NO <=", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOLike(String value) {
            addCriterion("USER_NO like", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NONotLike(String value) {
            addCriterion("USER_NO not like", value, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOIn(List<String> values) {
            addCriterion("USER_NO in", values, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NONotIn(List<String> values) {
            addCriterion("USER_NO not in", values, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NOBetween(String value1, String value2) {
            addCriterion("USER_NO between", value1, value2, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NONotBetween(String value1, String value2) {
            addCriterion("USER_NO not between", value1, value2, "USER_NO");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEEqualTo(String value) {
            addCriterion("USER_NAME =", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMENotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMELessThan(String value) {
            addCriterion("USER_NAME <", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMELessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMELike(String value) {
            addCriterion("USER_NAME like", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMENotLike(String value) {
            addCriterion("USER_NAME not like", value, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEIn(List<String> values) {
            addCriterion("USER_NAME in", values, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMENotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMEBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andUSER_NAMENotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "USER_NAME");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPASSWORDEqualTo(String value) {
            addCriterion("PASSWORD =", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLessThan(String value) {
            addCriterion("PASSWORD <", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDLike(String value) {
            addCriterion("PASSWORD like", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotLike(String value) {
            addCriterion("PASSWORD not like", value, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDIn(List<String> values) {
            addCriterion("PASSWORD in", values, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "PASSWORD");
            return (Criteria) this;
        }

        public Criteria andPASSWORDNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "PASSWORD");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated do_not_delete_during_merge Fri Aug 16 08:56:35 CST 2013
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table HRXC.USER_INFO
     *
     * @mbggenerated Fri Aug 16 08:56:35 CST 2013
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}