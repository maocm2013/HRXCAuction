package com.hrxc.auction.util;

import com.hrxc.auction.action.ProjectInfoAction;
import com.hrxc.auction.domain.ProjectInfo;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author user
 */
public class TreeMenuConfig {

    /**
     * 菜单名称定义
     */
    public static class MenuName {

        /**
         * M_00-公共管理
         */
        public static final String M_00 = "公共管理";
        /**
         * M_00_01-项目信息
         */
        public static final String M_00_01 = "项目信息";
        /**
         * M_00_02-委托方信息
         */
        public static final String M_00_02 = "委托方信息";
        /**
         * M_09-拍卖项目
         */
        public static final String M_09 = "拍卖项目";
        /**
         * M_09_00-2013年7月28日天宝润德拍卖会
         */
        public static final String M_09_00 = "XXXX年X月XX日天宝润德拍卖会";
        /**
         * M_09_00_01-拍卖清单
         */
        public static final String M_09_00_01 = "拍品清单";
        /**
         * M_09_00_02-竞买号牌
         */
        public static final String M_09_00_02 = "竞买号牌";
        /**
         * M_09_00_03-成交记录
         */
        public static final String M_09_00_03 = "成交记录";
    }

    /**
     * 生成菜单模型
     *
     * @return
     */
    public static DefaultTreeModel generateTreeMenu() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new TreeMenuObject("华软信诚拍卖系统"));
        DefaultTreeModel tm = new DefaultTreeModel(root);

        /**
         * 公共管理菜单
         */
        DefaultMutableTreeNode m00 = new DefaultMutableTreeNode(new TreeMenuObject(MenuName.M_00));
        DefaultMutableTreeNode m0001 = new DefaultMutableTreeNode(new TreeMenuObject(MenuName.M_00_01));
        DefaultMutableTreeNode m0002 = new DefaultMutableTreeNode(new TreeMenuObject(MenuName.M_00_02));
        m00.add(m0001);
        m00.add(m0002);
        root.add(m00);

        DefaultMutableTreeNode m09 = new DefaultMutableTreeNode(new TreeMenuObject(MenuName.M_09));

        //组织项目信息，仅列示未完结的项目
        List<ProjectInfo> list = ProjectInfoAction.getAllProjectByState(DictEnum.ProjectState.PROCESSING);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ProjectInfo project = list.get(i);
                String projectNo = project.getProjectNo();
                String projectName = project.getProjectName();
                TreeMenuObject menu_09_00 = new TreeMenuObject(projectNo, projectName);

                DefaultMutableTreeNode m0900 = new DefaultMutableTreeNode(menu_09_00);
                m09.add(m0900);
                
                TreeMenuObject menu_09_00_01 = new TreeMenuObject(projectNo, MenuName.M_09_00_01);
                DefaultMutableTreeNode m090001 = new DefaultMutableTreeNode(menu_09_00_01);
                
                TreeMenuObject menu_09_00_02 = new TreeMenuObject(projectNo, MenuName.M_09_00_02);
                DefaultMutableTreeNode m090002 = new DefaultMutableTreeNode(menu_09_00_02);
                
                TreeMenuObject menu_09_00_03 = new TreeMenuObject(projectNo, MenuName.M_09_00_03);
                DefaultMutableTreeNode m090003 = new DefaultMutableTreeNode(menu_09_00_03);
                
                m0900.add(m090001);
                m0900.add(m090002);
                m0900.add(m090003);
            }
        }
        root.add(m09);

        return tm;
    }
}
