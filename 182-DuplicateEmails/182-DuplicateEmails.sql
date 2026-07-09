-- Last updated: 7/9/2026, 10:06:12 AM
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(*) > 1;