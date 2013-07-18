/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.util;

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
         * M_00_01-拍卖清单
         */
        public static final String M_00_01 = "拍品清单";
        /**
         * M_00_02-竞买号牌
         */
        public static final String M_00_02 = "竞买号牌";
        
        /**
         * M_00_03-成交记录
         */
        public static final String M_00_03 = "成交记录";
    }

    /**
     * 生成菜单模型
     *
     * @return
     */
    public static DefaultTreeModel generateTreeMenu() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("2013年7月28日天宝润德拍卖会");
        DefaultTreeModel tm = new DefaultTreeModel(root);

        DefaultMutableTreeNode m_00_01 = new DefaultMutableTreeNode(MenuName.M_00_01);
        DefaultMutableTreeNode m_00_02 = new DefaultMutableTreeNode(MenuName.M_00_02);
        DefaultMutableTreeNode m_00_03 = new DefaultMutableTreeNode(MenuName.M_00_03);

        root.add(m_00_01);
        root.add(m_00_02);
        root.add(m_00_03);
        return tm;
    }
}
