--拍品清单
CREATE TABLE [GOODS_LIST] (
  [PK_ID] text NOT NULL, 
  [GOODS_NO] text UNIQUE, 
  [GOODS_NAME] text, 
  [GOODS_INTACT] text, 
  [GOODS_SIZE] text, 
  [CERTIFICATE_NO] text, 
  [KEEP_PRICE] Integer, 
  [MARKET_PRICE] Integer, 
  [ONSET_PRICE] Integer, 
  CONSTRAINT [] PRIMARY KEY ([PK_ID]));

--竞拍号牌登记表
CREATE TABLE [BIDDING_PADDLE] (
  [PK_ID] text NOT NULL, 
  [PADDLE_NO] text UNIQUE, 
  [CUST_NAME] text, 
  [CERT_TYPE] text, 
  [CERT_NO] text, 
  [CUST_TEL] text, 
  [CUST_ADDR] text, 
  [CASH_DEPOSIT] Integer, 
  [REMARKS] text, 
  CONSTRAINT [] PRIMARY KEY ([PK_ID]));

--成交记录表
CREATE TABLE "BARGAIN_RECORD" ("PK_ID" text NOT NULL PRIMARY KEY,"PADDLE_NO" text,"GOODS_NO" text,"BARGAIN_CONFIRM_NO" text,"HAMMER_PRICE" Integer,COMMISSION Integer,"OTHER_FUND" Integer,"BARGAIN_PRICE" Integer,"ACCOUNT_PAID" Integer,"NON_PAYMENT" Integer);

CREATE UNIQUE INDEX IDX_BARGAIN_RECORD ON "BARGAIN_RECORD" (PADDLE_NO,GOODS_NO);

