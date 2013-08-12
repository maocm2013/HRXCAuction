package com.hrxc.auction.util;

/**
 * 菜单对象定义
 *
 * @author user
 */
public class TreeMenuObject {

    private String projectNo;
    private String treeName;

    private TreeMenuObject() {
    }

    public TreeMenuObject(String treeName) {
        this.treeName = treeName;
    }

    public TreeMenuObject(String projectNo, String treeName) {
        this.projectNo = projectNo;
        this.treeName = treeName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String toStr() {
        return "TreeMenuObject{" + "projectNo=" + projectNo + ", treeName=" + treeName + '}';
    }

    @Override
    public String toString() {
        return treeName;
    }
}
