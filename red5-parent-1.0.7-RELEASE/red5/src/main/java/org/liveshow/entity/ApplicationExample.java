package org.liveshow.entity;

import java.util.ArrayList;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andIdcardIdIsNull() {
            addCriterion("idcard_id is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIdIsNotNull() {
            addCriterion("idcard_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardIdEqualTo(String value) {
            addCriterion("idcard_id =", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdNotEqualTo(String value) {
            addCriterion("idcard_id <>", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdGreaterThan(String value) {
            addCriterion("idcard_id >", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_id >=", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdLessThan(String value) {
            addCriterion("idcard_id <", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdLessThanOrEqualTo(String value) {
            addCriterion("idcard_id <=", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdLike(String value) {
            addCriterion("idcard_id like", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdNotLike(String value) {
            addCriterion("idcard_id not like", value, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdIn(List<String> values) {
            addCriterion("idcard_id in", values, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdNotIn(List<String> values) {
            addCriterion("idcard_id not in", values, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdBetween(String value1, String value2) {
            addCriterion("idcard_id between", value1, value2, "idcardId");
            return (Criteria) this;
        }

        public Criteria andIdcardIdNotBetween(String value1, String value2) {
            addCriterion("idcard_id not between", value1, value2, "idcardId");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoIsNull() {
            addCriterion("idcard_photo is null");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoIsNotNull() {
            addCriterion("idcard_photo is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoEqualTo(String value) {
            addCriterion("idcard_photo =", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoNotEqualTo(String value) {
            addCriterion("idcard_photo <>", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoGreaterThan(String value) {
            addCriterion("idcard_photo >", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_photo >=", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoLessThan(String value) {
            addCriterion("idcard_photo <", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoLessThanOrEqualTo(String value) {
            addCriterion("idcard_photo <=", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoLike(String value) {
            addCriterion("idcard_photo like", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoNotLike(String value) {
            addCriterion("idcard_photo not like", value, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoIn(List<String> values) {
            addCriterion("idcard_photo in", values, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoNotIn(List<String> values) {
            addCriterion("idcard_photo not in", values, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoBetween(String value1, String value2) {
            addCriterion("idcard_photo between", value1, value2, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andIdcardPhotoNotBetween(String value1, String value2) {
            addCriterion("idcard_photo not between", value1, value2, "idcardPhoto");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Integer value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Integer value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Integer value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Integer value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Integer value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Integer> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Integer> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Integer value1, Integer value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andPassStateIsNull() {
            addCriterion("pass_state is null");
            return (Criteria) this;
        }

        public Criteria andPassStateIsNotNull() {
            addCriterion("pass_state is not null");
            return (Criteria) this;
        }

        public Criteria andPassStateEqualTo(Boolean value) {
            addCriterion("pass_state =", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateNotEqualTo(Boolean value) {
            addCriterion("pass_state <>", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateGreaterThan(Boolean value) {
            addCriterion("pass_state >", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pass_state >=", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateLessThan(Boolean value) {
            addCriterion("pass_state <", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateLessThanOrEqualTo(Boolean value) {
            addCriterion("pass_state <=", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateIn(List<Boolean> values) {
            addCriterion("pass_state in", values, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateNotIn(List<Boolean> values) {
            addCriterion("pass_state not in", values, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateBetween(Boolean value1, Boolean value2) {
            addCriterion("pass_state between", value1, value2, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pass_state not between", value1, value2, "passState");
            return (Criteria) this;
        }

        public Criteria andLookStateIsNull() {
            addCriterion("look_state is null");
            return (Criteria) this;
        }

        public Criteria andLookStateIsNotNull() {
            addCriterion("look_state is not null");
            return (Criteria) this;
        }

        public Criteria andLookStateEqualTo(Boolean value) {
            addCriterion("look_state =", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotEqualTo(Boolean value) {
            addCriterion("look_state <>", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateGreaterThan(Boolean value) {
            addCriterion("look_state >", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("look_state >=", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLessThan(Boolean value) {
            addCriterion("look_state <", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLessThanOrEqualTo(Boolean value) {
            addCriterion("look_state <=", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateIn(List<Boolean> values) {
            addCriterion("look_state in", values, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotIn(List<Boolean> values) {
            addCriterion("look_state not in", values, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateBetween(Boolean value1, Boolean value2) {
            addCriterion("look_state between", value1, value2, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("look_state not between", value1, value2, "lookState");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("manager_id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("manager_id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("manager_id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("manager_id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manager_id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("manager_id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("manager_id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("manager_id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_id not between", value1, value2, "managerId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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