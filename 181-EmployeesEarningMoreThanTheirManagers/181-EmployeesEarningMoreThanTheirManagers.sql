-- Last updated: 7/9/2026, 10:06:21 AM
SELECT e.Name AS Employee
FROM Employee e
JOIN Employee m
ON e.ManagerId = m.Id
WHERE e.Salary > m.Salary;