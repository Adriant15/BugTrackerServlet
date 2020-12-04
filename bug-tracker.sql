CREATE DATABASE  IF NOT EXISTS bug_tracker;
USE bug_tracker;
--
-- Table structure for table `bug_tracker`
--
DROP TABLE IF EXISTS bug_tracker;
CREATE TABLE bug (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(120) DEFAULT NULL,
  issue varchar(250) DEFAULT NULL,
  reporter varchar(45) DEFAULT NULL,
  created varchar(10) DEFAULT NULL,
  due varchar(10) DEFAULT NULL,
  severity varchar(8) DEFAULT NULL,
  bugStatus varchar(9) DEFAULT NULL,
  PRIMARY KEY (id)
);
--
-- Dumping data for table `student`
--
LOCK TABLES bug WRITE;
INSERT INTO bug VALUES 
(1,'Tomcat Connection Error','Cannot connect to MySQL using Tomcat. Needed to reset login information. Issue resolved.','ATO','11/24/20', '11/25/20', 'HIGH', 'COMPLETED'),
(2,'Calender does not appear in date select','When selecting due date in add-bug-form.jsp or update-bug-form, browser does not provide a calendar to select date. It does, however, work in Chomre and firefox','ATO','11/24/20', '12/25/20', 'LOW', 'OPEN'),
(3,'SQL error reading bugStatus value from database','Resolve: data saved in database for bugStatus was not in uppercase. When data is requested and converted to ENUM, value must first be converted to uppercase then to ENUM. ','ATO','11/24/20', '11/26/20', 'HIGH', 'COMPLETED'),
(4,'Due date not typed','Due date is type varchar so user can input any string. Require additional code to ensure inpupt is a date of format YYYY-MM-DD.','ATO','11/24/20', '12/24/20', 'LOW', 'OPEN'),
(5,'SQL error writing database','Length of issue was too long causing SQL error when adding/updating bug. Resolved: increased issue varchar from 100 to 250. Updated textarea placeholder value to 250','ATO','11/24/20', '11/24/20', 'HIGH', 'OPEN');
UNLOCK TABLES;

