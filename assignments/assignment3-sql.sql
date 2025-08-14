-- 1. Count tasks by status
SELECT status, COUNT(*) AS total
FROM tasks
GROUP BY status;

-- 2. List users with no assigned tasks
SELECT u.id, u.name
FROM users u
LEFT JOIN tasks t ON u.id = t.user_id
WHERE t.id IS NULL;

-- 3. Most recently updated task
SELECT *
FROM tasks
ORDER BY updated_at DESC
LIMIT 1;

-- 4. Join Task and User
SELECT t.id, t.title, u.name AS assigned_user
FROM tasks t
JOIN users u ON t.user_id = u.id;
