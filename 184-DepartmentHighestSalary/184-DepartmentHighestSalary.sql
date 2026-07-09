-- Last updated: 7/9/2026, 10:06:13 AM
SELECT d.Name AS Department,
       e.Name AS Employee,
       e.Salary
FROM Employee e
JOIN Department d
ON e.DepartmentId = d.Id
WHERE (e.DepartmentId, e.Salary) IN (
    SELECT DepartmentId,
           MAX(Salary)
    FROM Employee
    GROUP BY DepartmentId
);