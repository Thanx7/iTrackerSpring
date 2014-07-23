issueTracker-3.0
Important:
Spring MVC implemented

issueTracker-2.4
Important:
1. The following life cycle scheme is partly implemented:

Status

1 New			status
				1, 2
				resolution
				0 (disabled)

2 Assigned		status
				2, 3
				resolution
				0 (disabled)

3 In Progress	status
				3, 4, 5
				resolution
				3: 0 (disabled)
				4, 5: >0 (enabled)

4 Resolved		status
				4, 5 ,6

5 Closed		status
				5 ,6

6 Reopened		status
				1, 2
				resolution
				0 (disabled)


issueTracker-2.3
Important:
1. Resolutions were added (All resolutions, add resolution).
2. Life cycle of issue is partly implemented.

issueTracker-2.2
Important:
1. Guest can see the issue.
2. Page with statuses is created.
3. It is possible to update statuses now.

issueTracker-2.1
Important:
1. Gson. While editing issue, we receive only those builds, which are present in the chosen project.

issueTracker-2.0
Important:
1. Most of validations (for example empty fields) pass with the help of Javascript instead of server.
2. Projects and Builds have been added.
3. Statuses have been updated.
4. From now on I do not use HQL, but only interface Criteria.

issueTracker-1.4
Important:
1. Application developed using JDBC was converted into Hibernate ORM.

issueTracker-1.3
Important:
1. Users can sort columns.


issueTracker-1.2
Important:
1. You can see all previous comments on the Edit page.
2. You can add the comment on the Edit page.


issueTracker-1.1
Important:
1. Programm uses Derby database instead of xml now.
2. Passwords are crypted with CryptWithMD5.
3. User/Admin can submit issue.
4. User/Admin can update issue.