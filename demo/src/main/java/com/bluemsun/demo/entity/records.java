package com.bluemsun.demo.entity;

import java.sql.Date;

public class records {
    private int record_id;
    private int record_type;//记录类型
    private int Grade_cj;//成绩 考试成绩
    private int subject;//科目 与param_subject对应
    private String remarks;//备注信息
    private String grade_nj;//年级
    private String competition_name;//竞赛名称
    private Date date; //竞赛日期
    private String Award_descripti; //获奖描述
    private String others_descripti;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getRecord_type() {
        return record_type;
    }

    public void setRecord_type(int record_type) {
        this.record_type = record_type;
    }

    public int getGrade_cj() {
        return Grade_cj;
    }

    public void setGrade_cj(int grade_cj) {
        Grade_cj = grade_cj;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGrade_nj() {
        return grade_nj;
    }

    public void setGrade_nj(String grade_nj) {
        this.grade_nj = grade_nj;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAward_descripti() {
        return Award_descripti;
    }

    public void setAward_descripti(String award_descripti) {
        Award_descripti = award_descripti;
    }

    public String getOthers_descripti() {
        return others_descripti;
    }

    public void setOthers_descripti(String others_descripti) {
        this.others_descripti = others_descripti;
    }
}
