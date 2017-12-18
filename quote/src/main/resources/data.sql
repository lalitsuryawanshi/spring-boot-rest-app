INSERT INTO  language (language_id, language_name) VALUES ('1', 'English');
INSERT INTO  language (language_id, language_name) VALUES ('2', 'Spanish');

INSERT INTO  school (school_id, school_name, school_country, school_location) VALUES ('1', 'Manchester', 'United Kingdom', 'Manchester');
INSERT INTO  school (school_id, school_name, school_country, school_location) VALUES ('2', 'Liverpool', 'United Kingdom', 'Liverpool');
INSERT INTO  school (school_id, school_name, school_country, school_location) VALUES ('3', 'Dublin', 'Ireland', 'Dublin');

INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('1', '1', '2-8', 'Two to Eight Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('2', '1', '9-12', 'Nine to Twelve Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('3', '1', '13-23', 'Thirteen to Twenty Three Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('4', '1', '24-36', 'Twenty Four to Thitry Six Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('5', '1', '36+', 'More than Thirty Six Students');

INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('6', '2', '2-8', 'Two to Eight Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('7', '2', '9-12', 'Nine to Twelve Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('8', '2', '13-23', 'Thirteen to Twenty Three Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('9', '2', '24-36', 'Twenty Four to Thitry Six Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('10', '2', '36+', 'More than Thirty Six Students');

INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('11', '3', '1-4', 'One to Four Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('12', '3', '5-8', 'Five to Eight Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('13', '3', '9-24', 'Nine to Tewnty Four Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('14', '3', '25-35', 'Twenty Five to Thirty Five Students');
INSERT INTO  studentgroup (studentgroup_id, school_id, group_name, group_desc) VALUES ('15', '3', '36+', 'More than Thirty Six Students');

INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('1', '1', 'GE (15 hrs/w)', '15', '230', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('2', '1', 'IE (20 hrs/w)', '20', '275', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('3', '1', 'SIE (25 hrs/w)', '25', '325', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('4', '1', 'IELTS Exam (20 hrs/w)', '20', '275', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('5', '1', 'Junior English', '15', '0', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('6', '1', 'Single Sex (20 hrs/w)', '20', '280', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('7', '1', 'One to One (1 hr/w)', '1', '60', '1');

INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('8', '2', 'GE (15 hrs/w)', '15', '195', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('9', '2', 'IE (20 hrs/w)', '20', '240', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('10', '2', 'SIE (25 hrs/w)', '25', '290', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('11', '2', 'IELTS Exam (20 hrs/w)', '20', '240', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('12', '2', 'Junior English', '15', '0', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('13', '2', 'Single Sex (20 hrs/w)', '20', '280', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('14', '2', 'One to One (1 hr/w)', '1', '60', '1');

INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('15', '3', 'GE (15 hrs/w)', '15', '230', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('16', '3', 'IE (20 hrs/w)', '20', '310', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('17', '3', 'IELTS Exam (20 hrs/w)', '20', '340', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('18', '3', '25 WGE (15 hrs/w)', '15', '0', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('19', '3', '25 WIE (15 hrs/w)', '20', '0', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('20', '3', 'FCE Preparation (15 hrs/w)', '15', '0', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('21', '3', 'Junior English (15 hrs/w)', '15', '0', '1');
INSERT INTO  course (course_id, school_id, course_name, course_hours, course_price, language_id) VALUES ('22', '3', 'One to One', '1', '65', '1');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('1', '1', '1', '230');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('2', '1', '2', '220');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('3', '1', '3', '215');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('4', '1', '4', '205');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('5', '1', '5', '195');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('6', '2', '1', '275');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('7', '2', '2', '270');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('8', '2', '3', '265');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('9', '2', '4', '255');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('10', '2', '5', '245');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('11', '3', '1', '325');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('12', '3', '2', '320');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('13', '3', '3', '315');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('14', '3', '4', '305');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('15', '3', '5', '295');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('16', '4', '1', '275');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('17', '4', '2', '270');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('18', '4', '3', '265');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('19', '4', '4', '255');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('20', '4', '5', '245');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('21', '6', '1', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('22', '6', '2', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('23', '6', '3', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('24', '6', '4', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('25', '6', '5', '280');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('26', '7', '1', '60');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('27', '8', '1', '195');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('28', '8', '2', '190');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('29', '8', '3', '185');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('30', '8', '4', '175');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('31', '8', '5', '165');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('32', '9', '1', '240');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('33', '9', '2', '235');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('34', '9', '3', '230');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('35', '9', '4', '220');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('36', '9', '5', '210');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('37', '10', '1', '290');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('38', '10', '2', '285');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('39', '10', '3', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('40', '10', '4', '270');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('41', '10', '5', '260');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('42', '11', '1', '240');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('43', '11', '2', '235');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('44', '11', '3', '230');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('45', '11', '4', '220');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('46', '11', '5', '210');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('47', '13', '1', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('48', '13', '2', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('49', '13', '3', '230');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('50', '13', '4', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('51', '13', '5', '280');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('52', '14', '1', '60');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('53', '15', '1', '230');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('54', '15', '2', '220');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('55', '15', '3', '210');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('56', '15', '4', '200');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('57', '15', '5', '190');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('58', '16', '1', '310');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('59', '16', '2', '300');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('60', '16', '3', '290');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('61', '16', '4', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('62', '16', '5', '270');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('63', '17', '1', '340');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('64', '17', '2', '330');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('65', '17', '3', '290');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('66', '17', '4', '280');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('67', '17', '5', '270');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('68', '18', '4', '3250');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('69', '19', '4', '3950');

INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('70', '22', '1', '65');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('71', '22', '2', '65');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('72', '22', '3', '65');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('73', '22', '4', '65');
INSERT INTO  groupprice (groupprice_id, course_id, studentgroup_id, price) VALUES ('74', '22', '5', '65');

INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('1', '1', 'Home stay (standard)', '150');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('2', '1', 'Home stay (twin room)', '135');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('3', '1', 'Home stay (En suite)', '220');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('4', '1', 'Student Residential', '190');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('5', '1', 'N/A', '0');

INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('6', '2', 'Home stay (standard)', '150');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('7', '2', 'Home stay (twin room)', '130');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('8', '2', 'Student Residential', '145');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('9', '2', 'Studio Apartment', '220');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('10', '2', 'N/A', '0');

INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('11', '3', 'Home stay (single, full)', '215');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('12', '3', 'Home stay (twin, full)', '200');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('13', '3', 'Home stay (single, half)', '200');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('14', '3', 'Home stay (twin, half)', '187');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('15', '3', 'Home stay (bathroom, half)', '215');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('16', '3', 'Residence (twin)', '180');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('17', '3', 'Residence (triple)', '160');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('18', '3', 'Residence (quadruple)', '140');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('19', '3', 'Shared house (single)', '220');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('20', '3', 'Shared house (twin)', '185');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('21', '3', 'Bed & Breakfast (single)', '490');
INSERT INTO  accommodation (accommodation_id, school_id, accommodation_name, price) VALUES ('22', '3', 'N/A', '0');

INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('1', '1', 'Accommodation Booking Fee', '60');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('2', '1', 'Enrolment Fee', '60');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('3', '1', 'Course Book', '30');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('4', '1', 'Courier Fee', '70');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('5', '1', 'School change', '100');

INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('6', '2', 'Accommodation Booking Fee', '60');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('7', '2', 'Enrolment Fee', '60');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('8', '2', 'Course Book', '30');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('9', '2', 'Courier Fee', '70');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('10', '2', 'School change', '100');

INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('11', '3', 'Accommodation Booking Fee', '50');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('12', '3', 'Enrolment Fee', '50');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('13', '3', 'Insurance for +25 weeks', '110');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('14', '3', 'Course Book', '40');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('15', '3', 'Courier Fee', '70');
INSERT INTO  servicefee (servicefee_id, school_id, service_name, service_price) VALUES ('16', '3', 'School change', '100');

INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('1', '1', 'Airport Pickup', '60');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('2', '1', 'Special Diet', '20');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('3', '1', 'Under 18', '20');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('4', '1', 'Late Check in', '50');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('5', '1', 'Extra night', '30');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('6', '1', 'Summer supplement', '30');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('7', '1', 'Accommodation change fee', '50');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('8', '1', 'Insurance', '8');

INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('9', '2', 'Airport Pickup', '60');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('10', '2', 'Special Diet', '20');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('11', '2', 'Under 18', '20');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('12', '2', 'Late Check in', '50');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('13', '2', 'Extra night', '30');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('14', '2', 'Summer supplement', '30');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('15', '2', 'Accommodation change fee', '50');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('16', '2', 'Insurance', '8');

INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('17', '3', 'Airport Pickup', '60');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('18', '3', 'Special Diet', '25');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('19', '3', 'Late Check in', '50');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('20', '3', 'Extra night', '40');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('21', '3', 'Summer supplement', '20');
INSERT INTO  extrafee (extrafee_id, school_id, extra_name, extra_price) VALUES ('22', '3', 'Accommodation change fee', '50');

INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('1', 'Alyona', 'Alyona@example.com', '+44 (0)7825 084 399');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('2', 'Angelica', 'Angelica@example.com', '+52(1) 5513649388');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('3', 'Erika', 'Erika@example.com', '+44(0)7551739169');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('4', 'Mohamed', 'Mohamed@example.com', '+44(0) 7827335095');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('5', 'Saad', 'Saad@example.com', '+44(0)7956749397');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('6', 'Saeed', 'Saeed@example.com', '+44 (0)7984933145');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('7', 'Sophie', 'Sophie@example.com', '+44 (0)151 236 2749');
INSERT INTO  seller (seller_id, seller_name, seller_email, seller_phone) VALUES ('8', 'Vinny', 'Vinny@example.com', '+55 (11) 97549-9773');
