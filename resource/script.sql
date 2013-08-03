重要说明：
运行ij.bat进行ij，进行命令交互
首次建立新库，并使用hrxc用户名：connect 'jdbc:derby://localhost:1527/auctiondb;user=hrxc;create=true';
建立连接：connect 'jdbc:derby://localhost:1527/auctiondb;user=hrxc';
服务启动后，如果通过网络无法联通derby数据库，则需要将start...Server.bat与stop...Server.bat中localhost修改为物理实际IP地址，然后再启动；

CREATE TABLE HRXC.BARGAIN_RECORD  ( 
    PK_ID             	VARCHAR(32) NOT NULL,
    PADDLE_NO         	VARCHAR(20),
    GOODS_NO          	VARCHAR(20),
    BARGAIN_CONFIRM_NO	VARCHAR(32),
    HAMMER_PRICE      	INTEGER,
    COMMISSION        	INTEGER,
    OTHER_FUND        	INTEGER,
    BARGAIN_PRICE     	INTEGER,
    ACCOUNT_PAID      	INTEGER,
    NON_PAYMENT       	INTEGER,
    CONSTRAINT PK_BARGAIN_RECORD PRIMARY KEY(PK_ID)
);
CREATE TABLE HRXC.BIDDING_PADDLE  ( 
    PK_ID       	VARCHAR(32) NOT NULL,
    PADDLE_NO   	VARCHAR(20),
    CUST_NAME   	VARCHAR(32),
    CERT_TYPE   	VARCHAR(20),
    CERT_NO     	VARCHAR(32),
    CUST_TEL    	VARCHAR(32),
    CUST_ADDR   	VARCHAR(128),
    CASH_DEPOSIT	INTEGER,
    REMARKS     	VARCHAR(128),
    CONSTRAINT PK_BIDDING_PADDLE PRIMARY KEY(PK_ID)
);
CREATE TABLE HRXC.GOODS_LIST  ( 
    PK_ID         	VARCHAR(32) NOT NULL,
    GOODS_NO      	VARCHAR(20),
    GOODS_NAME    	VARCHAR(128),
    GOODS_INTACT  	VARCHAR(128),
    GOODS_SIZE    	VARCHAR(64),
    CERTIFICATE_NO	VARCHAR(32),
    KEEP_PRICE    	INTEGER,
    MARKET_PRICE  	INTEGER,
    ONSET_PRICE   	INTEGER,
    CONSTRAINT PK_GOODS_LIST PRIMARY KEY(PK_ID)
);
CREATE TABLE HRXC.USER_INFO  ( 
    PK_ID    	VARCHAR(32) NOT NULL,
    USER_NO  	VARCHAR(20) NOT NULL,
    USER_NAME	VARCHAR(20),
    PASSWORD 	VARCHAR(64),
    CONSTRAINT PK_USER_INFO PRIMARY KEY(PK_ID)
);