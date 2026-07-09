-- Last updated: 7/9/2026, 10:06:27 AM
SELECT score,
       DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM Scores;