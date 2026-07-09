-- Last updated: 7/9/2026, 10:06:15 AM
SELECT c.Name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.Id = o.CustomerId
WHERE o.Id IS NULL;