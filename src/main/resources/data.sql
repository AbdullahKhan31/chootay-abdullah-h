INSERT INTO `role` (`role_id`, `role`) VALUES (1, 'ADMIN');
INSERT INTO `role` (`role_id`, `role`) VALUES (2, 'MANAGER');
INSERT INTO `role` (`role_id`, `role`) VALUES (3, 'MECHANIC');
INSERT INTO `role` (`role_id`, `role`) VALUES (4, 'SALESPERSON');
INSERT INTO `user` (`user_id`, `email`, `name`, `password`) VALUES (1, 'chootay@gmail.com', 'chootay', 'password');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '1')