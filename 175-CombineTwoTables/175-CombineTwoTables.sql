-- Last updated: 7/9/2026, 10:06:32 AM
SELECT p.firstName,
       p.lastName,
       a.city,
       a.state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId;