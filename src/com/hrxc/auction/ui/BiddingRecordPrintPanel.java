package com.hrxc.auction.ui;

import com.hrxc.auction.action.BargainRecordAction;
import com.hrxc.auction.action.BiddingPaddleAction;
import com.hrxc.auction.action.GoodsListAction;
import com.hrxc.auction.domain.BargainRecord;
import com.hrxc.auction.domain.BiddingPaddle;
import com.hrxc.auction.util.Constant;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 竞买号牌信息打印
 *
 * @author user
 */
public class BiddingRecordPrintPanel extends AbstractPrintPanel {

    private static final Logger log = Logger.getLogger(BiddingRecordPrintPanel.class);
    private String pkId_biddingPaddle;
    private String printType;

    public BiddingRecordPrintPanel() {
    }

    public BiddingRecordPrintPanel(String pkId_biddingPaddle, String printType) {
        this.pkId_biddingPaddle = pkId_biddingPaddle;
        this.printType = printType;
    }

    @Override
    public void drawPage(Graphics2D g2) {
        if (printType.equals(Constant.PrintType.TYPE_PADDLE_INFO_PRINT)) {
            drawPage_paddleInfo(g2);
        } else if (printType.equals(Constant.PrintType.TYPE_SETTLE_LIST_PRINT)) {
            drawPage_settleList(g2);
        }
    }

    /**
     * 输出竞买号牌数据信息
     *
     * @param g2
     */
    private void drawPage_paddleInfo(Graphics2D g2) {
        BiddingPaddle dto = BiddingPaddleAction.getObjectById(pkId_biddingPaddle);
        log.debug("print panel dto.pkId=" + dto.getPkId());

        Font titleFont = new Font("黑体", Font.PLAIN, 18);
        g2.drawString(getFontedAttributedString(titleFont,"北京华软信诚拍卖行有限公司竞买号牌登记表"), 90, 70);

        g2.drawString("竞买人姓名：".concat(dto.getCustName()), 10, 110);
        g2.drawString("竞买号牌：".concat(dto.getPaddleNo()), 300, 110);

        g2.drawString("证件名称：".concat(dto.getCertType()), 10, 140);
        g2.drawString("证件号码：".concat(dto.getCertNo()), 300, 140);

        g2.drawString("联系方式：".concat(dto.getCustTel()), 10, 170);

        g2.drawString("通讯地址：".concat(dto.getCustAddr()), 10, 200);

        g2.drawString("保证金（元）：￥".concat(dto.getCashDeposit().toString()), 10, 230);

        g2.drawString("竞买人签字：", 300, 270);
        g2.drawString("日期：", 300, 310);
    }

    /**
     * 输出结款单信息
     *
     * @param g2
     */
    private void drawPage_settleList(Graphics2D g2) {
        //竞买号牌信息
        BiddingPaddle dto = BiddingPaddleAction.getObjectById(pkId_biddingPaddle);
        log.debug("print panel dto.pkId=" + dto.getPkId());

        //成交记录信息
        String paddleNo = dto.getPaddleNo();
        List<BargainRecord> list = BargainRecordAction.getBargainRecordListByPaddleNo(paddleNo);

        Font titleFont_14 = new Font("黑体", Font.PLAIN, 14);
        Font titleFont_20 = new Font("黑体", Font.PLAIN, 20);
        Font titleFont_10 = new Font("宋体", Font.PLAIN, 10);

        AttributedString ats =
                new AttributedString("北京华软信诚拍卖行有限公司");
        ats.addAttribute(TextAttribute.FONT, titleFont_14);
        g2.drawString(ats.getIterator(), 160, 20);
        ats =
                new AttributedString("结  款  单");
        ats.addAttribute(TextAttribute.FONT, titleFont_20);
        g2.drawString(ats.getIterator(), 200, 40);


        g2.drawString("竞买人姓名：".concat(dto.getCustName()), 10, 60);
        g2.drawString("证件号码：".concat(dto.getCertNo()), 150, 60);
        g2.drawString("竞买号牌：".concat(dto.getPaddleNo()), 360, 60);

        g2.drawRect(5, 65, 520, 270);

        g2.drawString(getFontedAttributedString(titleFont_10,"阁下您好："), 10, 75);
        g2.drawString(getFontedAttributedString(titleFont_10,"您已竞得如下拍品，请认真核对以下信息，并交纳相关费用。"), 30, 90);

        //输出列表数据
        int y_coord = 105;
        int x_coord_paddleNo = 10;
        int x_coord_paddleName = 50;
        int x_coord_hammerPrice = 250;
        int x_coord_commission = 320;
        int x_coord_otherFund = 380;
        int x_coord_bargainPrice = 460;
        g2.drawString(getFontedAttributedString(titleFont_10,"图录号"), x_coord_paddleNo, y_coord);
        g2.drawString(getFontedAttributedString(titleFont_10,"名称"), x_coord_paddleName, y_coord);
        g2.drawString(getFontedAttributedString(titleFont_10,"落锤价（元）"), x_coord_hammerPrice, y_coord);
        g2.drawString(getFontedAttributedString(titleFont_10,"佣金（元）"), x_coord_commission, y_coord);
        g2.drawString(getFontedAttributedString(titleFont_10,"其他费用（元）"), x_coord_otherFund, y_coord);
        g2.drawString(getFontedAttributedString(titleFont_10,"合计（元）"), x_coord_bargainPrice, y_coord);

        //成交笔数
        int settleList_num = 0;
        //总成交金额
        int totalAmount = 0;
        if (list != null && list.size() > 0) {
            settleList_num = list.size();
            for (int i = 0; i < list.size(); i++) {
                BargainRecord rec = list.get(i);
                y_coord = y_coord + 14;
                g2.drawString(getFontedAttributedString(titleFont_10,rec.getGoodsNo()), x_coord_paddleNo, y_coord);
                g2.drawString(getFontedAttributedString(titleFont_10,GoodsListAction.getGoodsListByGoodsNo(rec.getGoodsNo()).getGoodsName()), x_coord_paddleName, y_coord);
                g2.drawString(getFontedAttributedString(titleFont_10,String.valueOf(rec.getHammerPrice())), x_coord_hammerPrice, y_coord);
                g2.drawString(getFontedAttributedString(titleFont_10,String.valueOf(rec.getCommission())), x_coord_commission, y_coord);
                g2.drawString(getFontedAttributedString(titleFont_10,String.valueOf(rec.getOtherFund())), x_coord_otherFund, y_coord);
                g2.drawString(getFontedAttributedString(titleFont_10,String.valueOf(rec.getBargainPrice())), x_coord_bargainPrice, y_coord);
                totalAmount = totalAmount + rec.getBargainPrice();
            }
        }

        g2.drawString("合计件数：".concat(String.valueOf(settleList_num)), 10, 350);
        g2.drawString("总金额：".concat(String.valueOf(totalAmount)), 150, 350);
        g2.drawString("竞买人签字：", 360, 350);
    }

    /**
     * 获取指定字体设定的字体
     * @param font
     * @param str
     * @return 
     */
    private AttributedCharacterIterator getFontedAttributedString(Font font, String str) {
        AttributedString ats =
                new AttributedString(str);
        ats.addAttribute(TextAttribute.FONT, font);
        return ats.getIterator();
    }
}
