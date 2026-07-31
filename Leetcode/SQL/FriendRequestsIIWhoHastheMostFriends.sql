WITH combined_friends AS (
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    SELECT accepter_id AS id FROM RequestAccepted
)
SELECT
    ID,
    COUNT(*) AS NUM
FROM 
    combined_friends
GROUP BY
    ID
ORDER BY
    NUM DESC
LIMIT
    1;