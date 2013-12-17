--20131217---------
--1.拍品清单增加作者字段
ALTER TABLE "HRXC"."GOODS_LIST"
	ADD COLUMN "AUTHOR" VARCHAR(32);
--2.拍品清单增加入库号字段
ALTER TABLE "HRXC"."GOODS_LIST"
	ADD COLUMN "DEPOT_NO" VARCHAR(20)
;
--3.项目信息表中增加默认保证金字段
ALTER TABLE "HRXC"."PROJECT_INFO"
	ADD COLUMN "CASH_DEPOSIT" INTEGER NOT NULL DEFAULT 0
;