
public class Group {

	private Integer groupId;
	private String groupName;
	
}


//		Tabele SQL:
//			
//			create table student (
//					`studentId` int(10) unsigned NOT NULL AUTO_INCREMENT,
//					`studentName` varchar(255),
//					`studentSurname` varchar(255),
//					`studentEmail` varchar(255),
//					`studentLogin` varchar(255),
//					PRIMARY KEY (`studentId`)
//			);
//		
//					create table solution (
//					`solutionId` int(10) unsigned NOT NULL AUTO_INCREMENT,
//					`solutionAuthor` int(10) unsigned NOT NULL,
//					`solutionTitle` varchar(255) DEFAULT 'default title',
//					`solutionDetails` varchar(10000) DEFAULT 'default details',
//					`solutionDate` datetime default now(),
//					PRIMARY KEY (`studentId`),
//					FOREIGN KEY (`solutionAuthor`) REFERENCES student(`studentId`)
//					);
//		
//					create table `group` (
//					`groupId` int(10) unsigned NOT NULL AUTO_INCREMENT,
//					`groupName` varchar(255)
//					);
//		
//					create table studentGroup (
//					`studentId` int(10) unsigned NOT NULL,
//					`groupId` int(10) unsigned NOT NULL,
//					PRIMARY KEY (`studentId`, `groupId`),
//					FOREIGN KEY (`studentId`) REFERENCES student(`studentId`),
//					FOREIGN KEY (`groupId`) REFERENCES `group`(`groupId`)
//					);
