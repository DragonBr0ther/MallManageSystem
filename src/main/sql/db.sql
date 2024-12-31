DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(80) NOT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(40) DEFAULT NULL  COMMENT '邮箱地址',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

DROP TABLE IF EXISTS `user_address`;
CREATE TABLE IF NOT EXISTS `user_address` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint unsigned NOT NULL COMMENT '用户id',
  `name` varchar(20) DEFAULT NULL COMMENT '收件人姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '收件人电话',
  `province` varchar(20) NOT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `district` varchar(20) DEFAULT NULL COMMENT '县',
  `detail_address` varchar(100) DEFAULT NULL  COMMENT '详细地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户收货地址表';

DROP TABLE IF EXISTS `sellers`;
CREATE TABLE IF NOT EXISTS `sellers` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(80) NOT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '商家名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱地址',
  `introduction` varchar(200) DEFAULT NULL COMMENT '商家简介',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商家表';

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `seller_id` bigint unsigned NOT NULL COMMENT '商品商家id',
  `category_id` bigint unsigned NOT NULL COMMENT '商品分类id',
  `name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `introduction` varchar(200) DEFAULT NULL COMMENT '商品简介',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_seller_id` (`seller_id`) USING BTREE,
  KEY `idx_category_id` (`category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品表';

DROP TABLE IF EXISTS `product_items`;
CREATE TABLE IF NOT EXISTS `product_items` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint unsigned NOT NULL COMMENT '商品id',
  `stock_quantity` int unsigned NOT NULL COMMENT '商品库存',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `description` varchar(100) NOT NULL COMMENT '商品规格详细描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_product_id` (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品明细表';

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint unsigned DEFAULT NULL COMMENT '父类id',
  `name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品分类表';

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint unsigned NOT NULL COMMENT '用户id',
  `user_address_id` bigint unsigned NOT NULL COMMENT '用户收货地址id',
  `product_id` bigint unsigned NOT NULL COMMENT '商品id',
  `product_item_id` bigint unsigned NOT NULL COMMENT '商品明细id',
  `quantity` int unsigned NOT NULL COMMENT '购买数量',
  `price` decimal(10,2) NOT NULL COMMENT '购买价格',
  `pay_amount` decimal(10,2) NOT NULL COMMENT '订单应付金额',
  `is_paid` tinyint(1) DEFAULT 0 COMMENT '订单支付状态',
  `is_completed` tinyint(1) DEFAULT 0 COMMENT '订单完成状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_product_id` (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';