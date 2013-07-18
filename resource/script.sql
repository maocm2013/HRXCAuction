--拍品清单
CREATE TABLE "GOODS_LIST" (
	"PK_ID" text NOT NULL PRIMARY KEY UNIQUE, --主键
	"GOODS_NO" text, --物品编号
	"GOODS_NAME" text, --物品名称
	"GOODS_INTACT" text, --完残度
	"GOODS_SIZE" text, --尺寸
	"CERTIFICATE_NO" text, --证书编号
  "KEEP_PRICE" Integer, --保守价格
  "MARKET_PRICE" Integer, --市场价格
  "ONSET_PRICE" Integer --起拍价
);

--竞拍号牌登记表
CREATE TABLE "BIDDING_PADDLE" (
	"PK_ID" text NOT NULL PRIMARY KEY UNIQUE, --主键
	"PADDLE_NO" text, --号牌编号
	"CUST_NAME" text, --客户名称
	"CERT_TYPE" text, --证件类型
	"CERT_NO" text, --证件号
	"CUST_TEL" text, --联系电话
  "CUST_ADDR" text, --联系地址
  "CASH_DEPOSIT" Integer, --保证金
  "REMARKS" text --备注
);

--成交记录表
CREATE TABLE "BARGAIN_RECORD" (
	"PK_ID" text NOT NULL PRIMARY KEY UNIQUE, --主键
	"PADDLE_NO" text, --号牌编号
	"GOODS_NO" text, --物品编号
	"BARGAIN_CONFIRM_NO" text, --成交确认书编号
	"HAMMER_PRICE" Integer, --落锤价
	"COMMISSION" Integer, --佣金
	"OTHER_FUND" Integer, --其他款项
  "BARGAIN_PRICE" Integer, --成交价
  "ACCOUNT_PAID" Integer, --已付款
  "NON_PAYMENT" Integer --未付款
);
