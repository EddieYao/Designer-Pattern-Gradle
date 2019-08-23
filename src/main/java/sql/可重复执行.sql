-- #mysql

 USE BSSP;

 
-- 创建表前判断表是否存在
 CREATE TABLE
 IF NOT EXISTS sso_user (
 	OID VARCHAR (40) NOT NULL COMMENT 'GUID主键',
 	ORG_CODE VARCHAR (50) DEFAULT NULL COMMENT '所属机构代码',
 	PRIMARY KEY (OID)
 ) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '用户信息表';



-- 添加表字段前判断字段是否存在（创建存储过程） 一次运行
-- （非管理员用户，无需执行存储过程，由管理员执行）
USE BSSP;
 DROP PROCEDURE IF EXISTS addTableField;  -- 删除已存在的存储过程

 DELIMITER ;;
 CREATE PROCEDURE addTableField(  -- 存储过程名称
 	in _database VARCHAR(20),     -- 数据库名
 	in _tablename VARCHAR(30),    -- 表名
 	in _tablefield VARCHAR(20),   -- 字段名
 	in _sql VARCHAR(200)          -- sql语句
 )
 BEGIN

 set @sql=_sql;
 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = _database AND table_name = _tablename AND column_name = _tablefield ) THEN
 		PREPARE s from @sql;
 		EXECUTE s;
 		DEALLOCATE PREPARE s;
 		SELECT(concat('数据库：',_database,'表：',_tablename,'字段：',_tablefield,'添加成功！'));
 ELSE
 		SELECT(concat('数据库：',_database,'表：',_tablename,'字段：',_tablefield,'已存在！'));
 END IF;

 END;;
 DELIMITER ;

 -- 调用执行存储过程
CALL addTableField("sso_copy","sso_user","new_field","ALTER TABLE sso_copy.sso_user ADD COLUMN new_field VARCHAR(50);");   -- 填写数据库，表，字段，新增字段语句

CALL addTableField("bssp_entry","entry_list","GROSS_WET3","ALTER TABLE bssp_entry.entry_list ADD COLUMN GROSS_WET3 decimal(14,5) NULL  COMMENT '1' ;");




-- 修改表字段前判断字段是否存在（创建存储过程） 一次运行
USE BSSP;
 DROP PROCEDURE IF EXISTS editTableField;   -- 删除已存在的存储过程

 DELIMITER ;;
 CREATE PROCEDURE editTableField(  -- 存储过程名称
 	in _database VARCHAR(20),      -- 数据库名
 	in _tablename VARCHAR(30),     -- 表名
 	in _tablefield VARCHAR(20),    -- 字段名
 	in _sql VARCHAR(200)           -- sql语句
 )
 BEGIN

 set @sql_editField=_sql;
 IF EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = _database AND table_name = _tablename AND column_name = _tablefield ) THEN
 		PREPARE s from @sql_editField;
 		EXECUTE s;
 		DEALLOCATE PREPARE s;
 		SELECT(concat('数据库：',_database,'表：',_tablename,'字段：',_tablefield,'修改成功！'));   -- 字段存在，修改成功，提示信息
 ELSE
 		SELECT(concat('数据库：',_database,'表：',_tablename,'字段：',_tablefield,'不存在！'));     -- 字段不存在，提示信息
 END IF;

 END;;
 DELIMITER ;

-- 执行存储过程
CALL editTableField("sso_copy","sso_user","new_field","ALTER TABLE sso_copy.sso_user MODIFY COLUMN new_field VARCHAR(50);");  -- 数据库，表，字段，修改字段语句
CALL editTableField("bssp_rep","rep_img_config","STOCK_CONTROL_QTY","ALTER TABLE bssp_rep.rep_img_config MODIFY COLUMN STOCK_CONTROL_QTY  varchar(1) NULLCOMMENT '库存调整数量(+)' ;");


-- 添加表记录前判断该记录是否存在
-- 创建存储过程
use bssp;
DROP PROCEDURE IF EXISTS insertTable;

 DELIMITER ;;
 CREATE PROCEDURE insertTable(
 	in _sql VARCHAR(1000)
 )
BEGIN
 declare inv_c int default 0;
 DECLARE CONTINUE HANDLER FOR SQLEXCEPTION,SQLWARNING,NOT FOUND
	set inv_c=1;
	set @sql=_sql;
	PREPARE s from @sql;
	EXECUTE s;
	DEALLOCATE PREPARE s;
	if(inv_c=1) THEN
		select('执行失败！');
	ELSE
		SELECT('执行成功！');
	END IF;

 END;;
 DELIMITER ;

-- 调用存储过程
-- " 这是两个单引号
call insertTable('INSERT INTO bssp_cod.EDI_SEQ_INFO (OID, AREA_CODE, DOC_TYPE, MODEL_NAME, DATE_RULE, MASK, COUNTER_LENGTH, SERVER_TYPE, STATUS, TRANS_MODE, REMARKS, CREATE_BY, CREATE_NAME, CREATE_TIME, UPDATE_BY, UPDATE_NAME, UPDATE_TIME) VALUES ("2c90801b6394ec85016394ec85310000", "490101", "A0611SeqNO", "物流先入区后报关核注清单（统一编号）", "YYMM", "wuliu", "7", "C", "Y", NULL, NULL, "1", "系统管理员", "2018-03-20 03:40:56", "1", "系统管理员", "2018-03-20 03:40:56");');


-- 创建存储过程
use bssp;
DROP PROCEDURE IF EXISTS updateTable;

 DELIMITER ;;
 CREATE PROCEDURE updateTable(
 	in _sql VARCHAR(1000)
 )
BEGIN
 declare inv_c int default 0;
 DECLARE CONTINUE HANDLER FOR SQLEXCEPTION,SQLWARNING,NOT FOUND
	set inv_c=1;
	set @sql=_sql;
	PREPARE s from @sql;
	EXECUTE s;
	DEALLOCATE PREPARE s;
	if(inv_c=1) THEN
		select(CONCAT(_sql,'执行失败！'));
	ELSE
		SELECT('执行成功！');
	END IF;

 END;;
 DELIMITER ;

 -- 调用存储过程
 -- 无需写表空间名  双引号改为两个单引号 ！
call updateTable(''UPDATE sso_pro_func SET FUNCTION_NAME="报关入区核放单" WHERE OID="2c90809963bf99a00163ce9d543c10a2";'');


-- 添加索引可重复执行
DROP PROCEDURE
IF EXISTS add_Index;
delimiter //
CREATE PROCEDURE add_Index (
	IN p_dbname VARCHAR (200),
	IN p_tablename VARCHAR (200),
	IN p_idxname VARCHAR (200),
	IN p_index VARCHAR (200)
)
BEGIN
	DECLARE
		str VARCHAR (250);

SET @str = concat(
	' ALTER TABLE ',
	p_dbname,'.',p_tablename,
	' ADD INDEX ',
	p_index
);

SELECT
	count(*) INTO @cnt
FROM
	information_schema.statistics
WHERE
	TABLE_SCHEMA = p_dbname
AND table_name = p_tablename
AND index_name = p_idxname;

IF @cnt <= 0 THEN
	SELECT(concat('数据库：',p_dbname,'表：',p_tablename,'索引：',p_idxname,'添加成功！'));
	PREPARE stmt FROM 	@str;
  EXECUTE stmt;
ELSE
	SELECT(concat('数据库：',p_dbname,'表：',p_tablename,'索引：',p_idxname,'已存在！'));
END
IF;

END;

use bssp;
CALL add_Index (
    'bssp_sas',
    'sas_passport_cus_bsc',
    'INDEX_CUS_SEQ_NO',
    'INDEX_CUS_SEQ_NO (`SEQ_NO`) USING BTREE '
);

-- 复制表+数据
CREATE TABLE bssp_npts.npts_eml_consume_old AS SELECT * FROM npts_eml_consume;


1、既复制表结构也复制表内容的SQL语句：CREATE TABLE tab_new AS SELECT * FROM tab_old;
2、只复制表结构不复制表内容的SQL语句：CREATE TABLE tab_new AS SELECT * FROM tab_old WHERE 1=2;
3、不复制表结构，只复制内容的sql语句：insert into tab_new select * from tab_old;或者SELECT vale1, value2 into Table2 from Table1

-- #oracle

-- 创建表前判断表是否存在(创建存储过程)
CREATE OR REPLACE
PROCEDURE "CREATE_TABLE" (tablename IN VARCHAR2, sql_create IN clob)   -- 创建或更新存储过程  带参数（表名，创建表语句）
AUTHID CURRENT_USER
AS
 num number;
 temp VARCHAR2(5000);
Cursor cursor2 is	SELECT REGEXP_SUBSTR(sql_create, '([^;]+)', 1, ROWNUM) str FROM DUAL CONNECT BY ROWNUM <(LENGTH(REGEXP_REPLACE(sql_create, '[^;]', '')) + 2);
 -- cursor2 VARCHAR%rowtype;
BEGIN

 	select count(1) into num from user_tables where TABLE_NAME = tablename;
 if num=0 then
open cursor2;
 loop
		exit when cursor2%notfound;
		FETCH cursor2 INTO temp;
		if temp is not null then
		--dbms_output.put_line(temp);
		execute immediate(temp);end if;end loop;close cursor2;dbms_output.put_line(concat(tablename,'表创建成功！')); ELSE dbms_output.put_line(concat(tablename,'表已经存在！')); end if;END;
/

 -- 执行存储过程
BEGIN
		CREATE_TABLE ('EMS_SUBSIDIARY_LEDGER','CREATE TABLE "EMS_SUBSIDIARY_LEDGER" ("OID" NVARCHAR2(32) NOT NULL )
LOGGING
NOCOMPRESS
NOCACHE
;
COMMENT ON TABLE "EMS_SUBSIDIARY_LEDGER" IS ''明细表'';
COMMENT ON COLUMN "EMS_SUBSIDIARY_LEDGER"."OID" IS ''流水号'';
ALTER TABLE "EMS_SUBSIDIARY_LEDGER" ADD CHECK ("OID" IS NOT NULL);
ALTER TABLE "EMS_SUBSIDIARY_LEDGER" ADD PRIMARY KEY ("OID");') ;
END ;
/


-- 添加表字段前判断字段是否存在(创建存储过程)
 CREATE OR REPLACE
 PROCEDURE "ADD_TABLE_COLUMN" (tablename IN VARCHAR2, tablecolumn IN VARCHAR2, sql_add_column IN VARCHAR2)   -- 创建或更新存储过程  带参数（表名，字段名，添加字段语句）
 AS
 num number;
 BEGIN
   SELECT COUNT(1)
     INTO num
     from all_tab_columns
   where TABLE_NAME  = tablename AND COLUMN_NAME  = tablecolumn;
   IF num = 0 THEN
       execute immediate sql_add_column;
 			dbms_output.put_line(concat(concat(concat(concat('表',tablename),'字段'),tablecolumn),'添加成功！'));  -- 字段不存在，添加字段，提示信息
 	ELSE
 			dbms_output.put_line(concat(concat(concat(concat('表',tablename),'字段'),tablecolumn),'已存在！'));    -- 字段存在，提示信息
   END IF;END;
/
-- 执行存储过程
 BEGIN
 	ADD_TABLE_COLUMN('NEW_TEST_TABLE','NEW_TEST_TABLE_COLUMN','ALTER TABLE NEW_TEST_TABLE ADD (NEW_TEST_TABLE_COLUMN VARCHAR(50) default ''空'' not null)');  -- 表名，字段名，添加字段语句
 END;
/

-- 修改表字段前判断字段是否存在(创建存储过程)
CREATE OR REPLACE
PROCEDURE "MODIFY_TABLE_COLUMN" (tablename IN VARCHAR2, tablecolumn IN VARCHAR2, sql_modify_column IN VARCHAR2)
AS
num number;
BEGIN
SELECT COUNT(1)
	INTO num
	-- from all_tab_columns
 from user_tab_columns
where  TABLE_NAME  = tablename AND COLUMN_NAME  = tablecolumn;
IF num = 0 THEN
		dbms_output.put_line(concat(concat(concat(concat('表',tablename),'字段'),tablecolumn),'不存在！'));
ELSE
		execute immediate sql_modify_column;
		dbms_output.put_line(concat(concat(concat(concat('表',tablename),'字段'),tablecolumn),'修改成功！'));
end if;END;
--  执行存储过程
BEGIN
MODIFY_TABLE_COLUMN('ET_ARCRP_ACMP_FORM_DT','TGBL_LOSS_RATE','ALTER TABLE ET_ARCRP_ACMP_FORM_DT RENAME COLUMN TGBL_LOSS_RATE to ACMP_FORM_FILE_SIZE');  -- 表名，字段名，修改字段语句
END;
/
-- 添加表记录前判断记录是否存在
CREATE OR REPLACE
PROCEDURE "TABLE_INSERT" (sql_sql in VARCHAR2)   -- 创建或更新存储过程  带参数（表名，创建表语句）
 AS
 BEGIN
DBMS_OUTPUT.ENABLE (buffer_size=>null);
execute immediate sql_sql;
dbms_output.put_line('执行语句成功！');
EXCEPTION
	when others then
  dbms_output.put_line('执行语句失败！');   -- 表不存在，创建表，提示信息
 END;
/
-- 调用存储过程过程
BEGIN
TABLE_INSERT('INSERT INTO EDI_SEQ_INFO (OID, AREA_CODE, DOC_TYPE, MODEL_NAME, DATE_RULE, MASK, COUNTER_LENGTH, SERVER_TYPE, STATUS, TRANS_MODE, REMARKS, CREATE_BY, CREATE_NAME, CREATE_TIME, UPDATE_BY, UPDATE_NAME, UPDATE_TIME) VALUES (''2c90801b6394ec85016394ec85310000'', ''490101'', ''A0611SeqNO'', ''物流先入区后报关核注清单（统一编号）'', ''YYMM'', ''wuliu'', ''7'', ''C'', ''Y'', NULL, NULL, ''1'', ''系统管理员'', TO_DATE(''2018-03-20 03:40:56'', ''SYYYY-MM-DD HH24:MI:SS''), ''1'', ''系统管理员'', TO_DATE(''2018-03-20 03:40:56'', ''SYYYY-MM-DD HH24:MI:SS''))');
END;
/
-- 修改表记录前判断记录是否存在
-- 修改表记录前判断记录是否存在
CREATE OR REPLACE
PROCEDURE "TABLE_UPDATE" (sql_sql in VARCHAR2)   -- 创建或更新存储过程  带参数（表名，创建表语句）
 AS
 BEGIN
DBMS_OUTPUT.ENABLE (buffer_size=>null);
execute immediate sql_sql;
dbms_output.put_line('执行语句成功！');
EXCEPTION
	when others then
  dbms_output.put_line(sql_sql||'执行语句失败！');   -- 表不存在，创建表，提示信息
 END;
-- 调用存储过程过程
BEGIN
TABLE_UPDATE('UPDATE sso_role_func SET FUNCTION_NAME=''报关入区核放单'' WHERE OID=''2c90801b638ff83701639b7bda130db5''');
END;
/
-- 添加索引存储过程
 CREATE OR REPLACE
PROCEDURE "ADD_TABLE_INDEX" (tablename IN VARCHAR2, tableindex IN VARCHAR2, sql_add_index IN VARCHAR2)   -- 创建或更新存储过程  带参数（表名，索引名，添加索引语句）
 AS
 num number;
 BEGIN
   SELECT COUNT(1)
     INTO num
     from user_ind_columns
   where TABLE_NAME  = tablename AND INDEX_name  = tableindex;
   IF num = 0 THEN
       execute immediate sql_add_index;
 			dbms_output.put_line(concat(concat(concat(concat('表',tablename),'索引'),tableindex),'添加成功！'));  -- 索引不存在，添加索引，提示信息
 	ELSE
 			dbms_output.put_line(concat(concat(concat(concat('表',tablename),'索引'),tableindex),'已存在！'));    -- 索引存在，提示信息
   END IF;END;
/
BEGIN
 	ADD_TABLE_INDEX('SAS_PASSPORT_BSC','INDEX_SEQ_NO','CREATE INDEX "INDEX_SEQ_NO" ON "SAS_PASSPORT_BSC" ("SEQ_NO" ASC)');
END;
/

-- 删表存储过程
CREATE OR REPLACE
PROCEDURE "DROP_TABLE" (p_table IN VARCHAR2) IS v_count NUMBER (10) ;
BEGIN
	SELECT
		COUNT (*) INTO v_count
	FROM
		user_tables
	WHERE
		table_name = UPPER (p_table) ;
	IF v_count > 0 THEN
		EXECUTE IMMEDIATE 'drop table ' || p_table || ' purge' ;
	END IF ;END;
/

-- 删视图存储过程
CREATE OR REPLACE
PROCEDURE "DROP_VIEW" (p_view IN VARCHAR2) IS v_count NUMBER (10) ;
BEGIN
	SELECT
		COUNT (*) INTO v_count
	FROM
		user_views
	WHERE
		view_name = UPPER (p_view) ;
	IF v_count > 0 THEN
		EXECUTE IMMEDIATE 'drop view ' || p_view ;
		dbms_output.put_line(p_view||':视图已删除');
	END IF ;END;
/

-- 复制表
1、只复制表结构的sql
create table b as select * from a where 1<>1

2、即复制表结构又复制表中数据的sql
create table b as select * from a
　　

3、Oracle复制表的制定字段的sql
create table b as select row_id,name,age from a where 1<>1
　　
前提是row_id,name,age都是a表的列

4、复制表的指定字段及这些指定字段的数据的sql
create table b as select row_id,name,age from a
　　

以上语句虽然能够很容易的根据a表结构复制创建b表，但是a表的索引等却复制不了，需要在b中手动建立。

5、insert into 会将查询结果保存到已经存在的表中
DELETE FROM bssp_cod.cod_cus_customsrel;
insert into bssp_cod.cod_cus_customsrel(CUSTOMS_CODE, CUSTOMS_NAME)
select CUSTOMS_CODE, ABBR_CUST from bssp_cod.cod_cus_customsfec;