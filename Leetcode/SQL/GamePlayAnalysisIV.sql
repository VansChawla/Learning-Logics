SELECT 
    ROUND(
        COUNT(a.player_id)::NUMERIC / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
) fl
JOIN Activity a 
  ON fl.player_id = a.player_id 
 AND a.event_date = fl.first_date + INTERVAL '1 day';
