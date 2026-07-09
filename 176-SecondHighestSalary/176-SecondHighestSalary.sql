-- Last updated: 7/9/2026, 10:06:30 AM
SELECT (
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;