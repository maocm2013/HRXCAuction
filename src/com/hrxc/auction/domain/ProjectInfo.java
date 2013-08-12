package com.hrxc.auction.domain;

/**
 * 拍卖项目基本信息
 *
 * @author user
 */
public class ProjectInfo {

    /**
     * 主键
     */
    private String pkId;
    /**
     * 项目编号
     */
    private String projectNo;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目状态
     */
    private String projectState;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" + "pkId=" + pkId + ", projectNo=" + projectNo + ", projectName=" + projectName + ", projectState=" + projectState + '}';
    }
}
