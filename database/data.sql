INSERT INTO `role` (`id`, `name`) VALUES ('1', 'admin');
INSERT INTO `role` (`id`, `name`) VALUES ('2', 'sup');
INSERT INTO `role` (`id`, `name`) VALUES ('3', 'user');

INSERT INTO `user` (`id`, `password`, `username`) VALUES ('1', '$2a$10$ZAtx9YUEBQa0un9/DRuM2.EJ5HzISAdASZP7beScbgqw2LX846QhK', 'admins');
INSERT INTO `user` (`id`, `password`, `username`) VALUES ('2', '$2a$10$ZAtx9YUEBQa0un9/DRuM2.EJ5HzISAdASZP7beScbgqw2LX846QhK', 'Epis1');
INSERT INTO `user` (`id`, `password`, `username`) VALUES ('3', '$2a$10$ZAtx9YUEBQa0un9/DRuM2.EJ5HzISAdASZP7beScbgqw2LX846QhK', 'Epis11');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('3', '3');

INSERT INTO `MASTER_DATA` (`value`, `text`, `group`) VALUES ('N', 'NON_VAT', 'vat_rate');
INSERT INTO `MASTER_DATA` (`value`, `text`, `group`) VALUES ('0', '0', 'vat_rate');
INSERT INTO `MASTER_DATA` (`value`, `text`, `group`) VALUES ('3', '3', 'vat_rate');
INSERT INTO `MASTER_DATA` (`value`, `text`, `group`) VALUES ('7', '7', 'vat_rate');