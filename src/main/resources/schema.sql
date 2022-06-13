

CREATE TABLE `smm_board` (
	`bo_id` INT(11) NOT NULL AUTO_INCREMENT,
	`bo_reg_day` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00',
	`bo_title` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`bo_id`) USING BTREE
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;


INSERT INTO `smm_board` (`bo_reg_day`, `bo_title`) VALUES
('2022-06-13 16:05:58', '7b5eb68c-e99d-4ba2-9d54-3eede7236351'),
('2022-06-13 16:05:59', 'bdfb2cb7-553e-4e50-a253-4b861cc792ed');