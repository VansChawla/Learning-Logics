SELECT ROUND(SUM(tiv_2016)::NUMERIC, 2) AS tiv_2016
FROM Insurance
WHERE tiv_2015 IN (
    -- 1. Get tiv_2015 values shared by multiple policyholders
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
)
AND (lat, lon) IN (
    -- 2. Get location pairs that are completely unique
    SELECT lat, lon
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
);