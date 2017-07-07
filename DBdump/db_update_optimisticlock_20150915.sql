ALTER TABLE `proj90007`.`peformance_review` 
ADD COLUMN `last_update_date` DATETIME NULL COMMENT '' AFTER `compliance`;
UPDATE `proj90007`.`peformance_review` SET `last_update_date`='2015-09-13 14:36:58';
ALTER TABLE `proj90007`.`profile` 
ADD COLUMN `last_update_date` DATETIME NULL COMMENT '' AFTER `description`;