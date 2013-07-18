CREATE TABLE "NOTE_INFO" (
	"PK_ID" text NOT NULL PRIMARY KEY UNIQUE, --主键
	"NOTE_NAME" text, --任务名称
	"NOTE_COMMENT" text, --任务备注
	"DEAD_LINE_DATE" text, --到期日期
	PRIORITY text, --优先级
	"NOTE_STATE" text, --任务状态
        "REMIND_TIME" text --提醒时间
);
