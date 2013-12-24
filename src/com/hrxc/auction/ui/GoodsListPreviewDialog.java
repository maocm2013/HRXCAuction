package com.hrxc.auction.ui;

import com.hrxc.auction.util.Configuration;
import com.hrxc.auction.util.ImageUtil;
import com.hrxc.auction.util.UITools;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.table.TableModel;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class GoodsListPreviewDialog extends javax.swing.JDialog {

    private static final Logger log = Logger.getLogger(GoodsListPreviewDialog.class);
    private String s_desc = "<html>\n"
            + "	<div align=center><p style=\"font-family:黑体;font-size:56px;color:#990000\">GoodsNo</p></div>\n"
            + "	<br>\n"
            + "	<div align=center><p style=\"font-family:黑体;font-size:24px;color:black\">Author</p></div>\n"
            + "	<br>\n"
            + "	<div align=center><p style=\"font-family:黑体;font-size:24px;color:black\">GoodsName</p></div>\n"
            + "	<br>\n"
            + "	<div align=center><p style=\"font-family:黑体;font-size:24px;color:black\">起拍价：OnsetPrice</p></div>\n"
            + "</html>";
    private String s_datetime = "<html>\n"
            + "	<div align=center><p style=\"font-family:黑体;font-size:24px;color:black\">weektime</p></div>\n"
            + "	<div align=center><p style=\"font-family:黑体;font-size:24px;color:black\">datetime</p></div>\n"
            + "</html>";

    /**
     * Creates new form GoodsListPreviewDialog
     */
    public GoodsListPreviewDialog(java.awt.Frame parent, boolean modal, String projectNo, TableModel tableModel, int indexNo) {
        super(parent, modal);

        this.projectNo = projectNo;
        this.tableModel = tableModel;
        this.indexNo = indexNo;
        current_index_no = indexNo;

        //不显示标题栏
        this.setUndecorated(true);

        initComponents();

        //动态时间显示
        AutoShowTimeThread timeThread = new AutoShowTimeThread();
        timeThread.start();

        initLayout();
        showTitleImage();
        showGoodsInfo(current_index_no);
    }

    /**
     * 初始化布局
     * TODO：使用setLocation近定义其坐标起始位置时存在定位不准的问题，使用setBounds则准确得多
     */
    private void initLayout() {
        log.debug("this.width=" + this.getWidth() + ";this.height=" + this.getHeight());
        log.debug("this.panel.width=" + this.jPanel1.getWidth() + ";this.panel.height=" + this.jPanel1.getHeight());
        
        //设置标题部分的大小
        int d_title_w = this.getWidth();
        int d_title_h = new BigDecimal(this.getHeight() * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        Dimension d_title = new Dimension(d_title_w, d_title_h);
        log.debug("d_title" + d_title.toString());
        titleLabel.setPreferredSize(d_title);
        titleLabel.setMaximumSize(d_title);
        titleLabel.setMaximumSize(d_title);
        titleLabel.setBounds(0, 0, d_title_w, d_title_h);
        log.debug("titleLable.xy=" + titleLabel.getLocation().toString());

        //设置图片显示部分大小
        int d_image_w = new BigDecimal(this.getWidth() * 0.7).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        int d_image_h = new BigDecimal(this.getHeight() * 0.8).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        Dimension d_image = new Dimension(d_image_w, d_image_h);
        imageLabel.setPreferredSize(d_image);
        imageLabel.setMinimumSize(d_image);
        imageLabel.setMaximumSize(d_image);
        imageLabel.setBounds(0, titleLabel.getHeight(), d_image_w,d_image_h);
        log.debug("imageLabel.xy=" + imageLabel.getLocation().toString());

        //设置时钟显示区域
        int d_datetime_w = new BigDecimal(this.getWidth() * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        int d_datetime_h = new BigDecimal(this.getHeight() * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        Dimension d_datetime = new Dimension(d_datetime_w, d_datetime_h);
        datetimeLabel.setPreferredSize(d_datetime);
        datetimeLabel.setMinimumSize(d_datetime);
        datetimeLabel.setMaximumSize(d_datetime);
        datetimeLabel.setBounds(imageLabel.getWidth(), titleLabel.getHeight(), d_datetime_w,d_datetime_h);
        log.debug("datetimeLabel.xy=" + datetimeLabel.getLocation().toString());

        //设置图录信息部分大小
        int d_desc_w = new BigDecimal(this.getWidth() * 0.3).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        int d_desc_h = new BigDecimal(this.getHeight() * 0.5).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        Dimension d_desc = new Dimension(d_desc_w, d_desc_h);
        descLabel.setPreferredSize(d_desc);
        descLabel.setMinimumSize(d_desc);
        descLabel.setMaximumSize(d_desc);
        descLabel.setBounds(imageLabel.getWidth(), titleLabel.getHeight() + datetimeLabel.getHeight(),d_desc_w,d_desc_h);
        log.debug("descLabel.xy=" + descLabel.getLocation().toString());

        //设置按钮区域大小
        int d_toolbar_w = this.getWidth();
        int d_toolbar_h = new BigDecimal(this.getHeight() * 0.1).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        Dimension d_toolbar = new Dimension(d_toolbar_w, d_toolbar_h);
        myToolBar.setPreferredSize(d_toolbar);
        myToolBar.setMinimumSize(d_toolbar);
        myToolBar.setMaximumSize(d_toolbar);
        myToolBar.setBounds(0, titleLabel.getHeight() + imageLabel.getHeight(),d_toolbar_w, d_toolbar_h);
        log.debug("myToolBar.xy=" + myToolBar.getLocation().toString());
    }

    /**
     * 显示标题LOGO
     */
    private void showTitleImage() {
        try {

            String tmpfilePath = Configuration.getInstance().getGoodsImageTempPath().concat(UITools.generateUUID()).concat(".jpg");
            File tmpFile = new File(tmpfilePath);
            ImageUtil.resize(new File("config/view_title.jpg"), tmpFile, titleLabel.getWidth(), titleLabel.getHeight(), 1f);
            ImageIcon icon = new ImageIcon(tmpfilePath);
            titleLabel.setIcon(icon);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * 显示图片
     *
     * @param current_index_no
     */
    private void showGoodsInfo(int current_index_no) {
        //图片存储路径=根路径+项目编号+图录号.jpg
        String rootPath = Configuration.getInstance().getGoodsImageRootPath().concat(projectNo).concat("/");

        try {
            //显示拍品信息
            String goodsNo = tableModel.getValueAt(current_index_no, 3).toString();
            String desc = s_desc.replaceAll("GoodsNo", goodsNo);

            String author = "";
            if (tableModel.getValueAt(current_index_no, 11) != null) {
                author = tableModel.getValueAt(current_index_no, 11).toString();
            }
            desc = desc.replaceAll("Author", author);

            String goodsName = String.valueOf(tableModel.getValueAt(current_index_no, 4));
            desc = desc.replaceAll("GoodsName", goodsName);

            String onsetPrice = String.valueOf(tableModel.getValueAt(current_index_no, 7));
            desc = desc.replaceAll("OnsetPrice", onsetPrice);
            descLabel.setText(desc);

            String goodsImagePath = rootPath.concat(goodsNo).concat(".jpg");
            String tmpfilePath = Configuration.getInstance().getGoodsImageTempPath().concat(UITools.generateUUID()).concat(".jpg");
            File tmpFile = new File(tmpfilePath);
            ImageUtil.resize4DisplayArea(new File(goodsImagePath), tmpFile, imageLabel.getWidth(), imageLabel.getHeight(), 1f);
            ImageIcon icon = new ImageIcon(tmpfilePath);
            imageLabel.setIcon(icon);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        datetimeLabel = new org.jdesktop.swingx.JXLabel();
        descLabel = new org.jdesktop.swingx.JXLabel();
        titleLabel = new org.jdesktop.swingx.JXLabel();
        imageLabel = new org.jdesktop.swingx.JXLabel();
        myToolBar = new javax.swing.JToolBar();
        closeBt = new org.jdesktop.swingx.JXButton();
        backBt = new org.jdesktop.swingx.JXButton();
        fullScreenBt = new org.jdesktop.swingx.JXButton();
        firstBt = new org.jdesktop.swingx.JXButton();
        previousBt = new org.jdesktop.swingx.JXButton();
        nextBt = new org.jdesktop.swingx.JXButton();
        lastBt = new org.jdesktop.swingx.JXButton();
        gotoFd = new org.jdesktop.swingx.JXTextField();
        gotoBt = new org.jdesktop.swingx.JXButton();
        autoStartBt = new org.jdesktop.swingx.JXButton();
        pauseBt = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 540));

        datetimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datetimeLabel.setLabelFor(this);
        datetimeLabel.setAlignmentY(0.0F);
        datetimeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        datetimeLabel.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        descLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descLabel.setAlignmentY(0.0F);
        descLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        descLabel.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setAlignmentY(0.0F);

        imageLabel.setBackground(new java.awt.Color(0, 0, 0));
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setAlignmentY(0.0F);

        myToolBar.setFloatable(false);
        myToolBar.setRollover(true);
        myToolBar.setAlignmentX(0.2F);
        myToolBar.setAlignmentY(0.2F);

        closeBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system-shutdown.png"))); // NOI18N
        closeBt.setToolTipText("关闭（ALT+F4）");
        closeBt.setFocusable(false);
        closeBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeBt.setMinimumSize(new java.awt.Dimension(45, 63));
        closeBt.setPreferredSize(new java.awt.Dimension(40, 40));
        closeBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        closeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtActionPerformed(evt);
            }
        });
        myToolBar.add(closeBt);

        backBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-nofullscreen.png"))); // NOI18N
        backBt.setToolTipText("还原");
        backBt.setFocusable(false);
        backBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backBt.setMinimumSize(new java.awt.Dimension(45, 63));
        backBt.setPreferredSize(new java.awt.Dimension(40, 40));
        backBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtActionPerformed(evt);
            }
        });
        myToolBar.add(backBt);

        fullScreenBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-fullscreen-4.png"))); // NOI18N
        fullScreenBt.setToolTipText("全屏");
        fullScreenBt.setFocusable(false);
        fullScreenBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fullScreenBt.setMinimumSize(new java.awt.Dimension(45, 63));
        fullScreenBt.setPreferredSize(new java.awt.Dimension(40, 40));
        fullScreenBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fullScreenBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullScreenBtActionPerformed(evt);
            }
        });
        myToolBar.add(fullScreenBt);

        firstBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go-first-2.png"))); // NOI18N
        firstBt.setToolTipText("开始");
        firstBt.setFocusable(false);
        firstBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        firstBt.setMinimumSize(new java.awt.Dimension(45, 63));
        firstBt.setPreferredSize(new java.awt.Dimension(40, 40));
        firstBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        firstBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstBtActionPerformed(evt);
            }
        });
        myToolBar.add(firstBt);

        previousBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go-previous-4.png"))); // NOI18N
        previousBt.setToolTipText("后退（PAGE UP）");
        previousBt.setFocusable(false);
        previousBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previousBt.setMinimumSize(new java.awt.Dimension(45, 63));
        previousBt.setPreferredSize(new java.awt.Dimension(40, 40));
        previousBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previousBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtActionPerformed(evt);
            }
        });
        //添加快捷键
        previousBt.registerKeyboardAction(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtActionPerformed(evt);
            }}, KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
            myToolBar.add(previousBt);

            nextBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go-next-4.png"))); // NOI18N
            nextBt.setToolTipText("前进（PAGE DOWN）");
            nextBt.setFocusable(false);
            nextBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            nextBt.setMinimumSize(new java.awt.Dimension(45, 63));
            nextBt.setPreferredSize(new java.awt.Dimension(40, 40));
            nextBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            nextBt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nextBtActionPerformed(evt);
                }
            });
            //添加快捷键
            nextBt.registerKeyboardAction(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nextBtActionPerformed(evt);
                }}, KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
                myToolBar.add(nextBt);

                lastBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go-last-2.png"))); // NOI18N
                lastBt.setToolTipText("结束");
                lastBt.setFocusable(false);
                lastBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                lastBt.setMinimumSize(new java.awt.Dimension(45, 63));
                lastBt.setPreferredSize(new java.awt.Dimension(40, 40));
                lastBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                lastBt.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        lastBtActionPerformed(evt);
                    }
                });
                myToolBar.add(lastBt);

                gotoFd.setMaximumSize(new java.awt.Dimension(35, 30));
                gotoFd.setMinimumSize(new java.awt.Dimension(35, 30));
                gotoFd.setPreferredSize(new java.awt.Dimension(35, 30));
                myToolBar.add(gotoFd);

                gotoBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goto.png"))); // NOI18N
                gotoBt.setToolTipText("跳转");
                gotoBt.setFocusable(false);
                gotoBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                gotoBt.setMinimumSize(new java.awt.Dimension(45, 63));
                gotoBt.setPreferredSize(new java.awt.Dimension(40, 40));
                gotoBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                gotoBt.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        gotoBtActionPerformed(evt);
                    }
                });
                myToolBar.add(gotoBt);

                autoStartBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-playback-start-3.png"))); // NOI18N
                autoStartBt.setToolTipText("开启自动播放");
                autoStartBt.setFocusable(false);
                autoStartBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                autoStartBt.setMinimumSize(new java.awt.Dimension(45, 63));
                autoStartBt.setPreferredSize(new java.awt.Dimension(40, 40));
                autoStartBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                autoStartBt.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        autoStartBtActionPerformed(evt);
                    }
                });
                myToolBar.add(autoStartBt);

                pauseBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media-playback-pause-3.png"))); // NOI18N
                pauseBt.setToolTipText("停止自动播放");
                pauseBt.setFocusable(false);
                pauseBt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                pauseBt.setMinimumSize(new java.awt.Dimension(45, 63));
                pauseBt.setPreferredSize(new java.awt.Dimension(40, 40));
                pauseBt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                pauseBt.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        pauseBtActionPerformed(evt);
                    }
                });
                myToolBar.add(pauseBt);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datetimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(myToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(datetimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void fullScreenBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullScreenBtActionPerformed
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        // 全屏设置
        gd.setFullScreenWindow(this);

        initLayout();
        showTitleImage();
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_fullScreenBtActionPerformed

    private void backBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtActionPerformed
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);

        initLayout();
        showTitleImage();
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_backBtActionPerformed

    private void closeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtActionPerformed

    private void firstBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstBtActionPerformed
        current_index_no = 0;
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_firstBtActionPerformed

    private void previousBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtActionPerformed
        current_index_no = current_index_no - 1;
        if (current_index_no <= 0) {
            current_index_no = 0;
        }
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_previousBtActionPerformed

    private void nextBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtActionPerformed
        current_index_no = current_index_no + 1;
        if (current_index_no >= tableModel.getRowCount()) {
            current_index_no = tableModel.getRowCount() - 1;
        }
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_nextBtActionPerformed

    private void lastBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastBtActionPerformed
        current_index_no = tableModel.getRowCount() - 1;
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_lastBtActionPerformed

    private void gotoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoBtActionPerformed
        //输入拍品序号，即图录号前面的0去掉，例如005号拍品则输入5即可
        int gotoNo = Integer.parseInt(gotoFd.getText());
        current_index_no = gotoNo - 1;
        showGoodsInfo(current_index_no);
    }//GEN-LAST:event_gotoBtActionPerformed

    private void autoStartBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoStartBtActionPerformed
        try {
            if (autoPlayThread == null) {
                log.debug("开始自动播放！");
                autoPlayThread = new AutoPlayThread();
                autoPlayThread.start();
            } else {
                //如果已经退出循环播放，则再重新开始
                if (!autoPlayState && autoPlayThread.getState() == Thread.State.TERMINATED) {
                    log.debug("继续自动播放！");
                    autoPlayThread = new AutoPlayThread();
                    autoPlayThread.start();
                }
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }//GEN-LAST:event_autoStartBtActionPerformed

    private void pauseBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtActionPerformed
        if (autoPlayThread != null && autoPlayThread.isAlive()) {
            autoPlayState = false;
        }
    }//GEN-LAST:event_pauseBtActionPerformed

    class AutoShowTimeThread extends Thread {

        @Override
        public void run() {
            showTime();
        }

        private void showTime() {
            try {
                while (true) {
                    //拼装时间
                    java.util.Date date = new java.util.Date();
                    String weektime = DateFormatUtils.format(date, "E");
                    String datetime = DateFormatUtils.format(date, "yyyy年MM月dd日 HH:mm:ss");
                    String s = s_datetime.replaceAll("weektime", weektime);
                    s = s.replaceAll("datetime", datetime);
                    datetimeLabel.setText(s);
                    //sleep(500);
                }
            } catch (Exception ex) {
                log.debug("error:", ex);
            }
        }
    }

    /**
     * 自动播放线程
     */
    class AutoPlayThread extends Thread {

        @Override
        public void run() {
            autoPlay();
        }

        private void autoPlay() {
            autoPlayState = true;
            try {
                while (true) {
                    showGoodsInfo(current_index_no);
                    current_index_no = current_index_no + 1;
                    //如果循环至最后一页则重头开始
                    if (current_index_no == tableModel.getRowCount()) {
                        current_index_no = 0;
                    }

                    //如果停止播放，则退出循环
                    if (!autoPlayState) {
                        log.debug("停止播放，退出循环！");
                        break;
                    }
                    //休息6秒钟
                    sleep(1000 * 6);
                }
            } catch (Exception ex) {
                log.error("error:", ex);
            }
        }
    }
    //项目编号
    private String projectNo;
    //列表数据
    private TableModel tableModel;
    //传入序号
    private int indexNo;
    //当前序号
    private int current_index_no;
//    //拍品图像存储根路径
//    private String imageRootPath;
//    //拍品图像存储临时根路径
//    private String temp_imageRootPath;
    //循环播放状态
    private boolean autoPlayState = false;
    //循环播放线程
    private AutoPlayThread autoPlayThread;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton autoStartBt;
    private org.jdesktop.swingx.JXButton backBt;
    private org.jdesktop.swingx.JXButton closeBt;
    private org.jdesktop.swingx.JXLabel datetimeLabel;
    private org.jdesktop.swingx.JXLabel descLabel;
    private org.jdesktop.swingx.JXButton firstBt;
    private org.jdesktop.swingx.JXButton fullScreenBt;
    private org.jdesktop.swingx.JXButton gotoBt;
    private org.jdesktop.swingx.JXTextField gotoFd;
    private org.jdesktop.swingx.JXLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXButton lastBt;
    private javax.swing.JToolBar myToolBar;
    private org.jdesktop.swingx.JXButton nextBt;
    private org.jdesktop.swingx.JXButton pauseBt;
    private org.jdesktop.swingx.JXButton previousBt;
    private org.jdesktop.swingx.JXLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
