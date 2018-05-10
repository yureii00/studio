ALTER TABLE `remote_repository` DROP COLUMN `remote_branch` ;

UPDATE `audit` SET `source` = 'API' WHERE `source` = 'UI' ;

ALTER TABLE `publish_request` ADD COLUMN `package_id` VARCHAR(50) NULL ;

UPDATE _meta SET version = '3.0.11.2' ;