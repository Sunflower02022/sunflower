CREATE TABLE `tb_produto` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`preco` DECIMAL(255) NOT NULL,
	`descricao` varchar(1000) NOT NULL,
	`quantidade` int(255) NOT NULL,
	`fk_categoria` bigint(255) NOT NULL,
	`fk_usuario` bigint(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`senha` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_categoria` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome_categoria` varchar(255) NOT NULL,
	`status` BOOLEAN(255) NOT NULL AUTO_INCREMENT,
	`ebook_cat` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk0` FOREIGN KEY (`fk_categoria`) REFERENCES `tb_categoria`(`id`);

ALTER TABLE `tb_produto` ADD CONSTRAINT `tb_produto_fk1` FOREIGN KEY (`fk_usuario`) REFERENCES `tb_usuario`(`id`);




