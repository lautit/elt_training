SELECT * FROM ctscandidates.timeline;
SELECT * FROM ctscandidates.event;
SELECT * FROM ctscandidates.possibleevents;
#'YYYY-MM-DD HH:MM:SS'
SELECT * FROM ctscandidates.timeline_event;

truncate ctscandidates.possibleevents;
insert into ctscandidates.possibleevents (eventId, htmlId, name)
values	(1, 'newCandidate', 'New Candidate'),
		(2, 'firstCall', 'First Call'),
		(3, 'firstInterview', 'First Interview'),
		(4, 'techInterview', 'Tech Interview'),
		(5, 'healthTests', 'Health Tests'),
		(6, 'hired', 'Hired');
truncate ctscandidates.timeline;
insert into ctscandidates.timeline (timelineId, cancelDate, initDate)
values	(1, '0001-01-01 00:00:00.0', '2016-09-10 15:21:00.0'),
		(2, '0001-01-01 00:00:00.0', '2016-09-11 15:21:00.0'),
		(3, '0001-01-01 00:00:00.0', '2016-09-12 15:21:00.0'),
		(4, '0001-01-01 00:00:00.0', '2016-09-13 15:21:00.0'),
		(5, '0001-01-01 00:00:00.0', '2016-09-14 15:21:00.0'),
		(6, '0001-01-01 00:00:00.0', '2016-09-15 15:21:00.0');
truncate ctscandidates.event;
insert into ctscandidates.event (eventId, date, description, name)
values	(1, '2016-09-10 15:21:00.0', 'Dummy', 'New Candidate'),
        (2, '2016-09-11 15:21:00.0', 'Dummy', 'New Candidate'),
		(3, '2016-09-12 15:21:00.0', 'Dummy', 'New Candidate'),
        (4, '2016-09-13 15:21:00.0', 'Dummy', 'New Candidate'),
		(5, '2016-09-14 15:21:00.0', 'Dummy', 'New Candidate'),
		(6, '2016-09-15 15:21:00.0', 'Dummy', 'New Candidate'),
		(7, '2016-09-15 16:21:00.0', 'Dummy', 'First Call'),
		(8, '2016-09-15 17:21:00.0', 'Dummy', 'First Interview'),
		(9, '2016-09-15 18:21:00.0', 'Dummy', 'Tech Interview');
truncate ctscandidates.timeline_event;
insert into ctscandidates.timeline_event (Timeline_timelineId, events_eventId)
values	(1, 1),
		(2, 2),
        (3, 3),
        (4, 4),
        (5, 5),
        (6, 6),
		(6, 7),
        (6, 8),
        (6, 9);