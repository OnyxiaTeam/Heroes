Project workflow
======

1. Features and bug fixes are managed on iterations (hereinafter called "Sprint")
2. Each Sprint is 2 days long
3. A Sprint starts with new features going to be implemented and expands to raised bugs by the QA either from the current or past sprint
4. Each bug/new feature should be logged in a new Issue with an assignee and to a Sprint
5. If there is a good reason (e.g.: the assignee has already too many assigned tickets, or the bugfix might break the current functionality) an issue might be rescheduled for another Sprint
6. When a task is completed it should be commited with a comment - what is done and the issue ID (e.g.: "Fixed bug with negative units' life #221") and afterwards closed.
7. When the QA has no other work to do i.e. all its tasks are done, one should detect the closed issue and test them. If there are bugs and there is not enough time to fix them, reopen the ticket and reschedule for next Sprint
8. When the Sprint finishes all the issues should be either closed or rescheduled for next sprint. The QA should test each closed ticket and either reopen and reschedule for next sprint, or comment with verified if everything is done.
9. When the QA has rescheduled/verified the tickets, the rest of the Sprint should be integrated by the Integrator, archived in an archive with the same name as the Sprint name and staged in the "builds" folder
10. See 3.
